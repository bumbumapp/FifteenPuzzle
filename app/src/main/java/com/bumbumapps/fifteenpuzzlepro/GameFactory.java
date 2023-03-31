package com.bumbumapps.fifteenpuzzlepro;

import com.bumbumapps.fifteenpuzzlepro.game.ClassicGame;
import com.bumbumapps.fifteenpuzzlepro.game.Game;
import com.bumbumapps.fifteenpuzzlepro.game.SnakeGame;
import com.bumbumapps.fifteenpuzzlepro.game.SpiralGame;

import java.util.List;

public class GameFactory {

    public static Game create(
            int type,
            int width,
            int height,
            boolean randomMissingTile) {
        switch (type) {
            case Constants.TYPE_CLASSIC:
                return new ClassicGame(width, height, randomMissingTile);
            case Constants.TYPE_SNAKE:
                return new SnakeGame(width, height, randomMissingTile);
            case Constants.TYPE_SPIRAL:
                return new SpiralGame(width, height, randomMissingTile);
            default:
                throw new IllegalStateException("Unknown type=" + type);
        }
    }

    public static Game create(
            int type,
            int width,
            int height,
            List<Integer> state,
            int moves) {
        switch (type) {
            case Constants.TYPE_CLASSIC:
                return new ClassicGame(width, height, state, moves);
            case Constants.TYPE_SNAKE:
                return new SnakeGame(width, height, state, moves);
            case Constants.TYPE_SPIRAL:
                return new SpiralGame(width, height, state, moves);
            default:
                throw new IllegalStateException("Unknown type=" + type);
        }
    }

    private GameFactory() {
    }
}
