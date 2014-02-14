package me.shawshark.test;

import org.bukkit.configuration.file.FileConfiguration;

public class loadgroups {

	
	public Main m;
	int count;
	
	public loadgroups(Main m) {
		this.m = m;
	}
	
	public void load() {
		FileConfiguration c = m.getConfig();
		
		count = 0;
		
		String groupname;
		int price;
		String required;
		
		for ( String s : c.getStringList("groups"))
		{
			String[] i = s.split(",");
			
			
			groupname = i[0];
			price = Integer.parseInt(i[1]);
			required = i[2];
			
			count++;
			
			m.groups.add(new groups(groupname, price, required));
		}
		
		System.out.println("<Rankup> Loaded " + count + " groups!");
		
		
		
	}
}
