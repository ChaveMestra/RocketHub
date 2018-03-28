/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Utilities;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.chavemestra.rockethub.Log.LogUtil;
import me.chavemestra.rockethub.Log.LogUtil.TipoLog;
import static me.chavemestra.rockethub.Log.LogUtil.log;
import static me.chavemestra.rockethub.RocketHub.dbManager;
import static me.chavemestra.rockethub.Utilities.Chat.f;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author GabrielBatistella
 */
public class Holos {

    private Hologram topKills = null;
    private Hologram topParkour = null;

    public Holos(Plugin p) {
        try {
            log("Inicializando Hologramas..", TipoLog.Inicializacao);
            topKills = HologramsAPI.createHologram(p, new Location(Bukkit.getWorld("Lobby"), 4, 41, 15));
            topParkour = HologramsAPI.createHologram(p, new Location(Bukkit.getWorld("Lobby"), -7, 41, 16));
            Holos.this.updateHolos();
            log("Holos inicializados!", LogUtil.TipoLog.Inicializacao);
            new BukkitRunnable() {
                @Override
                public void run() {
                    try {
                        Holos.this.updateHolos();
                    } catch (SQLException ex) {
                        Logger.getLogger(Holos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }.runTaskTimer(p, 0, 1000L);
        } catch (SQLException ex) {
            Logger.getLogger(Holos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateHolos() throws SQLException {
        topKills.clearLines();
        topParkour.clearLines();
        topKills.appendItemLine(new ItemStack(Material.DIAMOND_SWORD, 1));
        topKills.appendTextLine(f("&e&lTOP 5 Kills &3[&bHubs&3]"));
        topParkour.appendItemLine(new ItemStack(Material.LEATHER_BOOTS, 1));
        topParkour.appendTextLine(f("&e&lTOP 5 Tempo de Parkour &3[&bHubs&3]"));
        ResultSet topKillsRs = dbManager.executeQueryLivre("SELECT name,kills FROM Rocket_Hub ORDER BY kills DESC limit 5");
        ResultSet topParkourRs = dbManager.executeQueryLivre("SELECT name,tempoParkour FROM Rocket_Hub ORDER BY tempoParkour ASC limit 5");
        int count = 0;
        while (topKillsRs.next()) {
            count++;
            topKills.appendTextLine(f("&5#&d" + count + " &fJogador: &e" + topKillsRs.getString("name") + " &fKills: &e" + topKillsRs.getInt("kills")));
        }
        count = 0;
        while (topParkourRs.next() && topParkourRs.getInt("tempoParkour") != 0) {
            count++;
            topParkour.appendTextLine(f("&5#&d" + count + " &fJogador: &e" + topParkourRs.getString("name") + " &fTempo: &e" + topParkourRs.getDouble("tempoParkour") + "s"));
        }
    }

}
