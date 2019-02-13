package com.simy.temperatureconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show Welcome message
        Toast WelcomeToast = Toast.makeText(getApplicationContext(),"Welcome to my App",Toast.LENGTH_LONG);
        WelcomeToast.show();

        //Convert Button
        final Button convertButton = findViewById(R.id.button_convert);

        //Fahrenheit edit text
        final EditText fahrenheitEditText = findViewById(R.id.text_temp_fahrenheit);

        //Celsius edit text
        final EditText celsiusEditText = findViewById(R.id.text_temp_celsius);

        //Image Element
        final ImageView weatherImage = findViewById(R.id.weather_image);

        convertButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               String fahrenheitValue =  fahrenheitEditText.getText().toString();
               Float fahrenheitValueFloat = Float.parseFloat(fahrenheitValue);
               Float result = (fahrenheitValueFloat - 32) * 5/9;

               if(result <= 0){
                   weatherImage.setImageResource(R.drawable.snowflake);
               }else{
                    weatherImage.setImageResource(R.drawable.sunny);
               }
               //Set the result
               celsiusEditText.setText(result.toString());
           }
        });
    }
}
