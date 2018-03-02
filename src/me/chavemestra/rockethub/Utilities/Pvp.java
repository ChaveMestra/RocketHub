/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Utilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import static me.chavemestra.rockethub.RocketHub.dbManager;
import static me.chavemestra.rockethub.RocketHub.itemStock;
import static me.chavemestra.rockethub.RocketHub.lobby;
import static me.chavemestra.rockethub.RocketHub.utilidades;
import static me.chavemestra.rockethub.Utilities.Chat.f;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author GabrielBatistella
 */
public class Pvp implements Listener {

    public static ArrayList<UUID> pvp;
    public static HashMap<String, Long> pvpCooldown;

    public Pvp() {
        pvp = new ArrayList();
        pvpCooldown = new HashMap();
    }

    public boolean emPvp(Player p) {
        return pvp.contains(p.getUniqueId());
    }

    public boolean podePvp(Player p) {
        String uuid = p.getUniqueId().toString();
        if (!pvpCooldown.containsKey(uuid)) {
            pvpCooldown.put(uuid, System.currentTimeMillis() / 1000 + 30);

            return true;
        }
        if (pvpCooldown.get(uuid) <= System.currentTimeMillis() / 1000) {
            pvpCooldown.replace(uuid, System.currentTimeMillis() / 1000 + 30);

            return true;
        }
        p.sendMessage(f("&7Aguarde para fazer isso novamente"));
        return false;
    }

    public void setarItensPvp(Player p) {
        p.getInventory().setChestplate(itemStock.armaduraPvp()[0]);
        p.getInventory().setHelmet(itemStock.armaduraPvp()[1]);
        p.getInventory().setLeggings(itemStock.armaduraPvp()[2]);
        p.getInventory().setBoots(itemStock.armaduraPvp()[3]);
        p.getInventory().addItem(itemStock.armasPvp());
    }

    public boolean colocaPvp(Player p) {
        if (!emPvp(p) && podePvp(p)) {
            //coloco na lista antes pra evitar bugs sinistros
            pvp.add(p.getUniqueId());
            p.sendMessage(f("&6&l[&ePVP&6&l] &aVoce entrou em modo PVP! Voce agora pode matar quem também estiver neste modo!"));
            //coloca armadura e tausss
            p.getInventory().clear();
            p.getInventory().setArmorContents(new ItemStack[3]);
            p.getInventory().setItem(8, itemStock.sairModo(false, true));
            setarItensPvp(p);

            return true;
        }
        return false;
    }

    public boolean saiuPvp(Player p) {
        if (emPvp(p)) {
            p.getInventory().clear();
            pvp.remove(p.getUniqueId());
            //tiro da lista dps de todo processo pra evitar bugs cabulosos
            utilidades.setupJoin(p);
            p.teleport(lobby);
            p.setHealth(20);
            p.sendMessage(f("&6&l[&ePVP&6&l] &aVoce saiu do modo PVP! Voce agora esta protegido!"));
            return true;
        }
        return false;
    }

    public void morreu(Player p, Player matador) throws SQLException {
        saiuPvp(p);
        dbManager.increaseKills(matador.getUniqueId().toString());
        p.teleport(lobby);
        p.setHealth(20);
        p.sendMessage(f("&cVoce morreu.."));
        Bukkit.broadcastMessage(f("&6&l[&ePVP&6&l] &r" + utilidades.getGrupo(p) + "&f" + p.getName() + " &efoi morto por &r" + utilidades.getGrupo(matador) + "&f" + matador.getName()));
        utilidades.setupJoin(p);

    }

    //handle de hits
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) throws SQLException {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player atacante = (Player) e.getDamager();
            Player vitima = (Player) e.getEntity();
            if (!emPvp(atacante) || !emPvp(vitima)) {
                e.setCancelled(true);
            } else {
                if (e.getFinalDamage() >= vitima.getHealth()) {
                    e.setCancelled(true);
                    morreu(vitima, atacante);
                }
            }
        }
        if (e.getDamager() instanceof Projectile) {
            Projectile proj = (Projectile) e.getDamager();
            if (proj.getShooter() instanceof Player && e.getEntity() instanceof Player) {
                Player vitima = (Player) e.getEntity();
                if (!emPvp((Player) proj.getShooter()) || !emPvp(vitima)) {
                    e.setCancelled(true);
                } else {
                    if (e.getFinalDamage() >= vitima.getHealth()) {
                        e.setCancelled(true);
                        morreu(vitima, (Player) proj.getShooter());
                    }
                }
            }
        }
    }
}
