package com.bumbumapps.fifteenpuzzlepro.anim;

import com.bumbumapps.fifteenpuzzlepro.Tile;

public class TileScaleAnimator extends TileAnimator {

    public TileScaleAnimator(Tile target) {
        super(target);
    }

    @Override
    protected void update(Tile target, float value) {
        target.setScale(value);
    }

}
