package com.dream.searchit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.searchit.models.Contact_info;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.animation;
import static android.R.attr.name;
import static android.R.attr.visible;
import static com.dream.searchit.R.id.drawer;
import static com.dream.searchit.R.id.mdrawer;
import static com.dream.searchit.R.id.relative;
import static com.dream.searchit.R.id.start;

public class MainActivity extends AppCompatActivity  {
    private Button btn_add;
    private Button btn_search;
    private DatabaseHandler handler;
    private ArrayList<Contact_info> contactInfos;
    ArrayList<String> namelist;
    private RelativeLayout relativeLayout;
    private AutoCompleteTextView autoCompleteTextView;
    private TextView text_view;
    private ImageView img;
    private boolean animation1 = false;
    private Contact_info info;
    private Contact_info c;
    private ImageView img_clear;
    public static final int REQUEST_CODE = 100;
    public DrawerLayout drawer;
    public ImageView nav_drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toogle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer= (DrawerLayout) findViewById(R.id.mdrawer);

        namelist = new ArrayList<>();
        handler = new DatabaseHandler(MainActivity.this);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autotext);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        text_view = (TextView) findViewById(R.id.txt_1);
        text_view.setVisibility(View.VISIBLE);
        img = (ImageView) findViewById(R.id.img);
        img.setVisibility(View.VISIBLE);
        img_clear= (ImageView) findViewById(R.id.btn_cancel);
        img_clear.setVisibility(View.INVISIBLE);


        btn_add = (Button) findViewById(R.id.btn_click1);
        btn_add.setVisibility(View.INVISIBLE);
        btn_search = (Button) findViewById(R.id.btn_click);
        btn_search.setVisibility(View.INVISIBLE);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer, R.string.nav_drawer_close);

        drawer.addDrawerListener(toogle);
        toogle.syncState();


        /*nav_drawer = (ImageView) findViewById(R.id.nav_drawer);
        nav_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });*/


        NavigationView navigationView = (NavigationView) findViewById(R.id.Nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.nav_view) {

                        ViewFragment viewFragment = new ViewFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().add(R.id.relative3, viewFragment).addToBackStack(null).commit();


                        fragmentManager.beginTransaction().replace(R.id.relative3, viewFragment).commit();
                        drawer.closeDrawer(GravityCompat.START);


                    }
                    else if(id==R.id.nav_settings) {


                        settingFragment settingFragment = new settingFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().add(R.id.relative3, settingFragment).addToBackStack(null).commit();
                        fragmentManager1.beginTransaction().replace(R.id.relative3, settingFragment).commit();

                        drawer.closeDrawer(GravityCompat.START);


                    }

                    else if(id==R.id.nav_help) {

                        HelpFragment HelpFragment = new HelpFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().add(R.id.relative3, HelpFragment).addToBackStack(null).commit();
                        fragmentManager2.beginTransaction().replace(R.id.relative3, HelpFragment).commit();
                        drawer.closeDrawer(GravityCompat.START);





                }
                else if(id==R.id.dw){

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.surajdharel.com.np"));
                    startActivity(browserIntent);
                }



                    return false;

            }
        });



        img_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView.setText("");
            }
        });

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animation1 == false) {

                    Animation animation = new TranslateAnimation(0, 0, 200, 0);
                    animation.setDuration(500);
                    animation.setFillAfter(true);
                    autoCompleteTextView.startAnimation(animation);
                    autoCompleteTextView.setHint("Please enter name..");
                    animation1 = true;
                }

                relativeLayout.setGravity(Gravity.TOP);
                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setDuration(2100);
                btn_add.setAnimation(fadeIn);
                btn_search.setAnimation(fadeIn);

                btn_add.setVisibility(View.VISIBLE);
                btn_search.setVisibility(View.VISIBLE);
                text_view.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);



            }
        });


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int index = namelist.indexOf(autoCompleteTextView.getText().toString());
                c = contactInfos.get(index);


            }
        });



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlphaAnimation buttonClick = new AlphaAnimation(0.2F, 0.3F);
                view.startAnimation(buttonClick);
                Intent intent = new Intent(MainActivity.this, OptionActivity.class);
                startActivity(intent);

            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlphaAnimation buttonClick = new AlphaAnimation(0.2F, 0.3F);
                view.startAnimation(buttonClick);

                String searchname = autoCompleteTextView.getText().toString();
                if (searchname.isEmpty()) {

                    Toast.makeText(MainActivity.this, "please enter the name!", Toast.LENGTH_SHORT).show();
                } else if (!namelist.contains(searchname)) {
                    Toast.makeText(MainActivity.this, "Sorry, Contact donot exist!", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, TabActivity.class);
                    intent.putExtra("Name", c);
                    intent.putExtra("Name1", c);
                    startActivity(intent);

                }


            }

        });


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, namelist);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                img_clear.setVisibility(View.VISIBLE);
                contactInfos = handler.searchInfo(charSequence.toString());
                namelist.clear();
                for (int j = 0; j < contactInfos.size(); j++) {
                    info = contactInfos.get(j);
                    String name = info.getName();
                    namelist.add(name);
                    //namelist is used because autocomplete text view can handle only strings type data only..

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



    @Override
    public void onBackPressed() {


        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else {
            super.onBackPressed();
        }

    }

}
