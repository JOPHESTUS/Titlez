     package me.jophestus.titlez;
     
     import org.bukkit.ChatColor;
     import org.bukkit.command.Command;
     import org.bukkit.command.CommandExecutor;
     import org.bukkit.command.CommandSender;
     import org.bukkit.entity.Player;
     
     public class TitlezSet
       implements CommandExecutor
     {
       protected Titlez plugin;
     
       TitlezSet(Titlez plugin)
       {
       this.plugin = plugin;
       }
     
       public boolean onCommand(CommandSender s, Command c, String l, String[] args)
       {
       String playerspoke = s.getName();
       Player player = (Player)s;
       if (l.equalsIgnoreCase("titlez")) {
         if (args[0].equalsIgnoreCase("set")) {
           if (this.plugin.permissionCheck(player, "titlez.title")) {
             if (!this.plugin.getConfig().contains(playerspoke)) {
               this.plugin.getConfig().addDefault(playerspoke, String.valueOf(args[1]));
               this.plugin.getConfig().options().copyDefaults(true);
               this.plugin.saveConfig();
               this.plugin.reloadConfig();
               s.sendMessage(ChatColor.GOLD + "You have succesfully set your title");
               return true;
               }
             s.sendMessage(ChatColor.RED + "Hint: If you want to change your title use " + ChatColor.AQUA + "/titlez del" + ChatColor.RED + 
               " first then try again");
          // I am a comment
             }
             else {
             player.sendMessage(ChatColor.RED + "Sorry, you dont have permission");
             }
           }
         if (args[0].equalsIgnoreCase("del")) {
           if (this.plugin.permissionCheck(player, "titlez.del")) {
             if (this.plugin.getConfig().contains(s.getName())) {
               this.plugin.getConfig().set(playerspoke, null);
               this.plugin.saveConfig();
               this.plugin.reloadConfig();
               s.sendMessage(ChatColor.GOLD + "Your title has been removed");
               return true;
               }
             s.sendMessage(ChatColor.RED + "You can't remove a title if you dont have one!");
             s.sendMessage(ChatColor.RED + "Hint: Use " + ChatColor.AQUA + "/titlez set " + ChatColor.RED + "to set your title");
             }
             else {
             player.sendMessage(ChatColor.RED + "Sorry, you dont have permission");
             }
           }
         if (args[0].equalsIgnoreCase("list")) {
           if (this.plugin.getConfig().contains(args[1])) {
             s.sendMessage(ChatColor.GREEN + args[1] + ChatColor.GREEN + "'s title is " + ChatColor.AQUA + 
               "'" + this.plugin.getConfig().getString(playerspoke) + ChatColor.AQUA + "'");
             return true;
             }
           s.sendMessage(ChatColor.DARK_RED + "That player hasn't made a title yet");
           }
     
         if (args[0].equalsIgnoreCase("about"))
           {
           s.sendMessage(ChatColor.GOLD + "----------[" + ChatColor.RED + "Titlez V1.0" + ChatColor.GOLD + "]----------");
           s.sendMessage(ChatColor.GOLD + "Original version by Drew1080");
           s.sendMessage(ChatColor.GOLD + "Updated by " + ChatColor.AQUA + "JOPHESTUS");
           s.sendMessage(ChatColor.GOLD + "--------------------------------------");
           return true;
           }
         if (args[0].equalsIgnoreCase("reload")) {
           if (this.plugin.permissionCheck(player, "titlez.reload")) {
             this.plugin.reloadConfig();
             s.sendMessage(ChatColor.GREEN + "Titlez has succesfully reloaded");
             this.plugin.log.info("[Titlez] Config sucessfully reloaded");
             return true;
             }
           player.sendMessage(ChatColor.RED + "Sorry, you dont have permission");
     
           return false;
           }
         }
       return false;
       }
     }

