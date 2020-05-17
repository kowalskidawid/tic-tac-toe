package pl.kowalskidawid.tictactoe;

import android.content.Intent;

import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private String sign;
    private boolean isCurrentPlayer;
    private boolean[][] selected;

    public Player(String name, String sign, boolean isCurrentPlayer) {
        this.name = name;
        this.sign = sign;
        this.isCurrentPlayer = isCurrentPlayer;
        this.selected = new boolean[3][3];
    }

    public void select(int x, int y) {
        this.selected[x][y] = true;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void toogleIsCurrentPlayer() {
        isCurrentPlayer = !isCurrentPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", isCurrentPlayer=" + isCurrentPlayer +
                ", selected=" + Arrays.toString(selected) +
                '}';
    }
}
