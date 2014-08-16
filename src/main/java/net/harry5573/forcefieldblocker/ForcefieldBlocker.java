/*
 * Copyright (C) 2014 Harry Devane
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.harry5573.forcefieldblocker;

import net.harry5573.forcefieldblocker.listener.PlayerListener;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * https://www.github.com/Harry5573OP
 *
 * @author Harry5573OP
 */
public class ForcefieldBlocker extends JavaPlugin {
      
      @Getter
      private static ForcefieldBlocker plugin_instance = null;
      
      @Override
      public void onEnable() {
            plugin_instance = this;
            
            logMessage("=[ Plugin version " + getDescription().getVersion() + " starting ]=");
            
            getServer().getPluginManager().registerEvents(new PlayerListener(), this);
            
            logMessage("=[ Plugin version " + getDescription().getVersion() + " started ]=");
      }
      
      @Override
      public void onDisable() {
            logMessage("=[ Plugin version " + getDescription().getVersion() + " stopping ]=");
            
            logMessage("=[ Plugin version " + getDescription().getVersion() + " shutdown ]=");
      }
      
      private void logMessage(String message) {
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[" + getName() + "]: " + ChatColor.WHITE + message);
      }
}
