package com.bumbumapps.fifteenpuzzlepro.game.solver;

import com.bumbumapps.fifteenpuzzlepro.game.Game;
import com.bumbumapps.fifteenpuzzlepro.game.Heuristics;
import com.bumbumapps.fifteenpuzzlepro.game.Move;

public class Solver {

    private final Move start;
    private final Algorithm algorithm;

    public Solver(Game start, Heuristics heuristics, Algorithm algorithm) {
        this.start = new Move(heuristics, start);
        this.algorithm = algorithm;
    }

    public Move start() {
        return start;
    }

    public Solution solve() {
        return algorithm.run(start);
    }
}
