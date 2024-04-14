package com.proj.v1.CountdownTimer;

import com.proj.v1.Elements.Text;
import com.proj.v1.Utils.TimerCallback;

import java.util.TimerTask;

public class Countdown extends TimerTask {

    private int time;
    private Text _Time;
    private Text _CurrentPlayer;

    private String[] players;

    private int currentTime;

    TimerCallback timerCallback;

    public Countdown(int time, Text _Time, Text _CurrentPlayer, String[] players, TimerCallback callback){
        this.time = time;
        this._Time = _Time;
        this._CurrentPlayer = _CurrentPlayer;
        this.players = players;
        timerCallback = callback;
        currentTime = time+1;
    }

    @Override
    public void run() {
        currentTime -= 1;
        _Time.setText("Tiempo restante: "+currentTime+"s");

        if (currentTime == 0){
            _Time.setText("Se acabo el tiempo: "+ currentTime+"s");
            currentTime = time+1;
            if (players[0].equals(_CurrentPlayer.getText().substring(7))){
                _CurrentPlayer.setText("Juega: " + players[1]);
            } else {
                _CurrentPlayer.setText("Juega: " + players[0]);
            }
            timerCallback.onfinish();
        }
    }

    @Override
    public boolean cancel() {
        System.out.println("lol");
        return super.cancel();
    }
}
