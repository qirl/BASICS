
package com.example.qi.paediatricstroketriagetool;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnButton = (Button) findViewById(R.id.button);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, triage.class);
                startActivity(intent);
            }
        });

        btnButton = (Button) findViewById(R.id.button1);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, stroke.class);
                startActivity(intent);
            }
        });
    }
  }

