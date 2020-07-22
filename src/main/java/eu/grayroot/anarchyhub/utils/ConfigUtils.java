package eu.grayroot.anarchyhub.utils;

import eu.grayroot.anarchyhub.Main;

public class ConfigUtils {

	public ConfigUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void loadConfiguration() {
	     Main.getInstance().getConfig().options().copyDefaults(true);
	     Main.getInstance().saveConfig();
	}

}
