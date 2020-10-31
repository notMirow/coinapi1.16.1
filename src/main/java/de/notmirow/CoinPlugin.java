package de.notmirow;

import de.notmirow.api.CoinAPI;
import de.notmirow.commands.CoinCommand;
import de.notmirow.listeners.JoinListener;
import de.notmirow.mysql.MySQL;
import de.notmirow.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoinPlugin extends JavaPlugin {

    public static final String PREFIX = "§8[§6Coins§8] §7";
    public static final String NOPERMS = PREFIX + "Dazu hast du keine Rechte!";

    private static CoinPlugin instance;
    private ConfigManager configManager;



    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager();
        getConfig().options().copyDefaults(true);
        saveConfig();
        init();

    }

    private void init(){
        MySQL.connect();
        CoinAPI.createTable();
        getCommand("coins").setExecutor(new CoinCommand());
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }


    public static CoinPlugin getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {



    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

}
