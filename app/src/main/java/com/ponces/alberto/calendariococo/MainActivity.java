package com.ponces.alberto.calendariococo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
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


public class MainActivity extends AppCompatActivity {

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
        toolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        setTitle(R.string.title_activity_today);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.main_nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!sharedPrefs.contains("table_list")) {
            if(Locale.getDefault().getLanguage().equals("en")) {
                table = "cozinho";
            } else {
                table = "cozinha";
            }
            sharedPrefs.edit().putString("table_list", table).apply();
        } else {
            table = sharedPrefs.getString("table_list", "cozinho");
        }
        ctrl = new Controller(this);
        updateHeader();
        updateDrawables();
        updateDescription();
        createService();
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

            case R.id.action_refresh:
                updateDescription();
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
            updateDrawables();
            updateDescription();
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
        boolean start = true, settings = false;
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                start = false;
                break;
            case R.id.nav_second_fragment:
                intent = new Intent(this, CalendarActivity.class);
                break;
            case R.id.nav_third_fragment:
                intent = new Intent(this, CardsActivity.class);
                break;
            case R.id.nav_fourth_fragment:
                intent = new Intent(this, SettingsActivity.class);
                settings = true;
                break;
            case R.id.nav_fifth_fragment:
                showAboutDialog();
                start = false;
                break;
            default:
                start = false;
        }
        if(start) {
            startActivity(intent);
            if(!settings) {
                // Highlight the selected item, update the title, and close the drawer
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                finish();
            }
        }
        mDrawer.closeDrawers();
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogStyle);
        builder.setTitle(R.string.about);
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
        TextView textView = (TextView) findViewById(R.id.header_textView);
        ImageView imageView = (ImageView) findViewById(R.id.header_imageView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.header_linearLayout);
        if(table.equals("cozinho")) {
            textView.setText(String.format(getResources().getString(R.string.header_text), "Cózinho"));
            imageView.setImageResource(R.drawable.cozinho);
        } else {
            textView.setText(String.format(getResources().getString(R.string.header_text), "Cózinha"));
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

    private void updateDescription() {
        ctrl.searchDay("today");
        String description = ctrl.getDescription();
        TextView textView2 = (TextView) findViewById(R.id.main_textView2);
        textView2.setText(String.format(getResources().getString(R.string.description), description));
    }

    private void updateDrawables() {
        ImageView imageView2 = (ImageView) findViewById(R.id.main_imageView2);
        ImageView imageView4 = (ImageView) findViewById(R.id.main_imageView4);
        if(table.equals("cozinho")) {
            imageView2.setImageResource(R.drawable.cozinha);
            imageView4.setImageResource(R.drawable.cozinha);
        } else {
            imageView2.setImageResource(R.drawable.cozinho);
            imageView4.setImageResource(R.drawable.cozinho);
        }
    }

    private void createService() {
        //c.add(java.util.Calendar.SECOND, 2);
    }
}
