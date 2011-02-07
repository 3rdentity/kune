/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 \*/
package cc.kune.domain.utils;

import java.util.ArrayList;
import java.util.List;

import cc.kune.domain.User;

public class UserBuddiesData {

    public static final UserBuddiesData EMPTY = new UserBuddiesData();

    private List<User> buddies;
    private int otherExtBuddies;

    public UserBuddiesData() {
        otherExtBuddies = 0;
        buddies = new ArrayList<User>();
    }

    public boolean contains(final String shortName) {
        for (User buddie : buddies) {
            if (buddie.getShortName().equals(shortName)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getBuddies() {
        return buddies;
    }

    public int getOtherExtBuddies() {
        return otherExtBuddies;
    }

    public void setBuddies(final List<User> buddies) {
        this.buddies = buddies;
    }

    public void setOtherExtBuddies(final int otherExtBuddies) {
        this.otherExtBuddies = otherExtBuddies;
    }

    @Override
    public String toString() {
        return "UserBuddiesData[ext: " + otherExtBuddies + " / int: " + buddies + "]";
    }
}