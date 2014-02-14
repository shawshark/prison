package me.shawshark.prison;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankupCommand implements CommandExecutor {
	
	public main m;
	
	public RankupCommand(main m) {
		this.m = m;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) 
	{
		if(!(sender instanceof Player)) 
		{
			sender.sendMessage(ChatColor.RED + "Error: This command can only be run from in-game!");
		} else {
			
			Player p = (Player) sender;
			
			if(args.length == 0)
			{
				
				p.sendMessage(ChatColor.GOLD + "You can rankup to the following groups!");
				
				for ( groups g : m.groups) 
				{
					String groups = g.groupname;
					int price = g.price;
					
					p.sendMessage(ChatColor.GREEN + "- " + 
							ChatColor.WHITE + groups + ChatColor.GOLD + "Price " + price);						
				}
				
			} else if(args[0].equalsIgnoreCase(args[0])) 
			{
				
				
				for ( groups g : m.groups)
				{
					String foundGroup = g.groupname;
					
					if(args[0].equalsIgnoreCase(foundGroup))
					{
						
						
					String groupName = args[0];
					
					String currentGroup = "";
					
					if(!(groupName == currentGroup))
					{
						

						
						if("") {	
							

							//if player has money
							

							
						} else {
							
							p.sendMessage(ChatColor.GOLD + "You don't have enough money...");
							
							
						}
							
							
							
					} else {
						p.sendMessage(ChatColor.GOLD + "You seem to already be in group + " + groupName);
					}
						
						
					} else {
						p.sendMessage(ChatColor.GOLD + "The group " + args[0] + " doesn't exist..");
					}
					
						

					
					
				}
				
			}
			
		}
	
	return true;
	
	}
}
