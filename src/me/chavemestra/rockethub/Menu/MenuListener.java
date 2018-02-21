/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Menu;

import java.sql.SQLException;
import static me.chavemestra.rockethub.RocketHub.itemStock;
import static me.chavemestra.rockethub.RocketHub.menus;
import static me.chavemestra.rockethub.RocketHub.parkour;
import static me.chavemestra.rockethub.RocketHub.pvp;
import static me.chavemestra.rockethub.RocketHub.utilidades;
import static me.chavemestra.rockethub.Utilities.Chat.f;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author GabrielBatistella
 */
public class MenuListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) throws SQLException {
        if (!e.getPlayer().isOp() && !(e.getClickedBlock().getState() instanceof Sign)) {
            e.setCancelled(true);
        }
        if (e.getAction().toString().contains("RIGHT")) {
            if (e.getPlayer().getItemInHand().isSimilar(itemStock.sairModo(true, false))) {
                parkour.saiuParkour(e.getPlayer());
            }
            if (e.getPlayer().getItemInHand().isSimilar(itemStock.sairModo(false, true))) {
                pvp.saiuPvp(e.getPlayer());
            }
            if (e.getPlayer().getItemInHand().isSimilar(itemStock.entrarModo(true, false))) {
                parkour.colocaParkour(e.getPlayer());
            }
            if (e.getPlayer().getItemInHand().isSimilar(itemStock.entrarModo(false, true))) {
                pvp.colocaPvp(e.getPlayer());
            }
            if (e.getPlayer().getItemInHand() != null) {
                if (e.getPlayer().getItemInHand().isSimilar(itemStock.infos())) {
                    utilidades.sendCenteredMessage(e.getPlayer(), f(" "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&e&lLINKS &6&lROCKETMC "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f(" "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&eSite: &6www.rocketmc.com.br "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&bFacebook: &3https://goo.gl/izQHrG"));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&bTwitter: &3www.twitter.com/@rocketmc_"));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&aDiscord: &2https://goo.gl/fXycNu "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&eVote 1: &6https://goo.gl/gPJtZ2"));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&eVote 2: &6https://goo.gl/vTuFZN "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f("&aE-mail: &2contato@rocketmc.com.br "));
                    utilidades.sendCenteredMessage(e.getPlayer(), f(" "));
                    return;
                }
                if (e.getPlayer().getItemInHand().isSimilar(itemStock.compass())) {
                    menus.abrirMenuSelecao(e.getPlayer());
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null && e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.EXP_BOTTLE) {
            Player p = (Player) e.getWhoClicked();
            p.sendMessage(f("&aRestaurando textura.."));
            p.setResourcePack("https://github.com/Phoenix616/BungeeResourcepacks/blob/master/Empty.zip?raw=true");
            p.closeInventory();
        }
        if (e.getClickedInventory() != null && e.getClickedInventory().getTitle().contains(f("&6Servidores"))) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory() != null && e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.ROTTEN_FLESH) {
            Player p = (Player) e.getWhoClicked();
            utilidades.sendPlayer((Player) e.getWhoClicked(), "Dayz");
            p.closeInventory();
        }
        if (e.getClickedInventory() != null && e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.GRASS) {
            Player p = (Player) e.getWhoClicked();
            utilidades.sendPlayer((Player) e.getWhoClicked(), "Skyblock2");
            p.closeInventory();
        }
        if (e.getClickedInventory() != null && e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.BOW) {
            Player p = (Player) e.getWhoClicked();
            utilidades.sendPlayer((Player) e.getWhoClicked(), "Skywars");
            p.closeInventory();
        }

    }
}
