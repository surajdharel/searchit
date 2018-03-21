package com.dream.searchit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dream.searchit.models.Contact_info;

public class AddPerson extends AppCompatActivity {
    private EditText tv_first;
    private EditText tv_second;
    private EditText tv_third;
    private Button btn_person;
    private DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        handler = new DatabaseHandler(this);

        tv_first= (EditText) findViewById(R.id.edit_first_person);
        tv_second= (EditText) findViewById(R.id.edit_second_person);
        tv_third= (EditText) findViewById(R.id.edit_third_person);

        btn_person= (Button) findViewById(R.id.person_button);
        btn_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tv_first.getText().toString();
                long phone = Long.parseLong(tv_second.getText().toString());
                String address = tv_third.getText().toString();

                Contact_info contact1 = new Contact_info(name, phone, address);
                DatabaseHandler handler = new DatabaseHandler(AddPerson.this);
                long a = handler.AddContact(contact1);

                if(a!=-1){
                    Toast.makeText(AddPerson.this,"Contact successfully saved!",Toast.LENGTH_SHORT).show();
                    finish();


                }
                else{
                    Toast.makeText(AddPerson.this,"Error!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}
