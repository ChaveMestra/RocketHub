/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub;

import me.chavemestra.rockethub.Menu.ItemStock;
import me.chavemestra.rockethub.Menu.Menus;
import me.chavemestra.rockethub.Setup.Setup;
import me.chavemestra.rockethub.Utilities.Parkour;
import me.chavemestra.rockethub.Utilities.Pvp;
import me.chavemestra.rockethub.Utilities.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Gabriel
 */
public class RocketHub extends JavaPlugin{

    public static Location lobby;
    public static ItemStock itemStock;
    public static Menus menus;
    public static Util utilidades;
    public static Plugin plugin;
    public static Pvp pvp;
    public static Parkour parkour;

    @Override
    public void onEnable() {
        plugin = this;
        //tem q instanciar antes pra registrar o listener que for instanciado dps
        Setup.instanceObjects(this);
        Setup.registerListeners(this);
        
        this.getServer().getMessenger().registerOutgoingPluginChannel((Plugin) this, "BungeeCord");
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag");
                lobby = new Location(Bukkit.getWorld("Lobby"), -21.500, 39, 9.500, -90, 1);
            }
        }.runTaskLater(this, 50L);
    }

    @Override
    public void onDisable() {
    }
}
