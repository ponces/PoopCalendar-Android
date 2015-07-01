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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CardsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView recyclerView;

    private Controller ctrl;
    private String table;
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.cards_drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.cards_nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        table = sharedPrefs.getString("table_list", "cozinho");
        ctrl = new Controller(this);
        updateHeader();

        recyclerView = (RecyclerView) findViewById(R.id.cards_recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        updateCards();
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
                updateCards();
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
            updateCards();
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
                intent = new Intent(this, CalendarActivity.class);
                break;
            case R.id.nav_third_fragment:
                start = false;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

    private void updateCards() {
        String[] strings = ctrl.getAll();
        String[] cards = new String[strings.length];
        for(int i = 0; i < strings.length; i++) {
            cards[i] = printDay(strings[i].split("/")[0]);
            cards[i] += "\n\nGosto de ti porque...\n";
            cards[i] += strings[i].split("/")[1];
        }
        RecyclerAdapter adapter = new RecyclerAdapter(cards);
        recyclerView.setAdapter(adapter);
    }

    private String printDay(String date) {
        int day = Integer.parseInt(date.split("-")[1]);
        String strDate = "";
        int month = Integer.parseInt(date.split("-")[0]);
        switch(day) {
            case 1:
                strDate = this.getString(R.string.day_1);
                break;
            case 2:
                strDate = this.getString(R.string.day_2);
                break;
            case 3:
                strDate = this.getString(R.string.day_3);
                break;
            case 4:
                strDate = this.getString(R.string.day_4);
                break;
            case 5:
                strDate = this.getString(R.string.day_5);
                break;
            case 6:
                strDate = this.getString(R.string.day_6);
                break;
            case 7:
                strDate = this.getString(R.string.day_7);
                break;
            case 8:
                strDate = this.getString(R.string.day_8);
                break;
            case 9:
                strDate = this.getString(R.string.day_9);
                break;
            case 10:
                strDate = this.getString(R.string.day_10);
                break;
            case 11:
                strDate = this.getString(R.string.day_11);
                break;
            case 12:
                strDate = this.getString(R.string.day_12);
                break;
            case 13:
                strDate = this.getString(R.string.day_13);
                break;
            case 14:
                strDate = this.getString(R.string.day_14);
                break;
            case 15:
                strDate = this.getString(R.string.day_15);
                break;
            case 16:
                strDate = this.getString(R.string.day_16);
                break;
            case 17:
                strDate = this.getString(R.string.day_17);
                break;
            case 18:
                strDate = this.getString(R.string.day_18);
                break;
            case 19:
                strDate = this.getString(R.string.day_19);
                break;
            case 20:
                strDate = this.getString(R.string.day_20);
                break;
            case 21:
                strDate = this.getString(R.string.day_21);
                break;
            case 22:
                strDate = this.getString(R.string.day_22);
                break;
            case 23:
                strDate = this.getString(R.string.day_23);
                break;
            case 24:
                strDate = this.getString(R.string.day_24);
                break;
            case 25:
                strDate = this.getString(R.string.day_25);
                break;
            case 26:
                strDate = this.getString(R.string.day_26);
                break;
            case 27:
                strDate = this.getString(R.string.day_27);
                break;
            case 28:
                strDate = this.getString(R.string.day_28);
                break;
            case 29:
                strDate = this.getString(R.string.day_29);
                break;
            case 30:
                strDate = this.getString(R.string.day_30);
                break;
            case 31:
                strDate = this.getString(R.string.day_31);
                break;
        }
        strDate +=  " " + this.getString(R.string.date_separator) + " ";
        switch(month) {
            case 1:
                strDate += this.getString(R.string.meses_january);
                break;
            case 2:
                strDate += this.getString(R.string.meses_february);
                break;
            case 3:
                strDate += this.getString(R.string.meses_march);
                break;
            case 4:
                strDate += this.getString(R.string.meses_april);
                break;
            case 5:
                strDate += this.getString(R.string.meses_may);
                break;
            case 6:
                strDate += this.getString(R.string.meses_june);
                break;
            case 7:
                strDate += this.getString(R.string.meses_july);
                break;
            case 8:
                strDate += this.getString(R.string.meses_august);
                break;
            case 9:
                strDate += this.getString(R.string.meses_september);
                break;
            case 10:
                strDate += this.getString(R.string.meses_october);
                break;
            case 11:
                strDate += this.getString(R.string.meses_november);
                break;
            case 12:
                strDate += this.getString(R.string.meses_december);
                break;
        }
        return strDate;
    }
}
