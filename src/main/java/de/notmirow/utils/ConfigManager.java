package de.notmirow.utils;

import de.notmirow.CoinPlugin;
import de.notmirow.api.CoinAPI;

/**
 * JavaDoc this file!
 * Created: 31.10.2020
 *
 * @author notMirow (email.mirowyt@gmail.com)
 */
public class ConfigManager {

    public String getHost() {
        String host =  CoinPlugin.getInstance().getConfig().getString("host");
        return host;
    }

    public String getPort() {
        String port =  CoinPlugin.getInstance().getConfig().getString("port");
        return port;
    }

    public String getUser() {
        String user =  CoinPlugin.getInstance().getConfig().getString("user");
        return user;
    }

    public String getDatabase() {
        String database =  CoinPlugin.getInstance().getConfig().getString("database");
        return database;
    }

    public String getPassword() {
        String password =  CoinPlugin.getInstance().getConfig().getString("pasword");
        return password;
    }



}
