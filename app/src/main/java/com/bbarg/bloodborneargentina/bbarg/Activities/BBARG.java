package com.bbarg.bloodborneargentina.bbarg.Activities;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.widget.Toast;

import com.bbarg.bloodborneargentina.bbarg.App.BbargApp;
import com.bbarg.bloodborneargentina.bbarg.Fragments.CardFragment;
import com.bbarg.bloodborneargentina.bbarg.Fragments.PJFragment;
import com.bbarg.bloodborneargentina.bbarg.Fragments.RankingFragment;
import com.bbarg.bloodborneargentina.bbarg.Fragments.WebPageFragment;
import com.bbarg.bloodborneargentina.bbarg.Fragments.basicStatFragment;
import com.bbarg.bloodborneargentina.bbarg.R;

public class BBARG extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Context mContex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbarg);

        mContex = this;

        // Bind layout components
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        SetToolBar();

        //** Set general Height and Width
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        BbargApp.finalWidth = size.x;
        BbargApp.finalHeight = BbargApp.finalWidth/2;
        BbargApp.totalWidth = size.x;
        BbargApp.totalHeight = size.y;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch(item.getItemId()){
                    /*case R.id.menu_draw_pjs:
                        fragment = new PJFragment();
                        fragmentTransaction = true;
                        break;*/
                    case R.id.menu_draw_ranking:
                        fragment = new RankingFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_draw_lore:
                        fragment = new CardFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_draw_web:
                        fragment = new WebPageFragment();
                        fragmentTransaction = true;
                        break;
                }

                if(fragmentTransaction)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, fragment).commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });



    }

    private void SetToolBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_hamb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open nav. drawer
                drawerLayout.openDrawer(GravityCompat.START, true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
