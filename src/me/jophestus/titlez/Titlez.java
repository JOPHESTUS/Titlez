     package me.jophestus.titlez;
     
     import java.util.logging.Logger;
     import org.bukkit.Bukkit;
     import org.bukkit.ChatColor;
     import org.bukkit.command.CommandExecutor;
     import org.bukkit.entity.Player;
     import org.bukkit.plugin.PluginManager;
     import org.bukkit.plugin.java.JavaPlugin;
     
     public class Titlez extends JavaPlugin
     {
   Logger log = Logger.getLogger("Minecraft");
     
  public void onEnable() { registerEvents();
      addConfigurationDefaults();
      RegisterCommands();
      getConfig();
  }
      
     
       public void onDisable()
       {
      // I am a comment
       }
     
       public void addConfigurationDefaults() {
     getConfig().options().header("You dont have to edit this file unless you want to change a title maually");
      getConfig().options().copyDefaults(true);
     saveConfig();
     
       }
     
       public void RegisterCommands() {
       registercmd("titlez", new TitlezSet(this));
      
       }
       public void registerEvents() {
     PluginManager pm = getServer().getPluginManager();
      pm.registerEvents(new TitlezPlayerListener(this), this);
      
       }
     
       public void registercmd(String command, CommandExecutor ce) {
     if (getDescription().getCommands().toString().toLowerCase().contains(command))
        Bukkit.getServer().getPluginCommand(command).setExecutor(ce);
       }
     
       public static void playermessage(Player p, String message) {
     p.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "Titlez" + ChatColor.GOLD + "]" + message);
       }
     
       public boolean permissionCheck(Player p, String node) {
     return p.hasPermission(node);
       }
     }
