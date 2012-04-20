/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2012 Regents of the University of Minnesota and contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.data.pref;

import javax.annotation.concurrent.Immutable;

/**
 * Basic indexed preference implementation that stores data in fields.
 *
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 * @since 0.11
 */
@Immutable
public final class SimpleIndexedPreference extends IndexedPreference {
    private final long userId;
    private final long itemId;
    private final double value;
    private final int index;
    private final int userIndex;
    private final int itemIndex;

    /**
     * Construct a new indexed preference object.
     * @param uid The user ID.
     * @param iid The item ID.
     * @param v The preference value.
     * @param idx The preference index
     * @param uidx The user index
     * @param iidx The item index
     */
    public SimpleIndexedPreference(long uid, long iid, double v,
                                   int idx, int uidx, int iidx) {
        index = idx;
        userIndex = uidx;
        itemIndex = iidx;
        userId = uid;
        itemId = iid;
        value = v;
    }

    /**
     * Copy a preference object. This provides a convenient means of disconnecting
     * a preference from a mutable or indirect preference with less boilerplate.
     * @param pref The preference object to copy.
     */
    public SimpleIndexedPreference(IndexedPreference pref) {
        this(pref.getUserId(), pref.getItemId(), pref.getValue(),
             pref.getIndex(), pref.getUserIndex(), pref.getItemIndex());
    }

    @Override
    public int getIndex() {
        return index;
    }
    @Override
    public long getUserId() {
        return userId;
    }
    @Override
    public int getUserIndex() {
        return userIndex;
    }
    @Override
    public long getItemId() {
        return itemId;
    }
    @Override
    public int getItemIndex() {
        return itemIndex;
    }
    @Override
    public double getValue() {
        return value;
    }
}
