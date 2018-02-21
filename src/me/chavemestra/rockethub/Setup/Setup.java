/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Setup;

import me.chavemestra.rockethub.Log.LogUtil;
import me.chavemestra.rockethub.Log.LogUtil.TipoLog;
import static me.chavemestra.rockethub.Log.LogUtil.log;
import me.chavemestra.rockethub.Menu.MenuListener;
import me.chavemestra.rockethub.RocketHub;
import me.chavemestra.rockethub.Utilities.Chat;
import me.chavemestra.rockethub.Menu.ItemStock;
import me.chavemestra.rockethub.Menu.Menus;
import me.chavemestra.rockethub.Utilities.JoinHandle;
import me.chavemestra.rockethub.Utilities.Protection;
import me.chavemestra.rockethub.Utilities.Pvp;
import me.chavemestra.rockethub.Utilities.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author GabrielBatistella
 */
public class Setup {
    
    public static void registerListeners(Plugin p) {
        log("Registrando listeners..", TipoLog.Inicializacao);
        Bukkit.getServer().getPluginManager().registerEvents(new Pvp(), p);
        Bukkit.getServer().getPluginManager().registerEvents(new Chat(), p);
        Bukkit.getServer().getPluginManager().registerEvents(new MenuListener(), p);
        Bukkit.getServer().getPluginManager().registerEvents(new Protection(), p);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinHandle(), p);
        log("Listeners registrados!", TipoLog.Inicializacao);
    }
    
    public static void instanceObjects(Plugin p) {
        log("Instanciando objetos..", TipoLog.Inicializacao);
        RocketHub.itemStock = new ItemStock();
        RocketHub.menus = new Menus();
        RocketHub.utilidades = new Util();
        log("Objetos instanciados!", TipoLog.Inicializacao);
    }
}
