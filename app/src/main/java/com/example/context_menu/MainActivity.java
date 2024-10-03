package com.example.context_menu;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView sudentlistview;
    String [] names;
    Resources resources;
    ArrayAdapter<String> stringArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initViews();
        initResources();

        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        sudentlistview.setAdapter(stringArrayAdapter);
        registerForContextMenu(sudentlistview);

    }
    private void initViews() {
        sudentlistview = findViewById(R.id.sudentlistview);

    }
    private void initResources() {
        resources = getResources();
        names = resources.getStringArray(R.array.names);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(this, "OnMenuOpnrd Called", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Toast.makeText(this, "OnCreateContextMenu Called", Toast.LENGTH_SHORT).show();

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "OnContextItemSelected Called", Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        Toast.makeText(this, "onContextMenuClosed called", Toast.LENGTH_SHORT).show();
        super.onContextMenuClosed(menu);
    }
}