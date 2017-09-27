package com.example.haloo.haloochat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ArrayList<String> _list = new ArrayList<String>();
        _list.add("Antti");
        _list.add("Pekka");
        _list.add("Joni");
        _list.add("Riku");

        ListView lv = (ListView)findViewById(R.id.listMessages);
        ArrayAdapter<String> adapterForList = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, _list
        );

        lv.setAdapter(adapterForList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contacts:
                //Show the contacts UI
                Intent intent1 = new Intent(getApplicationContext(), ContactsActivity.class);
                startActivityForResult(intent1, 10);
                return true;
            case R.id.menu_settings:
                //Show the settings UI
                Intent intent2 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivityForResult(intent2, 20);
                return true;
            default:
                //Unrecognized action
                return super.onOptionsItemSelected(item);
        }
    }
}
