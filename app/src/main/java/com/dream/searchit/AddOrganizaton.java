package com.dream.searchit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dream.searchit.models.Contact_info;

public class AddOrganizaton extends AppCompatActivity {
    private EditText tv_first1;
    private EditText tv_second1;
    private EditText tv_third1;
    private Button btn_person1;
    private DatabaseHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_organizaton);

        handler = new DatabaseHandler(this);

        tv_first1= (EditText) findViewById(R.id.edit_first_org);
        tv_second1= (EditText) findViewById(R.id.edit_second_org);
        tv_third1= (EditText) findViewById(R.id.edit_third_org);

        btn_person1= (Button) findViewById(R.id.org_button);
        btn_person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tv_first1.getText().toString();
                long phone = Long.parseLong(tv_second1.getText().toString());
                String address = tv_third1.getText().toString();

                Contact_info contact1 = new Contact_info(name, phone, address);
                DatabaseHandler handler = new DatabaseHandler(AddOrganizaton.this);
                long a = handler.AddContact(contact1);

                if(a!=-1){
                    Toast.makeText(AddOrganizaton.this,"Contact successfully saved!",Toast.LENGTH_SHORT).show();
                   /* Intent intent = new Intent();
                    intent.putExtra("info",contact1);
                    setResult(RESULT_OK,intent);*/
                    finish();


                }
                else{
                    Toast.makeText(AddOrganizaton.this,"Error!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
