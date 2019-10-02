package com.example.carwash_newactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText washes;
    private RadioGroup type;
    private Button calculate;
    private TextView total;

    private CarWash carWash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carWash = new CarWash();

        washes = (EditText)findViewById(R.id.washes);
        type = findViewById(R.id.type);
        calculate = findViewById(R.id.calculate);
        total = findViewById(R.id.total);

        //type.setOnCheckedChangeListener(typeListener);

        //displayTotal();
/*
        sendMessageBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent intent = new Intent( MainActivity.this, Main2Activity.class);
                intent.putExtra("message", "This is a message");
                startActivity(intent);

            }

        });

 */
        calculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Log.d("MyLogs", "onClick: MakeMoney!");

                Intent intent = new Intent( MainActivity.this, ResultActivity.class);


                intent.putExtra("message", "The total:"+getTotalDisplay());
                startActivity(intent);

                displayTotal();

                //  Log.d(tag:"Mylogs", msg:"onClick: MakeMoney!");
            }
        });
}

    private RadioGroup.OnCheckedChangeListener typeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int radioID) {
            switch (radioID) {
                case R.id.type1:
                    carWash.setType(CarWash.TYPE1);
                    break;

                case R.id.type2:
                    carWash.setType(CarWash.TYPE2);

                    Log.d("MyLogs", "Type 2: ");
                    break;

            }
            displayTotal();


        }
    };

private void displayTotal() {


    type.setOnCheckedChangeListener(typeListener);
    String str = washes.getText().toString();

    int num;
    if (str.isEmpty()) {
        num = 0;
    } else {

        num = Integer.parseInt(str);

        carWash.setWashes(num);



    String totalText = "$"+ carWash.getTotal();
    total.setText(totalText);

           // int num = Integer.parseInt(washes.getText().toString());

        Log.d("MyLogs", "onClick:" + str + "Washhh!" + carWash.getTotal());
    }
}


    private String getTotalDisplay() {


        type.setOnCheckedChangeListener(typeListener);
        String str = washes.getText().toString();

        String totalText="0";
        int num;
        if (str.isEmpty()) {
            num = 0;
        } else {

            num = Integer.parseInt(str);

            carWash.setWashes(num);



            totalText = "$"+ carWash.getTotal();


            // total.setText(totalText);

            // int num = Integer.parseInt(washes.getText().toString());

            Log.d("MyLogs", "onClick:" + str + "Washhh!" + carWash.getTotal());
        }
        return totalText;
    }


private void makeMoney(View view){

    displayTotal();

}

}
