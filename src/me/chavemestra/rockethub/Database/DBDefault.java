/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Supplier;
import java.util.logging.Level;
import static org.bukkit.Bukkit.getLogger;
import org.bukkit.ChatColor;

/**
 *
 * @author Gabriel
 */
public class DBDefault {

    private Connection connection;
    private Statement st;

    public void iniciarBanco() {
        getLogger().log(Level.INFO, "{0}DATABASE", ChatColor.DARK_AQUA);
        try {

            this.connection = rpgConnection();
            this.st = this.connection.createStatement();
            this.st.executeUpdate("create table if not exists Rocket_Hub "
                    + "(UUID varchar(100) primary key"
                    + ", name varchar(50)"
                    + ", kills int DEFAULT '0'"
                    + ", tempoParkour double DEFAULT '0')");

           

            getLogger().log(Level.INFO, "{0}------- == -------", ChatColor.DARK_AQUA);
            getLogger().log(Level.INFO, "{0}DB CRIADA!", ChatColor.DARK_AQUA);
            getLogger().log(Level.INFO, "{0}------- == -------", ChatColor.DARK_AQUA);

        } catch (SQLException ex) {
            getLogger().info("ERRO: Conexao ao banco de dados MySQL falhou!");
            getLogger().info("ERRO: " + ex);

        }
    }

    public Connection rpgCriarConnection() throws SQLException {
        try {

            String endereco = "jdbc:mysql://localhost:3306/hubs?autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                getLogger().info("ERRO: Conexao ao banco de dados MySQL falhou!");
                getLogger().log(Level.INFO, "ERRO: {0}", ex);
            }
            this.connection = DriverManager.getConnection(endereco, "root", "rocketmc2018");
            return this.connection;
        } catch (ClassNotFoundException e) {

            getLogger().info("ERRO: Conexao ao banco de dados MySQL falhou!");
            getLogger().log(Level.INFO, "ERRO: {0}", e.toString());
            getLogger().log(Level.SEVERE, (Supplier<String>) e);
            return null;
        }

    }

    public synchronized Connection rpgConnection() throws SQLException {
        if (this.connection == null) {

            this.connection = rpgCriarConnection();
            try {
                this.connection.setAutoCommit(true);
            } catch (SQLException ex) {

                getLogger().info("ERRO: Conexao ao banco de dados MySQL falhou!");
                getLogger().log(Level.INFO, "ERRO: {0}", ex);
            }

        }
        return this.connection;
    }

}
