# coinapi1.16.1

Your Server need to have 1.16.1 Spigot and you can put ViaVersion on it so you can Join with other Versions (1.16+)
plugins/CoinPlugin/config.yml when your start the plugin the file gonna be created if its not create a file:
plugins/CoinPlugin/config.yml and put in there:

#MySQl Config.yml

host: ""
port: "3306"
database: "coinapi"
user: "root"
password: "secret"


Installation:
Go to target folder and download CoinAPI-1.0-SNAPSHOT.jar.
Put in Your plugin folder and start your server
after it starts Stop it go to /plugins/CoinPlugin/config.yml
Put your MySQL login things if the file isnt there make what i say on
line 3
Then have fun:

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
