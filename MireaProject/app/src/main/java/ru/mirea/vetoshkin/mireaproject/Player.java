package ru.mirea.vetoshkin.mireaproject;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Player extends Fragment{

    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterView = inflater.inflate(R.layout.fragment_player, container, false);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.music);
        mediaPlayer.setLooping(true);

        Button start = (Button) inflaterView.findViewById(R.id.start_play);
        start.setOnClickListener(this::onClickStartCommand);
        Button stop = (Button) inflaterView.findViewById(R.id.stop_play);
        stop.setOnClickListener(this::onClickStopCommand);
        return inflaterView;
    }


    public void onClickStartCommand(View view){
        mediaPlayer.start();
    }
    public void onClickStopCommand(View view){
        mediaPlayer.stop();
    }
}