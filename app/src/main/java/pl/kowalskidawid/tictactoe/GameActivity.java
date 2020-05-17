package pl.kowalskidawid.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    List<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_name);
    }

    public void select(View view) {
        Button selectedButton = findViewById(view.getId());

        selectedButton.setText(this.getCurrentPlayer().getSign());
        selectedButton.setClickable(false);

        if(!this.checkWinner()) {
            this.setPlayer();
            this.insertCurrentPlayerName();
        }
    }

    private void insertCurrentPlayerName() {
        TextView name = findViewById(R.id.currentPlayerName);
        name.setText( this.getCurrentPlayer().getName() );
    }

    private boolean checkWinner() {
        return false;
    }

    public void displayBoard(View view) {
        this.players = new ArrayList<>();

        // get names view
        EditText player_x = findViewById(R.id.player_x);
        this.players.add(new Player(player_x.getText().toString(), "X", true));

        EditText player_y = findViewById(R.id.player_y);
        this.players.add(new Player(player_y.getText().toString(), "O", false));

        Log.d("Players", this.players.toString());

        setContentView(R.layout.activity_game);
        this.insertCurrentPlayerName();
    }

    public void setPlayer() {
        this.players.get(0).toogleIsCurrentPlayer();
        this.players.get(1).toogleIsCurrentPlayer();
    }

    private Player getCurrentPlayer() {
        if( this.players.get(0).isCurrentPlayer() ) {
            return this.players.get(0);
        }
        else {
            return this.players.get(1);
        }
    }
}