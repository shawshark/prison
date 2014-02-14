package me.shawshark.prison;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public List<groups> groups = new ArrayList<groups>();
	
	public RankupCommand rankupcmd;
	public loadgroups loadgroups;
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		
		
		rankupcmd = new RankupCommand(this);
		loadgroups = new loadgroups(this);
		
		
		loadgroups.load();
		
	}
	
	public void loadCommands() {
		
		getCommand("rankup").setExecutor(rankupcmd);
		System.out.println("<Prison> Loaded commands!");
	}
}
