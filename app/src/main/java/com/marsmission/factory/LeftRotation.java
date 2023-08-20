package com.marsmission.factory;

import com.marsmission.core.enumeration.Orientation;

public class LeftRotation implements Rotation {
    @Override
    public Orientation rotate(Orientation actualOrientation) {
        if (actualOrientation.equals(Orientation.NORTH)) {
            return Orientation.WEST;
        }

        if (actualOrientation.equals(Orientation.EAST)) {
            return Orientation.NORTH;
        }

        if (actualOrientation.equals(Orientation.WEST)) {
            return Orientation.SOUTH;
        }

        return Orientation.EAST;
    }
}
