package me.shawshark.test;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public List<groups> groups = new ArrayList<groups>();
	
	public void onEnable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("rankup")) {
			
			if(sender instanceof Player) {
				Player p = (Player) sender;
					
				if(args.length == 0) {
					
					p.sendMessage(ChatColor.GOLD + "You can rankup to the following groups!");
					
					for ( groups g : groups) {
						String groups = g.groupname;
						int price = g.price;
						
						p.sendMessage(ChatColor.GREEN + "- " + 
								ChatColor.WHITE + groups + ChatColor.GOLD + "Price " + price);						
					}
					
				}
			}
		}
		return true;
	}
}
