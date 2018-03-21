package com.dream.searchit;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Navigation extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout mdrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mdrawer = (DrawerLayout) findViewById(R.id.mdrawer);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, mdrawer , R.string.nav_drawer, R.string.nav_drawer_close);

        mdrawer.addDrawerListener(toogle);
        toogle.syncState();


    }
}
