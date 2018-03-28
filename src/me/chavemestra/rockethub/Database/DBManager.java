/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import me.chavemestra.rockethub.Log.LogUtil.TipoLog;
import static me.chavemestra.rockethub.Log.LogUtil.log;
import org.bukkit.entity.Player;

/**
 *
 * @author Gabriel
 */
public class DBManager {

    private static DBDefault db;

    public DBManager() {
        log("DB Manager inicializando..", TipoLog.Debug);
        db = new DBDefault();
        log("DB Manager inicializado!", TipoLog.Inicializacao);
    }

    public void inserirPlayer(Player p) throws SQLException {
        db.rpgConnection().createStatement().executeUpdate("INSERT INTO Rocket_Hub(UUID,name) VALUES ('" + p.getUniqueId() + "' , '" + p.getName() + "')");
    }

    public void executeUpdateString(String coluna, String valor, String where, String verify) throws SQLException {
        db.rpgConnection().createStatement().executeUpdate("UPDATE Rocket_Hub SET " + coluna + ""
                + "='" + valor + "' WHERE " + where + "='" + verify + "'");
    }

    public void executeUpdateValue(String coluna, double valor, String where, String verify) throws SQLException {
        db.rpgConnection().createStatement().executeUpdate("UPDATE Rocket_Hub SET " + coluna + ""
                + "=" + valor + " WHERE " + where + "='" + verify + "'");
    }
    
    public void increaseKills(String uuid) throws SQLException {
        db.rpgConnection().createStatement().executeUpdate("UPDATE Rocket_Hub SET kills"
                + "=kills+1 WHERE UUID='" + uuid + "'");
    }

    public ResultSet executeQuery(String coluna, String where, String verify) throws SQLException {
        return db.rpgConnection().createStatement().executeQuery("SELECT " + coluna + " FROM Rocket_Hub WHERE " + where + ""
                + "='" + verify + "'");
    }
    public ResultSet executeQueryLivre(String query) throws SQLException {
        return db.rpgConnection().createStatement().executeQuery(query);
    }

}
