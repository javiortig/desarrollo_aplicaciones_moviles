package com.example.t11navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;

import com.example.t11navigation.adapters.AdaptadorFragments;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigation;
    private ViewPager pager;
    private AdaptadorFragments adaptadorFragments;
    private TabLayout tabs;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navigation_view);
        pager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        adaptadorFragments = new AdaptadorFragments(getSupportFragmentManager());
        pager.setAdapter(adaptadorFragments);
        tabs.setupWithViewPager(pager);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.inicio_menu:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.compras_menu:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.ofertas_menu:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.carrito_menu:
                        pager.setCurrentItem(3);
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

}