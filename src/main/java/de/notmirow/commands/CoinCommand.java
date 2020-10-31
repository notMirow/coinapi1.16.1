package de.notmirow.commands;

import de.notmirow.CoinPlugin;
import de.notmirow.api.CoinAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.function.LongBinaryOperator;

/**
 * JavaDoc this file!
 * Created: 31.10.2020
 *
 * @author notMirow (email.mirowyt@gmail.com)
 */
public class CoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = ((Player) sender);
        if (args.length == 0) {
            int coins = CoinAPI.getCoins(player);
            player.sendMessage(CoinPlugin.PREFIX + "§7Du hast momentan §e" + coins + " §7Coins");
        } else if (args.length == 1) {
            if (player.hasPermission("coinsystem.managecoins")) {
                if (args[0].equalsIgnoreCase("add")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze: /coins add <Spieler> <Coins>");
                } else if (args[0].equalsIgnoreCase("remove")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze /coins remove <Spieler> <Coins>");
                } else if (args[0].equalsIgnoreCase("set")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze /coins set <Spieler> <Coins>");
                } else {
                    String name = args[0];
                    if (CoinAPI.isRegistered(name)) {
                        int coins = CoinAPI.getCoins(name);
                        player.sendMessage(CoinPlugin.PREFIX + "§7Der Spieler " + name + " §7hat " + coins + " §7Coins");
                    } else {
                        player.sendMessage(CoinPlugin.PREFIX + "§7Der Spieler " + name + " §7ist noch nicht registriert!");
                    }
                }
            } else player.sendMessage(CoinPlugin.NOPERMS);
        } else if (args.length == 2) {
            if (player.hasPermission("coinsystem.managecoins")) {
                if (args[0].equalsIgnoreCase("add")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze: /coins add <Spieler> <Coins>");
                } else if (args[0].equalsIgnoreCase("remove")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze: /coins remove <Spieler> <Coins>");
                } else if (args[0].equalsIgnoreCase("set")) {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze: /coins set <Spieler> <Coins>");
                } else {
                    player.sendMessage(CoinPlugin.PREFIX + "§7Nutze: /coins add | remove | set <Spieler> <Coins>");
                }
            } else {
                player.sendMessage(CoinPlugin.NOPERMS);
            }
        } else if (args.length == 3) {
            if (player.hasPermission("coinsystem.managecoins")) {
                if (args[0].equalsIgnoreCase("add")) {
                    String name = args[1];
                    if (CoinAPI.isRegistered(name)) {
                        int coins = Integer.valueOf(args[2]).intValue();
                        CoinAPI.addCoins(name, coins);
                        player.sendMessage(CoinPlugin.PREFIX + "§7Du hast " + name + " §7 " + coins + " §7geaddet");
                    }
                } else {
                    player.sendMessage(CoinPlugin.NOPERMS);
                }
            } else if (args[0].equalsIgnoreCase("remove")) {
                if (player.hasPermission("coinsystem.managecoins")) {
                    String name = args[1];
                    if (CoinAPI.isRegistered(name)) {
                        int coins = Integer.valueOf(args[2]).intValue();
                        CoinAPI.removeCoins(name, coins);
                        player.sendMessage(CoinPlugin.PREFIX + "§7Du hast " + coins +  " §7Coins von " + name + " §7entfernt");
                    }
                } else {
                    player.sendMessage(CoinPlugin.NOPERMS);
                }
            } else if (args[0].equalsIgnoreCase("set")) {
                String name = args[1];
                if (CoinAPI.isRegistered(name)) {
                    int coins = Integer.valueOf(args[2]).intValue();
                    CoinAPI.setCoins(name, coins);
                    player.sendMessage(CoinPlugin.PREFIX + "§7Du hast die Coins von " + name + " §7auf " + coins + "§7gesetzt");
                }
            } else {
                player.sendMessage(CoinPlugin.PREFIX + "§7Nutze /coins add | remove | set <Spieler> <Coins>");
            }

        }


        return true;
    }
}
