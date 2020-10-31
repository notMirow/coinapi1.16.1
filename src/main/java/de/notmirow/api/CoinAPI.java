package de.notmirow.api;

import de.notmirow.mysql.MySQL;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JavaDoc this file!
 * Created: 31.10.2020
 *
 * @author notMirow (email.mirowyt@gmail.com)
 */
public class CoinAPI {

    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getStatment("CREATE TABLE IF NOT EXISTS Coins (Spielername VARCHAR(100), UUID VARCHAR(100), Coins INT(100))");
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void register(Player player) {
        try {
            PreparedStatement ps = MySQL.getStatment("INSERT INTO Coins (Spielername, UUID, Coins) VALUES (?, ?, ?)");
            ps.setString(1, player.getName());
            ps.setString(2, player.getUniqueId().toString());
            ps.setInt(3, 0);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isRegistered(Player player) {
        try {
            PreparedStatement ps = MySQL.getStatment("SELECT * FROM Coins WHERE UUID= ?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            rs.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean isRegistered(String name) {
        try {
            PreparedStatement ps = MySQL.getStatment("SELECT * FROM Coins WHERE Spielername= ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            rs.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static int getCoins(Player player) {
        try {
            PreparedStatement ps = MySQL.getStatment("SELECT * FROM Coins WHERE UUID= ?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int coins = rs.getInt("Coins");
            rs.close();
            ps.close();
            return coins;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static void setCoins(Player player, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE UUID= ?");
            ps.setInt(1, coins);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addCoins(Player player, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE UUID= ?");
            ps.setInt(1, getCoins(player) + coins);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removeCoins(Player player, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE UUID= ?");
            ps.setInt(1, getCoins(player) - coins);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getCoins(String name) {
        try {
            PreparedStatement ps = MySQL.getStatment("SELECT * FROM Coins WHERE Spielername= ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int coins = rs.getInt("Coins");
            rs.close();
            ps.close();
            return coins;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static void setCoins(String name, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE Spielername= ?");
            ps.setInt(1, coins);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addCoins(String name, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE Spielername= ?");
            ps.setInt(1, getCoins(name) + coins);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removeCoins(String name, int coins) {
        try {
            PreparedStatement ps = MySQL.getStatment("UPDATE Coins SET Coins= ? WHERE Spielername= ?");
            ps.setInt(1, getCoins(name) - coins);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
