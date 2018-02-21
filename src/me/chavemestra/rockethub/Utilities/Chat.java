/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Utilities;

import java.util.HashMap;
import static me.chavemestra.rockethub.RocketHub.utilidades;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 *
 * @author GabrielBatistella
 */
public class Chat implements Listener {

    private HashMap<String, Long> chatCooldown = new HashMap();

    public static String f(String message) {
        String messageFormated = message
                .replace("&", "§");
        messageFormated = messageFormated.replace("%", " porcento");
        return messageFormated;
    }
    
      
    

    public boolean podeChat(Player p) {
        String uuid = p.getUniqueId().toString();
        if (!chatCooldown.containsKey(uuid)) {
            chatCooldown.put(uuid, System.currentTimeMillis() / 1000 + 3);

            return true;
        }
        if (chatCooldown.get(uuid) <= System.currentTimeMillis() / 1000) {
            chatCooldown.replace(uuid, System.currentTimeMillis() / 1000 + 3);

            return true;
        }
        p.sendMessage(f("&7Aguarde para fazer isso novamente"));
        return false;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.getMessage().contains("http") || e.getMessage().contains("www") || e.getMessage().contains(".com")
                || e.getMessage().contains(".br")
                || e.getMessage().contains(".tk")
                || e.getMessage().contains(".net")
                || e.getMessage().contains("jogar.")
                || e.getMessage().contains("mc.")
                || e.getMessage().contains("play.")) {
            e.setCancelled(true);
            return;
        }
        if (!podeChat(e.getPlayer())) {
            e.setCancelled(true);
            return;
        }
        e.setFormat(f(utilidades.getGrupo(e.getPlayer()) + e.getPlayer().getName() + "&f: &7") + e.getMessage());

    }
}
