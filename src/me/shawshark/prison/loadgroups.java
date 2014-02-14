package me.shawshark.prison;

import org.bukkit.configuration.file.FileConfiguration;

public class loadgroups {
	
	public Main m;
	int count;
	
	public loadgroups(Main m) {
		this.m = m;
	}
	
	public void load() {
		FileConfiguration c = m.getConfig();
		
		/* set the count to 0 */
		count = 0;
		
		/* Clear the arraylist */
		m.groups.clear();
		
		String groupname;
		int price;
		String required;
		
		for ( String s : c.getStringList("groups"))
		{
			/* split the string. */
			String[] i = s.split(",");
			
			groupname = i[0];
			price = Integer.parseInt(i[1]);
			required = i[2];
			
			/* add +1 each time a group is added from the config */
			count++;
			
			/* load the groups into the arraylist */
			m.groups.add(new groups(groupname, price, required));
		}
		
		/* out put how many groups were loaded in the console */
		System.out.println("<Rankup> Loaded " + count + " groups!");
		
	}
}
