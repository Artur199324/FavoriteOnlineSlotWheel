package net.favorite.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ArrayList<ImageView> arrayList;
    protected Button start;
    TextView textViewScor;
    TextView textViewBet;
    TextView textViewWin;
    Button buttonm;
    Button buttonp;
    Button buttonma;

    ImageView imageView13;
    TextView textView4;
    Button button6;
    Button button7;
    Button button;


    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),StttActivity.class));
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);
        arrayList = new ArrayList<>();
        getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit().putInt("bet", 0).apply();
        buttonm = findViewById(R.id.buttonm);
        buttonp = findViewById(R.id.buttonp);
        buttonma = findViewById(R.id.buttonma);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        imageView13 = findViewById(R.id.imageView13);
        textView4 = findViewById(R.id.textView4);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StttActivity.class));
                finishAffinity();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RyllActivity.class));
                finishAffinity();
            }
        });

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        textViewScor = findViewById(R.id.textViewScor);
        textViewBet = findViewById(R.id.textViewBet);
        textViewWin = findViewById(R.id.textViewWin);



        arrayList.add(image1);
        arrayList.add(image2);
        arrayList.add(image3);
        arrayList.add(image4);
        arrayList.add(image5);
        arrayList.add(image6);
        arrayList.add(image7);
        arrayList.add(image8);
        arrayList.add(image9);
        start = findViewById(R.id.start);

        if (getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("scor", 2000) == 0) {
            imageView13.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.VISIBLE);
            button6.setVisibility(View.VISIBLE);
            button7.setVisibility(View.VISIBLE);
        }else {
            start();
            new Bet(this);
        }
    }

    protected void start() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewWin.setText("Win : " + 0);
                int h = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("bet", 0);
                if (h == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Place your bet", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (Bet.fff == false) {
                        int a = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("scor", 2000);
                        int b = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("bet", 0);
                        a -= b;
                        getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit().putInt("scor", a).apply();
                        textViewScor.setText("Score: " + a);
                    } else {
                        Bet.fff = false;
                    }
                    start.setClickable(false);
                    new Rand(arrayList, MainActivity.this);
                }

            }
        });
    }

    protected void res() {
        new Res(arrayList, MainActivity.this);
    }
}