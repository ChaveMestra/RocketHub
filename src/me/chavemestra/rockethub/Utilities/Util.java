/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Utilities;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import static me.chavemestra.rockethub.RocketHub.itemStock;
import static me.chavemestra.rockethub.RocketHub.plugin;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 *
 * @author GabrielBatistella
 */
public class Util {

    private final static int CENTER_PX = 154;

    public void sendCenteredMessage(Player player, String message) {
        if (message == null || message.equals("")) {
            player.sendMessage("");
        }
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for (char c : message.toCharArray()) {
            if (c == '§') {
                previousCode = true;
                continue;
            } else if (previousCode == true) {
                previousCode = false;
                if (c == 'l' || c == 'L') {
                    isBold = true;
                    continue;
                } else {
                    isBold = false;
                }
            } else {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate) {
            sb.append(" ");
            compensated += spaceLength;
        }
        player.sendMessage(sb.toString() + message);
    }

    public void sendPlayer(final Player player, final String serverInString) {
        final ByteArrayDataOutput dataOutput = ByteStreams.newDataOutput();
        dataOutput.writeUTF("Connect");
        dataOutput.writeUTF(serverInString);
        player.sendPluginMessage(plugin, "BungeeCord", dataOutput.toByteArray());
    }

    public void setupJoin(Player p) {
        p.getInventory().clear();
        p.getEquipment().setHelmet(itemStock.capacete());
        p.getInventory().setItem(0, itemStock.compass());
        p.getInventory().setItem(4, itemStock.infos());
        p.getInventory().setItem(6, itemStock.entrarModo(false, true));
        p.getInventory().setItem(7, itemStock.entrarModo(true, false));
        porArmadura(p);
        p.setGameMode(GameMode.ADVENTURE);

    }

    public String getGrupo(Player p) {
        String prefixo = PermissionsEx.getUser(p).getGroups()[0].getPrefix();
        if (prefixo.length() >= 1) {
            return prefixo + " ";
        }
        return prefixo;
    }

    public void porArmadura(Player p) {
        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch = (LeatherArmorMeta) lchest.getItemMeta();
        lch.setColor(Color.fromRGB(255, 255, 255));
        lchest.setItemMeta(lch);
        p.getEquipment().setChestplate(lchest);

        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lch3 = (LeatherArmorMeta) lboots.getItemMeta();
        lch3.setColor(Color.fromRGB(255, 255, 255));
        lboots.setItemMeta(lch3);
        p.getEquipment().setBoots(lboots);

        ItemStack lleg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lch4 = (LeatherArmorMeta) lleg.getItemMeta();
        lch4.setColor(Color.fromRGB(255, 255, 255));
        lleg.setItemMeta(lch4);
        p.getEquipment().setLeggings(lleg);
    }

}
