package com.example.robertapiski.testapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> projects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projects = new ArrayList<String>();
    }

    public void addProject(View v) {
        final ListView projectsList = (ListView) findViewById(R.id.projectsList);
        final TextView itemName = (TextView) findViewById(R.id.itemName);

        projects.add(itemName.getText().toString());

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, projects);
        projectsList.setAdapter(adapter);
    }
}
