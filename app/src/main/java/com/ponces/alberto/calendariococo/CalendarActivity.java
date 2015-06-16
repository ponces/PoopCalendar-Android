package com.ponces.alberto.calendariococo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;


public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    private Controller ctrl;
    private String table;
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        table = sharedPrefs.getString("table_list", "cozinho");
        ctrl = new Controller(this);
        updateHeader();
        searchDay();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;

            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;

            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.action_about);
                TextView msg = new TextView(this);
                msg.setText(R.string.about_message);
                msg.setGravity(Gravity.CENTER);
                builder.setView(msg);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        String table2 = sharedPrefs.getString("table_list", "cozinho");
        if(!table.equals(table2)) {
            table = table2;
            updateHeader();
            searchDay();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Intent intent = new Intent();
        boolean flag = true;
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.nav_second_fragment:
                flag = false;
                break;
            case R.id.nav_third_fragment:
                intent = new Intent(this, CardsActivity.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
        }
        if(flag) {
            startActivity(intent);
        }
        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void updateHeader() {
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        if(table.equals("cozinho")) {
            textView5.setText(String.format(getResources().getString(R.string.header_text), "Cózinho"));
            imageView.setImageResource(R.drawable.cozinho);
        } else {
            textView5.setText(String.format(getResources().getString(R.string.header_text), "Cózinha"));
            imageView.setImageResource(R.drawable.cozinha);
        }
        String season = ctrl.getSeason();
        if(season.equals("winter")) {
            linearLayout.setBackgroundResource(R.drawable.winter);
        } else if(season.equals("spring")) {
            linearLayout.setBackgroundResource(R.drawable.spring);
        } else if (season.equals("summer")) {
            linearLayout.setBackgroundResource(R.drawable.summer);
        } else if (season.equals("fall")) {
            linearLayout.setBackgroundResource(R.drawable.fall);
        } else {
            linearLayout.setBackgroundResource(R.drawable.season);
        }
    }

    private void searchDay() {
        ctrl.searchDay("today");
        String description = ctrl.getDescription();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.format(getResources().getString(R.string.description), description));
    }
}
