package com.vojtechjanovc;

public class NullPlayer extends Player {
    public NullPlayer() {
        super(null);
    }

    @Override
    public int[] chooseTile() {
        return null;
    }
}
