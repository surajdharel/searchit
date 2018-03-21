package com.dream.searchit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.dream.searchit.models.Contact_info;

import java.util.ArrayList;
import java.util.Arrays;

public class TestActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private Button searchbutton;
    private Button addbutton;
    ArrayList<String> namelist;
    private DatabaseHandler handler;
    private ArrayList<Contact_info> contactInfos;
    private Contact_info info;
    private Contact_info c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        handler= new DatabaseHandler(TestActivity.this);
        namelist=new ArrayList<>();

       autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autotextview);
        searchbutton= (Button) findViewById(R.id.button_search_1);
        addbutton= (Button) findViewById(R.id.button_add_1);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int index = namelist.indexOf(autoCompleteTextView.getText().toString());
                //if not using above code, autocompletetext view always takes only postion 0..

                c= contactInfos.get(index);


            }
        });



        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlphaAnimation buttonClick = new AlphaAnimation(0.2F, 0.3F);
                view.startAnimation(buttonClick);
                Intent intent = new Intent(TestActivity.this, OptionActivity.class);
                startActivity(intent);

            }
        });
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlphaAnimation buttonClick = new AlphaAnimation(0.2F, 0.3F);
                view.startAnimation(buttonClick);

                String searchname = autoCompleteTextView.getText().toString();
                if (searchname.isEmpty()) {

                    Toast.makeText(TestActivity.this, "please enter the name!", Toast.LENGTH_SHORT).show();
                } else if (!namelist.contains(searchname)) {
                    Toast.makeText(TestActivity.this, "Sorry, Contact donot exist!", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(TestActivity.this, TabActivity.class);
                    intent.putExtra("Name", c);
                    startActivity(intent);

                }


            }

        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(TestActivity.this, android.R.layout.simple_spinner_dropdown_item, namelist);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                contactInfos = handler.searchInfo(charSequence.toString());
                namelist.clear();
                for (int j = 0; j < contactInfos.size(); j++) {
                    info = contactInfos.get(j);
                    String name = info.getName();
                    namelist.add(name);

                }

                adapter.clear();
                adapter.addAll(namelist);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });






    }
}
