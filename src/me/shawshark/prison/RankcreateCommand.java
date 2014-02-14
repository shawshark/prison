package me.shawshark.prison;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankcreateCommand implements CommandExecutor {
	
	public main m;
	
	public RankcreateCommand(main m) {
		this.m = m;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) 
	{
		if(!(sender instanceof Player)) 
		{
			sender.sendMessage(ChatColor.RED + "Error: This command can only be run from in-game!");
		} else {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("prison.rankcreate"))
			{
				if(args.length == 2)
				{
					Boolean i = false;
					String groupName = args[0];
					int price = Integer.parseInt(args[1]);
					String required = args[2];
					
					for ( groups g : m.groups )
					{
						String gNames = g.groupname;
						
						if(groupName == gNames)
						{
							p.sendMessage(ChatColor.GOLD + "This rank is already created!");
						} else {
							i = true;
							p.sendMessage(ChatColor.GOLD + ""+groupName + " has been created!");
						}
					}
					
					if(i)
					{
						m.groups.add(new groups(groupName, price, required));
						i = false;
					}
					
					
					
				} else {
					p.sendMessage(ChatColor.GOLD + "invaid.. /rankcreate (group) (price) (required rank)");
				}
			} else {
				p.sendMessage(ChatColor.GOLD + "You don't have permissions for this command!");
			}
			
		}
	
	return true;
	
	}
}
