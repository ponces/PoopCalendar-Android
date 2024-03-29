package com.ponces.poopcalendar;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateChangedListener;


public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private View hvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    private Controller ctrl;
    private String table;
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.calendar_drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.calendar_nvView);
        hvDrawer = nvDrawer.inflateHeaderView(R.layout.nav_header);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        MaterialCalendarView m = (MaterialCalendarView) findViewById(R.id.calendar_calendarView);
        m.setOnDateChangedListener(new OnDateChangedListener() {
            @Override
            public void onDateChanged(MaterialCalendarView materialCalendarView, CalendarDay calendarDay) {
                String strMonth, strDay;
                int month = calendarDay.getMonth() + 1;
                int day = calendarDay.getDay();
                if(month < 10) {
                    strMonth = "0" + month;
                } else {
                    strMonth = "" + month;
                }
                if(day < 10) {
                    strDay = "0" + day;
                } else {
                    strDay = "" + day;
                }
                Intent intent = new Intent(CalendarActivity.this, CalendarViewActivity.class);
                intent.putExtra("date", strMonth + "-" + strDay);
                startActivity(intent);
            }
        });

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        table = sharedPrefs.getString("table_list", "cozinho");
        ctrl = new Controller(this);
        updateHeader();
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
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.nav_second_fragment:
                start = false;
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
                intent = new Intent(this, MainActivity.class);
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
        TextView textView = (TextView) hvDrawer.findViewById(R.id.header_textView);
        ImageView imageView = (ImageView) hvDrawer.findViewById(R.id.header_imageView);
        LinearLayout linearLayout = (LinearLayout) hvDrawer.findViewById(R.id.header_linearLayout);
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
}
