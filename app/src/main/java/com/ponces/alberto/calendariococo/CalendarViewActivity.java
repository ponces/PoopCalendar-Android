package com.ponces.alberto.calendariococo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class CalendarViewActivity extends ActionBarActivity {

    private Controller ctrl;
    private String date;
    private String table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            date = extras.getString("date");
        }
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        table = sharedPrefs.getString("table_list", "cozinho");
        ctrl = new Controller(this);
        updateDrawables();
        updateDescription();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateDescription() {
        ctrl.searchDay(date);
        String description = ctrl.getDescription();
        TextView textView2 = (TextView) findViewById(R.id.calendarview_textView2);
        textView2.setText(String.format(getResources().getString(R.string.description), description));
    }

    private void updateDrawables() {
        ImageView imageView2 = (ImageView) findViewById(R.id.calendarview_imageView2);
        ImageView imageView4 = (ImageView) findViewById(R.id.calendarview_imageView4);
        if(table.equals("cozinho")) {
            imageView2.setImageResource(R.drawable.cozinha);
            imageView4.setImageResource(R.drawable.cozinha);
        } else {
            imageView2.setImageResource(R.drawable.cozinho);
            imageView4.setImageResource(R.drawable.cozinho);
        }
    }
}
