/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Menu;

import static me.chavemestra.rockethub.RocketHub.itemStock;
import static me.chavemestra.rockethub.Utilities.Chat.f;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author GabrielBatistella
 */
public class Menus {
  
    public void abrirMenuSelecao(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, f("&6Servidores &eRocket&6MC"));

        ItemStack vidroVermelho = itemStock.vidroVermelho();
        ItemStack vidroLaranja = itemStock.vidroLaranja();
        ItemStack vidroAmarelo = itemStock.vidroAmarelo();
        inv.setItem(0, vidroAmarelo);
        inv.setItem(6, vidroAmarelo);
        inv.setItem(2, vidroAmarelo);
        inv.setItem(8, vidroAmarelo);
        inv.setItem(18, vidroAmarelo);
        inv.setItem(26, vidroAmarelo);
        inv.setItem(27, vidroAmarelo);
        inv.setItem(35, vidroAmarelo);
        inv.setItem(45, vidroAmarelo);
        inv.setItem(47, vidroAmarelo);
        inv.setItem(51, vidroAmarelo);
        inv.setItem(53, vidroAmarelo);
        inv.setItem(4, vidroVermelho);
        inv.setItem(10, vidroVermelho);
        inv.setItem(16, vidroVermelho);
        inv.setItem(37, vidroVermelho);
        inv.setItem(43, vidroVermelho);
        inv.setItem(49, vidroVermelho);
        inv.setItem(1, vidroLaranja);
        inv.setItem(3, vidroLaranja);
        inv.setItem(5, vidroLaranja);
        inv.setItem(7, vidroLaranja);
        inv.setItem(9, vidroLaranja);
        inv.setItem(17, vidroLaranja);
        inv.setItem(36, vidroLaranja);
        inv.setItem(44, vidroLaranja);
        inv.setItem(46, vidroLaranja);
        inv.setItem(48, vidroLaranja);
        inv.setItem(50, vidroLaranja);
        inv.setItem(52, vidroLaranja);

        inv.setItem(21, itemStock.dayz());
         inv.setItem(22, itemStock.skywars());
        inv.setItem(23, itemStock.skyblock());
        inv.setItem(40, itemStock.restaurar());
        p.openInventory(inv);
    }

}
