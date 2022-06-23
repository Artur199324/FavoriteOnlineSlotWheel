package net.favorite.games;

import static net.favorite.games.BetRul.ddd;
import static net.favorite.games.BetRul.www;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RyllActivity extends AppCompatActivity {

    ImageView imageViewRR;
    ImageView imageViewR;
    ImageView imageViewB;
    TextView textViewSC;
    Button buttonPP;
    Button buttonMM;
    Button buttonMax;
    Button buttonSS;
    TextView textViewBB;
    TextView textViewWWin;
    String coll;
    boolean col = false;
    Button button11;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),StttActivity.class));
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ryll);
        getWindow().addFlags(1024);
        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit().putInt("bet", 0).apply();
        imageViewRR = findViewById(R.id.imageViewRR);
        imageViewR = findViewById(R.id.imageViewR);
        imageViewB = findViewById(R.id.imageViewB);
        textViewSC = findViewById(R.id.textViewSC);

        buttonPP = findViewById(R.id.buttonPP);
        buttonMM = findViewById(R.id.buttonMM);
        buttonMax = findViewById(R.id.buttonMax);
        buttonSS = findViewById(R.id.buttonSS);
        textViewBB = findViewById(R.id.textViewBB);
        textViewWWin = findViewById(R.id.textViewWWin);
        new BetRul(this);

        imageViewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                col = true;
                coll = "rr";
                imageViewR.setImageResource(R.drawable.roun2);
                imageViewB.setImageResource(R.drawable.rounb);
            }
        });

        imageViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                col = true;
                coll = "bb";
                imageViewB.setImageResource(R.drawable.roundb2);
                imageViewR.setImageResource(R.drawable.roun);
            }
        });

        buttonSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                www = 0;
                textViewWWin.setText("Win : " + 0);
                int h = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("bet", 0);
                if (h == 0 ) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Place your bet", Toast.LENGTH_SHORT);
                    toast.show();
                } else {

                    if (col){
                        new MovRul(imageViewRR,RyllActivity.this);
                        if (ddd == false) {
                            int a = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("scor", 2000);
                            int b = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getInt("bet", 0);
                            a -= b;
                            getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit().putInt("scor", a).apply();
                            textViewSC.setText("Score: " + a);
                        } else {
                            Bet.fff = false;
                        }
                    }else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Place your bet", Toast.LENGTH_SHORT);
                        toast.show();
                    }



                }

            }
        });
    }
}