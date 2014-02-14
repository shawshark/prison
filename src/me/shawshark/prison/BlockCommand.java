package me.shawshark.prison;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockCommand implements CommandExecutor {
	
	public main m;
	
	public BlockCommand(main m) {
		this.m = m;
	}
	
	public List<Blocks> locations = new ArrayList<Blocks>();

	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) 
	{
		if(!(sender instanceof Player)) 
		{
			sender.sendMessage(ChatColor.RED + "Error: This command can only be run from in-game!");
		} else {
			Player p = (Player) sender;
			
			
			if(cmd.getName().equalsIgnoreCase("block")) {
				if(args.length == 0) {
					p.sendMessage(ChatColor.GOLD + "/block (block name)");
				} else {
					
					if(args[0].equalsIgnoreCase("list"))
					{
						p.sendMessage(ChatColor.GREEN + "Current blocks...");
						for (Blocks bl : locations ) {
							p.sendMessage(ChatColor.GREEN + "- " + ChatColor.GOLD + bl.id);
						}
						return true;
					}
					
					
					for ( Blocks b : locations)
					{
						String block = args[0];
						if(block.equalsIgnoreCase(b.id))
						{
							Location l = b.loc;
							p.teleport(l);
							p.sendMessage(ChatColor.GOLD + "Teleported you to block " + block);
							return true;
						}
					}
				}
			} else if(cmd.getName().equalsIgnoreCase("setblock")) {
				if(p.hasPermission("prison.setblock")) {
					
					
					if(args.length == 0) {
						p.sendMessage(ChatColor.GOLD + "/setblock (block id name)");
					} else {
						String blockName = args[0];
						Location loc = p.getLocation();
						
						for ( Blocks b : locations ) 
						{
							if(blockName.equalsIgnoreCase(b.id))
							{
								p.sendMessage(ChatColor.GOLD + "Block " + blockName + " has already been created!");
								return true;
								
							}
						}
						
						
						locations.add(new Blocks(loc, blockName));
						p.sendMessage(ChatColor.GOLD + "You have created block " + blockName);
						
					}
				} else {
					p.sendMessage(ChatColor.GOLD + "You don't have enough permissions!");
				}
			}
		}
	return true;
	}
	
	public void load() {
		
		String world;
		int x;
		int y;
		int z;
		
		String id;
		
		for ( String s : m.getConfig().getStringList("server.blocklocations"))
		{
			/* split the string. */
			String[] i = s.split(",");
			
			world = i[0];
			
			
			x = Integer.parseInt(i[1]);
			y = Integer.parseInt(i[2]);
			z = Integer.parseInt(i[3]);
			
			
			
			id = i[4];
			
			World w = Bukkit.getServer().getWorld(world);
			
			Location loc = new Location(w, x, y, z);
			
			locations.add(new Blocks(loc, id));
			
			
			
			System.out.println(world + " " + x + " " + y + " " + z + " " + id);
		}
		
	}
	
	public void save() {
		
		List<String> blockz = new ArrayList<String>();
		
		for ( Blocks b : locations ) 
		{
			
			String worldName = b.loc.getWorld().getName();
			int x = b.loc.getBlockX();
			int y = b.loc.getBlockY();
			int z = b.loc.getBlockZ();
			
			String id = b.id;
			
			
			String s = worldName + "," + x + "," + y + "," + z + "," + id;
			
			blockz.add(s);
		}
		
		m.getConfig().set("server.blocklocations", blockz);
		m.saveConfig();
	}
}
