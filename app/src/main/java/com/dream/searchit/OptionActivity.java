package com.dream.searchit;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);


    }

    public void personview1(View view){
        Intent intent = new Intent(OptionActivity.this,AddPerson.class);
        startActivity(intent);
        finish();
    }

    public void orgview1(View view){
        Intent intent = new Intent(OptionActivity.this,AddOrganizaton.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed()
    {

        /*Intent moveback =
                new Intent(OptionActivity.this, MainActivity.class);
        startActivity(moveback);*/
        finish();
    }
}
