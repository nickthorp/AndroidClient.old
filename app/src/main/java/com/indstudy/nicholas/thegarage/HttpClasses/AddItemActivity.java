package com.indstudy.nicholas.thegarage.HttpClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.indstudy.nicholas.thegarage.R;

public class AddItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String mTitle;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mTitle = bundle.getString("title");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.add_item_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.add_item_spinner_list, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        switch (mTitle){
            case "Home": spinner.setSelection(0);
                setItemType(0); updateActionBar();
                break;
            case "Books": spinner.setSelection(1);
                setItemType(1); updateActionBar();
                break;
            case "Comics & Graphic Novels": spinner.setSelection(2);
                setItemType(2); updateActionBar();
                break;
            case "Movies & TV Series": spinner.setSelection(3);
                setItemType(3); updateActionBar();
                break;
            case "Music": spinner.setSelection(4);
                setItemType(4); updateActionBar();
                break;
            case "Tabletop Games": spinner.setSelection(5);
                setItemType(5); updateActionBar();
                break;
            case "Video Games": spinner.setSelection(6);
                setItemType(6); updateActionBar();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setItemType(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }

    public void setItemType(int position){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    public void updateActionBar(){
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mTitle);
            if (mTitle.compareToIgnoreCase("Home") == 0)
                actionBar.setTitle("Add Item");

        }
    }
}
