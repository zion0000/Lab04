package com.example.zaiets42ipzlab04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    Spinner spinner;
    TextView text1;
    TextView text2;
    TextView text3;
    RadioButton radiobutton1;
    RadioButton radiobutton2;
    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    String profession;
    String firstName;
    String lastName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Bundle arguments = getIntent().getExtras();
        firstName = arguments.get("firstName").toString();
        lastName = arguments.get("lastName").toString();
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        radiobutton1 = (RadioButton) findViewById(R.id.radioButton1);
        radiobutton2 = (RadioButton) findViewById(R.id.radioButton2);
        checkbox1 = (CheckBox) findViewById(R.id.checkBox);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        spinner = (Spinner) findViewById(R.id.spinner);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        text1.setText("Виберіть професію: "+firstName);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Помилка, виберіть щось",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton1:
                        Toast.makeText(getApplicationContext(), "Програміст",
                                Toast.LENGTH_SHORT).show();
                        profession = "Програміст";
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(), "Інформатик",
                                Toast.LENGTH_SHORT).show();
                        profession = "Інформатик";
                        break;

                }
            }
        });
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, ReceiveActivity.class);

        int position = spinner.getSelectedItemPosition();

        intent.putExtra("profession", profession);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);

        String act ="";
        if(checkbox1.isChecked()) act = act+"Лекції.";
        if(checkbox2.isChecked()) act = act+"Практичні роботи.";
        if(checkbox3.isChecked()) act = act+"Лабораторні роботи.";

        intent.putExtra("act", act);
        String[] data = getResources().getStringArray(R.array.data);;
        intent.putExtra("program", data[position]);
        startActivity(intent);

    }
}