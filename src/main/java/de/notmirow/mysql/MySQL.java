package de.notmirow.mysql;

import de.notmirow.CoinPlugin;
import org.bukkit.Bukkit;

import java.sql.*;

/**
 * JavaDoc this file!
 * Created: 31.10.2020
 *
 * @author notMirow (email.mirowyt@gmail.com)
 */
public class MySQL {

    public static String host = "";
    public static String port = "3306";
    public static String database = "CoinPlugin";
    public static String username = "root";
    public static String password = "secret";

    public static Connection con;

    public static boolean isConnected() {
        return (con != null);
    }

    public static void connect() {
        if (!isConnected())
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "" +
                        "?autoReconnect=true", username, password);
                Bukkit.getConsoleSender().sendMessage(CoinPlugin.PREFIX + "§aEs konnte erfolreich mit der Datenbank " +
                        "§averbunden werden");

            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage(CoinPlugin.PREFIX + "§cEs konnte nicht mit der Datenbank" +
                        "§cverbunden werden");
            }
    }

    public static void disconnect() {
        try {
            con.close();
            Bukkit.getConsoleSender().sendMessage(CoinPlugin.PREFIX + "§aDie MySQL " +
                    "§averbindung konnte erfolgreich geschlossen werden");
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(CoinPlugin.PREFIX + "§cDie MySQL" +
                    "§cverbindung konnte nicht geschlossen werden");
        }
    }

    public static PreparedStatement getStatment(String sql) {
        if (isConnected())
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                return ps;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    public static ResultSet getResult(String sql) {
        if (isConnected())
            try {
                PreparedStatement ps = getStatment(sql);
                ResultSet rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

}
