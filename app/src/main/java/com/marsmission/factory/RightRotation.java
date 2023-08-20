package com.marsmission.factory;

import com.marsmission.core.enumeration.Orientation;

public class RightRotation implements Rotation {
    @Override
    public Orientation rotate(Orientation actualOrientation) {
        if (actualOrientation.equals(Orientation.NORTH)) {
            return Orientation.EAST;
        }

        if (actualOrientation.equals(Orientation.EAST)) {
            return Orientation.SOUTH;
        }

        if (actualOrientation.equals(Orientation.WEST)) {
            return Orientation.NORTH;
        }

        return Orientation.WEST;
    }
}
