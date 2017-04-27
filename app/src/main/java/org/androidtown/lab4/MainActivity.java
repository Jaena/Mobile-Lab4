package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox checkSMS;
    CheckBox checkEmail;
    RadioButton selectFemale;
    RadioButton selectMale;
RadioGroup selectGender;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.nameEdit);


        checkSMS = (CheckBox) findViewById(R.id.sms);
        checkEmail = (CheckBox) findViewById(R.id.email);

        button2 = (Button) findViewById(R.id.button1);
        selectGender = (RadioGroup) findViewById(R.id.selectGender);
        selectMale = (RadioButton) findViewById(R.id.male);
        selectFemale = (RadioButton) findViewById(R.id.female);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);// intent를 만든다.
                Bundle myBundle = new Bundle();//Bundle을 만든다.
                String name = editText.getText().toString();//적은 이름을 불러온다.
                String receive="";
                String gender="";

                if (checkSMS.isChecked())
                    {receive = "sms";}
                if (checkEmail.isChecked())
                {receive = "e-mail";}

                int radioId = selectGender.getCheckedRadioButtonId();
                if (selectMale.getId() == radioId)
                {gender = "남";}
                if (selectFemale.getId() == radioId)
                {gender = "여";}

                myBundle.putString("name",name);
                myBundle.putString("gender",gender);
                myBundle.putString("receive", receive);

                intent.putExtras(myBundle);

                startActivity(intent);

            }
        });

    }
}
