package eu.grayroot.anarchyhub.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener {
	
	@EventHandler
	public void onBlockBurn(BlockBurnEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockDispense(BlockDispenseEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockExplode(BlockExplodeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockForm(BlockFromToEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockGrow(BlockGrowEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockPhysic(BlockPhysicsEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockPiston1(BlockPistonExtendEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockPiston2(BlockPistonRetractEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockSpread(BlockSpreadEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockForm(BlockFormEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void weaterChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

}
