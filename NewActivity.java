package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    TextView name;
    TextView gender;
    TextView receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        name = (TextView)findViewById(R.id.nameV);
        gender= (TextView)findViewById(R.id.genderV);
        receive= (TextView)findViewById(R.id.receiveV);

        Intent intent = getIntent();//intent 받는다.
        Bundle myBundle = new Bundle();//번들을 만든다.
         myBundle= intent.getExtras();//intent에서 번들을 가져온다.

        gender.setText(myBundle.getString("gender"));
        name.setText(myBundle.getString("name"));
        receive.setText(myBundle.getString("receive"));

        Button button = (Button) findViewById(R.id.button);
        int i =1;
        i=2;

button.setOnClickListener(new View.OnClickListener()
{

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
});
    }
}
