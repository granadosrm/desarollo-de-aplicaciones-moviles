package com.example.imgs_sonido_vibrar;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    TextView letrero;
    Button btn;
    int sr, temp;
    int son=0;

    SoundPool sp;
    int sonido;
    MediaPlayer mp;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asociando atributos, id, layout
        imagen = (ImageView) findViewById(R.id.imageView);
        letrero = (TextView) findViewById(R.id.texto);
        btn = (Button) findViewById(R.id.button);

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonido = sp.load(this, R.raw.fatality, 1);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        mostrarRand();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = sr;
                //Vibrar1();
                mostrarRand();
            }
        });
    }

    //mostrar valores de aleatorio
    public void mostrarRand() {
        sr = ThreadLocalRandom.current().nextInt(0, 7);

        while (temp == sr) {
            sr = ThreadLocalRandom.current().nextInt(0, 7);
        }
        imagen.setImageResource(randArray[sr].getImagen());
        letrero.setText(randArray[sr].getAleatorio());

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Random rand = new Random();
        int n = rand.nextInt(1000);
        long[] pattern = {n,n,n,n};
        vibrator.vibrate(pattern, -1);

        stopPlying();
        mp = MediaPlayer.create(this,randArray[sr].getSonido());
        mp.start();
    }

    aleatorio i1 = new aleatorio(R.drawable.uno, "img 1",R.raw.fatality);
    aleatorio i2 = new aleatorio(R.drawable.dos, "img 2",R.raw.gta);
    aleatorio i3 = new aleatorio(R.drawable.tres, "img 3",R.raw.legends);
    aleatorio i4 = new aleatorio(R.drawable.cuatro, "img 4",R.raw.mammamia);
    aleatorio i5 = new aleatorio(R.drawable.cinco, "img 5",R.raw.mariojuego);
    aleatorio i6 = new aleatorio(R.drawable.seis, "img 6",R.raw.nigga);
    aleatorio i7 = new aleatorio(R.drawable.siete, "img 7",R.raw.pacman);

    //llenando array
    aleatorio[] randArray = new aleatorio[]{
            i1, i2, i3, i4, i5, i6, i7
    };

    //metodo para permutar aleatoriamente una lista, utilizando como fuente el vector randArray
    public void randoms() {
        //  Collections.shuffle(Arrays.asList(randArray));
    }
    public void Tono() {
        sp.play(sonido, 1, 1, 1, 0, 0);
        stopPlying();
        mp = MediaPlayer.create(this, R.raw.pacman);
        mp.start();
    }



    public void silencio(View view){
        stopPlying();
    }

    public void Vibrar1(){
        long[] tiempo = {0,100,1000,200,900,300,800,400,700};
        vibrator.vibrate(tiempo,-1);
    }

    //metodo para detener e iniciar nueva reproduccion
    private void stopPlying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
