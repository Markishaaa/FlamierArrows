package markisha.flamierarrows;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import markisha.events.DetectArrow;

public class FlamierArrows extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DetectArrow(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FlamierArrows]: Plugin enabled!");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FlamierArrows]: Plugin disabled!");
	}
	
}
