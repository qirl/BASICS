package com.example.qi.paediatricstroketriagetool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculatortriage extends AppCompatActivity {

    private TextView View1;
    private TextView View2;
    private TextView View3;
    private Button btnjump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatortriage);

        View1 = (TextView) findViewById(R.id.mimics_triage);
        View2 = (TextView) findViewById(R.id.isch_triage);
        View3 = (TextView) findViewById(R.id.hae_triage);

        Intent intent = getIntent();
        double prob_mimics = intent.getDoubleExtra("strokemimics",0.0);
        double prob_ischamic = intent.getDoubleExtra("ischaemic",0.0);
        double prob_haemorrhagic = intent.getDoubleExtra("haemorrhagic",0.0);

        View1.setText("The probability of stroke mimics is " + prob_mimics);
        View2.setText("The probability of ischaemic stroke is " + prob_ischamic);
        View3.setText("The probability of haemorrhagic stroke is " + prob_haemorrhagic);

        btnjump = (Button)findViewById(R.id.jumptomain);
        btnjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(calculatortriage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
