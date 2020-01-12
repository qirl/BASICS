package com.example.qi.paediatricstroketriagetool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class calculatorstroke extends AppCompatActivity {

    private TextView ViewStrokemimics;
    private TextView Viewhaemorrhagicstroke;
    private TextView Viewischaemicstroke;
    private TextView ViewNIHSS;
    private TextView ViewGCS;
    private Button btnjump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatorstroke);

        ViewStrokemimics = (TextView) findViewById(R.id.strokemimics);
        Viewischaemicstroke = (TextView)findViewById(R.id.ischaemicstroke);
        Viewhaemorrhagicstroke = (TextView)findViewById(R.id.haemorrhagicstroke);
        ViewNIHSS = (TextView) findViewById(R.id.NIHSS);
        ViewGCS = (TextView)findViewById(R.id.GCS);

        Intent intent = getIntent();
        double prob_mimics = intent.getDoubleExtra("strokemimics",0.0);
        double prob_ischamic = intent.getDoubleExtra("ischaemic",0.0);
        double prob_haemorrhagic = intent.getDoubleExtra("haemorrhagic",0.0);
        int NIHSSscore = intent.getIntExtra("nihssscore",0);
        int GCSscore = intent.getIntExtra("gcsscore",0);

            ViewNIHSS.setText("The Paediatric NIHSS score is " + NIHSSscore);
            ViewGCS.setText("The Glasgow Coma Scale (GCS) is " + GCSscore);
            ViewStrokemimics.setText("The probability of stroke mimics is " + prob_mimics);
            Viewischaemicstroke.setText("The probability of ischaemic stroke is " + prob_ischamic);
            Viewhaemorrhagicstroke.setText("The probability of haemorrhagic stroke is " + prob_haemorrhagic);

            btnjump = (Button)findViewById(R.id.button2);
            btnjump.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(calculatorstroke.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
