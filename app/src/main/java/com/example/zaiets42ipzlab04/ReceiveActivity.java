package com.example.zaiets42ipzlab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        Bundle arguments = getIntent().getExtras();
        String profession = arguments.get("profession").toString();
        String firstName = arguments.get("firstName").toString();
        String lastName = arguments.get("lastName").toString();
        String act = arguments.get("act").toString();

        String program = arguments.get("program").toString();

        if (act == "") act = "не зацікавлений";

        TextView valText = (TextView)findViewById(R.id.textView);

        valText.setText("Студент: "+lastName+" "+firstName+".\nОбрав спеціальність: "+profession+".\nОбрав активності: "+program + ".\nЩо хотів би включити в курс QA: "+act);
    }
}
