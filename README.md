# coinapi1.16.1

Your Server need to have 1.16.1 Spigot and you can put ViaVersion on it so you can Join with other Versions (1.16+)
You need to edit the MySQL.java in the Source maybe i will do a config.yml

Installation:
Download the .zip
Import in IntelliJ Idea
Go to: scr/main/java/de.notmirow/mysql/MySQl.java
Then Put your login thinks of your MySQL
Put in your Plugins Folder have fun!
And dont forgot: Import in your Project!

Permission:
/coins [no permission]
/coins [Player] coinsystem.managecoins
/coins set | remove | add [Player] [Coins] coinsystem.managecoins

Coin-API-Methods:

CoinAPI.createTable();
CoinAPI.register(Player player);
CoinAPI.isRegistered(Player player);
CoinAPI.isRegistered(String name);

CoinAPI.getCoins(Player player);
CoinAPI.setCoins(Player player, int coins);
CoinAPI.addCoins(Player player, int coins);
CoinAPI.removeCoins(Player player, int coins);

CoinAPI.getCoins(String name);
CoinAPI.setCoins(String name, int coins);
CoinAPI.addCoins(String name, int coins);
CoinAPI.removeCoins(String name, int coins);
