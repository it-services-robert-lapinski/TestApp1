package com.example.robertapiski.testapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.example.robertapiski.testapp1.data.Species;
import com.example.robertapiski.testapp1.data.SpeciesDictionary;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> projects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> itemsToAutoComplete = new ArrayList<String>();
        projects = new ArrayList<String>();

        try {
            Reader reader = new InputStreamReader(getResources().openRawResource(R.raw.species));
            YamlReader yamlReader = new YamlReader(reader);
            SpeciesDictionary speciesDictionary = yamlReader.read(SpeciesDictionary.class);

            for (Species s : speciesDictionary.getSpeciesList()) {
                itemsToAutoComplete.add(s.getLaName());
            }

            AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsToAutoComplete);
            textView.setAdapter(adapter);
        } catch (YamlException e) {
            e.printStackTrace();
        }
    }

    public void addProject(View v) {
        ListView projectsList = (ListView) findViewById(R.id.projectsList);
        AutoCompleteTextView itemName = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        projects.add(itemName.getText().toString());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, projects);
        projectsList.setAdapter(adapter);
    }

    public void saveProjectsList(View v) {

    }
}
