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

package net.harry5573.forcefieldblocker.util;

import com.comphenix.packetwrapper.WrapperPlayServerEntityTeleport;
import com.comphenix.packetwrapper.WrapperPlayServerNamedEntitySpawn;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * https://www.github.com/Harry5573OP
 *
 * @author Harry5573OP
 */
public class EntityUtil {

      private static final Random random = new Random();

      public static int spawnFakePlayer(Player player, Location spawnLocation) {
            WrapperPlayServerNamedEntitySpawn wrapper = new WrapperPlayServerNamedEntitySpawn();
            wrapper.setEntityID(random.nextInt(20000));
            wrapper.setPosition(spawnLocation.toVector());
            wrapper.setPlayerUUID(UUID.randomUUID().toString());
            wrapper.setPlayerName(String.valueOf(random.nextInt()));
            wrapper.setYaw(0);
            wrapper.setPitch(-45);
            WrappedDataWatcher watcher = new WrappedDataWatcher();
            watcher.setObject(0, (byte) 0x20);
            watcher.setObject(6, (Float) (float) 0.5);
            watcher.setObject(11, (Byte) (byte) 1);
            wrapper.setMetadata(watcher);
            wrapper.sendPacket(player);
            return wrapper.getEntityID();
      }

      public static void teleportEntity(Player player, int entity_id, Vector location) {
            WrapperPlayServerEntityTeleport wrapper = new WrapperPlayServerEntityTeleport();
            wrapper.setEntityID(entity_id);
            wrapper.setX(location.getX());
            wrapper.setY(location.getY());
            wrapper.setZ(location.getZ());
            wrapper.sendPacket(player);
      }

}
