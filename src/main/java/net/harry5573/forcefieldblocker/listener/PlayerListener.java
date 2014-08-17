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
package net.harry5573.forcefieldblocker.listener;

import java.util.HashMap;
import java.util.UUID;
import net.harry5573.forcefieldblocker.util.EntityStorage;
import net.harry5573.forcefieldblocker.util.EntityUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * https://www.github.com/Harry5573OP
 *
 * @author Harry5573OP
 */
public class PlayerListener implements Listener {

      private HashMap<UUID, EntityStorage> storedEntities = new HashMap<>();

      @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
      public void onJoin(final PlayerJoinEvent event) {
            storedEntities.put(event.getPlayer().getUniqueId(), new EntityStorage(EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(-1, 2, 0)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(1, 2, 0)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(0, 2, -1)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(0, 2, 1))));
      }

      @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
      public void onMove(PlayerMoveEvent event) {
            //If they havent moved a block lets not send 10000 packets.
            if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
                  return;
            }

            EntityUtil.killEntity(event.getPlayer(), storedEntities.get(event.getPlayer().getUniqueId()).getEntity_east_id());
            EntityUtil.killEntity(event.getPlayer(), storedEntities.get(event.getPlayer().getUniqueId()).getEntity_west_id());
            EntityUtil.killEntity(event.getPlayer(), storedEntities.get(event.getPlayer().getUniqueId()).getEntity_south_id());
            EntityUtil.killEntity(event.getPlayer(), storedEntities.get(event.getPlayer().getUniqueId()).getEntity_north_id());
            storedEntities.remove(event.getPlayer().getUniqueId());
            storedEntities.put(event.getPlayer().getUniqueId(), new EntityStorage(EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(-1, 2, 0)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(1, 2, 0)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(0, 2, -1)), EntityUtil.spawnFakePlayer(event.getPlayer(), event.getPlayer().getLocation().add(0, 2, 1))));
      }

      @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
      public void onQuit(PlayerQuitEvent event) {
            storedEntities.remove(event.getPlayer().getUniqueId());
      }

}
