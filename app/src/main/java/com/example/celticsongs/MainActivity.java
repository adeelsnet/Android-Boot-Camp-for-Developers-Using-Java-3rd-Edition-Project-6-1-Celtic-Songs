package com.example.celticsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button irishJig, bagpipesSong;
    private MediaPlayer mpIrishJig, mpbapipesSong;
    private int isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        irishJig = findViewById(R.id.isrish_jig);
        bagpipesSong = findViewById(R.id.bagpipes_song);

        irishJig.setOnClickListener(listenerIrishJig);
        bagpipesSong.setOnClickListener(listenerBagpipesSong);

        mpIrishJig = new MediaPlayer();
        mpIrishJig = MediaPlayer.create(this, R.raw.jig);

        mpbapipesSong = new MediaPlayer();
        mpbapipesSong = MediaPlayer.create(this, R.raw.bagpipes);

        isPlaying = 0;
    }
    Button.OnClickListener listenerIrishJig = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (isPlaying){
                case 0:
                    mpIrishJig.start();
                    isPlaying = 1;
                    irishJig.setText(R.string.pause_irish_jig);
                    bagpipesSong.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpIrishJig.pause();
                    isPlaying = 0;
                    irishJig.setText(R.string.irish_jig);
                    bagpipesSong.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener listenerBagpipesSong = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (isPlaying){
                case 0:
                    mpbapipesSong.start();
                    isPlaying = 1;
                    bagpipesSong.setText(R.string.pause_bagpipes_song);
                    irishJig.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpbapipesSong.pause();
                    isPlaying = 0;
                    bagpipesSong.setText(R.string.bagpipes_song);
                    irishJig.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
