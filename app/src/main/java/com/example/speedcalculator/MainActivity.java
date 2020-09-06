package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText distance_textNum;
    private EditText time_textNum;
    private TextView speed_textView;
    private Button calculate_bt;
    private Button clear_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distance_textNum = findViewById(R.id.distance_textNum);
        time_textNum = findViewById(R.id.time_textNum);
        calculate_bt = findViewById(R.id.calculate_bt);
        calculate_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String distance = distance_textNum.getText().toString();
                String time = time_textNum.getText().toString();
                if(distance.equals("") || time.equals("")){
                    Toast.makeText(MainActivity.this, R.string.required,Toast.LENGTH_LONG).show();
                }else if (!distance.equals("") & !time.equals("") & time.equals("0")){
                    Toast.makeText(MainActivity.this, R.string.zero,Toast.LENGTH_LONG).show();
                }else{
                    double speed_d = ((Double.parseDouble(distance)/Double.parseDouble(time))*3600)/1000;
                    String msg = String.format(Locale.getDefault(), "%.2f", speed_d);
                    speed_textView = findViewById(R.id.speed_textView);
                    speed_textView.setText(msg);
                    if(speed_d > 80){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("SPEED CALCULATOR").setMessage(R.string.limit).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
                    }
                }
            }
        });
        clear_bt = findViewById(R.id.clear_bt);
        clear_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distance_textNum.setText("");
                time_textNum.setText("");
            }
        });
    }
}