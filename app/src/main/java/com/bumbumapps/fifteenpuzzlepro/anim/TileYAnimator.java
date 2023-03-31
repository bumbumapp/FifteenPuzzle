package com.bumbumapps.fifteenpuzzlepro.anim;

import com.bumbumapps.fifteenpuzzlepro.Tile;

public class TileYAnimator extends TileAnimator {

    public TileYAnimator(Tile target) {
        super(target);
    }

    @Override
    protected void update(Tile target, float value) {
        target.setCanvasY(value);
    }

}
