/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Menu;

import java.util.ArrayList;
import me.chavemestra.rockethub.Log.LogUtil.TipoLog;
import static me.chavemestra.rockethub.Log.LogUtil.log;
import static me.chavemestra.rockethub.Utilities.Chat.f;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 *
 * @author GabrielBatistella
 */
public class ItemStock {

    public ItemStock() {
        log("ItemStock instanciado.", TipoLog.Inicializacao);
    }

    public ItemStack capacete() {
        SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        meta.setOwner("ByVoltz");

        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        stack.setItemMeta(meta);
        meta.setDisplayName(f("&bCapacete de Astronauta"));
        ArrayList lore = new ArrayList();
        lore.add(f("&eSorria! Voce esta no &6RocketMC"));
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    public ItemStack compass() {
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(f("&aServidores &7(Clique Direito)"));
        ArrayList lore = new ArrayList();
        lore.add(f("&fClique com o botão direito para ver os"));
        lore.add(f("&fservidores disponiveis na rede RocketMC"));
        meta.setLore(lore);
        compass.setItemMeta(meta);
        return compass;
    }

    public ItemStack lobby() {
        ItemStack compass = new ItemStack(Material.BEACON, 1);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(f("&bTrocar de Hub &7(Clique Direito)"));
        ArrayList lore = new ArrayList();
        lore.add(f("&fClique com o botão direito para"));
        lore.add(f("&ftrocar de lobby"));
        meta.setLore(lore);
        compass.setItemMeta(meta);
        return compass;
    }

    public ItemStack infos() {
        ItemStack compass = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(f("&eLinks &7(Clique Direito)"));
        ArrayList lore = new ArrayList();
        lore.add(f("&fClique com o botão direito para ver os"));
        lore.add(f("&flinks da rede RocketMC"));
        meta.setLore(lore);
        compass.setItemMeta(meta);
        return compass;
    }

    public ItemStack dayz() {
        ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(f("&aDayZ &e&l1.8.X"));
        ArrayList lore = new ArrayList();
        lore.add(f("&7Olhos bem abertos, pois zumbis não"));
        lore.add(f("&7serão sua única ameaça.."));
        lore.add("");
        lore.add(f("&aClique para conectar "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack restaurar() {
        ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(f("&e&lRESTAURAR TEXTURA"));
        ArrayList lore = new ArrayList();
        lore.add(f("&aClique aqui para remover a"));
        lore.add(f("&atextura atual e retornar ao padrao"));
        lore.add("");
        lore.add(f("&aClique para remover"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack skyblock() {
        ItemStack item = new ItemStack(Material.GRASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(f("&aSkyblock &e&l1.8 - 1.12"));
        ArrayList lore = new ArrayList();
        lore.add(f("&7Um mundo onde o céu não é o limite! Construa,"));
        lore.add(f("&7seja criativo, batalhe, evolua, seja poderoso!"));
        lore.add("");
        lore.add(f("&aClique para conectar "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack skywars() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(f("&aSkywars &e&l1.8 - 1.12"));
        ArrayList lore = new ArrayList();
        lore.add(f("&7Batalhe nas nuvens em busca de honra!"));
        lore.add(f("&7Compre kits, efeitos, caixas e lidere!"));
        lore.add("");
        lore.add(f("&aClique para conectar "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack sairModo(boolean parkour, boolean pvp) {

        ItemStack item = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = item.getItemMeta();
        if (parkour) {
            meta.setDisplayName(f("&cSair do Parkour &7(Clique Direito)"));
        } else if (pvp) {
            meta.setDisplayName(f("&cSair do PVP &7(Clique Direito)"));
        }
        ArrayList lore = new ArrayList();
        lore.add(f("&7Clique com o botao direito para entrar no modo!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack entrarModo(boolean parkour, boolean pvp) {

        ItemStack item;
        if (parkour) {
            item = new ItemStack(Material.LEATHER_BOOTS, 1);
        } else {
            item = new ItemStack(Material.GOLDEN_APPLE, 1);
        }

        ItemMeta meta = item.getItemMeta();
        if (parkour) {
            meta.setDisplayName(f("&aEntrar no Parkour &7(Clique Direito)"));
        } else if (pvp) {
            meta.setDisplayName(f("&aEntrar em Modo PVP &7(Clique Direito)"));
        }
        ArrayList lore = new ArrayList();
        lore.add(f("&7Clique com o botao direito para entrar no modo!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack HUB(int i) {
        ItemStack item = new ItemStack(Material.BEACON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(f("&bHub &l#" + i));
        ArrayList lore = new ArrayList();
        lore.add("");
        lore.add(f("&aClique para conectar "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack vidroAmarelo() {
        ItemStack vidroAmarelo = new ItemStack(160, 1, (byte) 4);
        ItemMeta meta = vidroAmarelo.getItemMeta();
        meta.setDisplayName(f("&f"));
        vidroAmarelo.setItemMeta(meta);
        return vidroAmarelo;
    }

    public ItemStack vidroLaranja() {
        ItemStack vidroAmarelo = new ItemStack(160, 1, (byte) 1);
        ItemMeta meta = vidroAmarelo.getItemMeta();
        meta.setDisplayName(f("&f"));
        vidroAmarelo.setItemMeta(meta);
        return vidroAmarelo;
    }

    public ItemStack vidroVermelho() {
        ItemStack vidroAmarelo = new ItemStack(160, 1, (byte) 14);
        ItemMeta meta = vidroAmarelo.getItemMeta();
        meta.setDisplayName(f("&f"));
        vidroAmarelo.setItemMeta(meta);
        return vidroAmarelo;
    }

}
