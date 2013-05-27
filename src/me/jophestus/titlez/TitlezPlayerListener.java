     package me.jophestus.titlez;
     
     import org.bukkit.ChatColor;
     import org.bukkit.event.EventHandler;
     import org.bukkit.event.EventPriority;
     import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
     
     public class TitlezPlayerListener
       implements Listener
     {
       protected Titlez plugin;
     
       TitlezPlayerListener(Titlez plugin)
       {
       this.plugin = plugin;
       }
       @EventHandler(priority=EventPriority.NORMAL)
       public void onPlayerChat(AsyncPlayerChatEvent event) {
       if (this.plugin.getConfig().contains(event.getPlayer().getName())) {
         String nameinconfig = this.plugin.getConfig().getString(event.getPlayer().getName());
         String newformat = event.getFormat().replace("[TITLE]", ChatColor.AQUA + "[" + ChatColor.RED + nameinconfig + ChatColor.AQUA + "]");
         event.setFormat(newformat);
         } else {
         String formatedwithnoname = event.getFormat().replace("[TITLE]", "");
         event.setFormat(formatedwithnoname);
      // I am a comment
         }
       }
     }

