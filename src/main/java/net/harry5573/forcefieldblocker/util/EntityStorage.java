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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * https://www.github.com/Harry5573OP
 *
 * @author Harry5573OP
 */
@AllArgsConstructor
public class EntityStorage {

      @Getter
      private final int entity_north_id;
      @Getter
      private final int entity_east_id;
      @Getter
      private final int entity_south_id;
      @Getter
      private final int entity_west_id;

}
