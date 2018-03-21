package com.dream.searchit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dream.searchit.models.Contact_info;

import java.util.ArrayList;

import static android.R.attr.data;

public class DisplayActivity extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private Contact_info info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txt1= (TextView) findViewById(R.id.display_text_1);
        txt2= (TextView) findViewById(R.id.display_text_2);
        txt3= (TextView) findViewById(R.id.display_text_3);

        info= (Contact_info) getIntent().getSerializableExtra("Name");

        String name = info.getName().toString();
        String num = info.getNumber().toString();
        String add = info.getAddress();


        txt1.setText(name);
        txt2.setText(num);
        txt3.setText(add);


    }
}
