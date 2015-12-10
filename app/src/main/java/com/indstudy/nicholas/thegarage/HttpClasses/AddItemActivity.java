package com.indstudy.nicholas.thegarage.HttpClasses;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.indstudy.nicholas.thegarage.InputException;
import com.indstudy.nicholas.thegarage.Items;
import com.indstudy.nicholas.thegarage.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AddItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Items itemType;
    private String mTitle, json;
    protected String mEmail;
    private final String[] titles = {"Home", "Books", "Comics & Graphic Novels", "Movies & TV Series",
            "Music", "Tabletop Games", "Video Games"};
    private Spinner spinner;
    FloatingActionButton fab;
    Fragment mFragment = null;
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
        mEmail = bundle.getString("email");

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    json = ((OnSubmitButtonClickedListener) mFragment).onSubmitClicked();
                    try {
                        new HttpASyncTask().execute(buildUrl());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), json, Toast.LENGTH_LONG).show();
                } catch (InputException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    //e.printStackTrace();
                } catch (ClassCastException cce) {
                    cce.printStackTrace();
                }
            }
        });

        spinner = (Spinner) findViewById(R.id.add_item_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.add_item_spinner_list, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        determineItem();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mTitle = titles[position];
        determineItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
        setItemType(0);
    }

    //TODO add a valid method here
    public void onBackButtonPressed(){

    }

    public void determineItem() {
        switch (mTitle) {
            case "Home":
                spinner.setSelection(0);
                setItemType(0);
                updateActionBar();
                itemType = null;
                break;
            case "Books":
                spinner.setSelection(1);
                setItemType(1);
                updateActionBar();
                itemType = Items.BOOK;
                break;
            case "Comics & Graphic Novels":
                spinner.setSelection(2);
                setItemType(2);
                updateActionBar();
                itemType = Items.COMIC;
                break;
            case "Movies & TV Series":
                spinner.setSelection(3);
                setItemType(3);
                updateActionBar();
                itemType = Items.MOVIETV;
                break;
            case "Music":
                spinner.setSelection(4);
                setItemType(4);
                updateActionBar();
                itemType = Items.MUSIC;
                break;
            case "Tabletop Games":
                spinner.setSelection(5);
                setItemType(5);
                updateActionBar();
                itemType = Items.TABLETOP;
                break;
            case "Video Games":
                spinner.setSelection(6);
                setItemType(6);
                updateActionBar();
                itemType = Items.VIDEOGAME;
                break;
        }
    }

    public void setItemType(int position) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (position) {
            case 0:
                if (mFragment != null)
                    fragmentTransaction.remove(mFragment);
                fab.setVisibility(View.GONE);
                break;
            case 1:
                mFragment = AddBookFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 2:
                mFragment = AddComicFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 3:
                mFragment = AddMovieTvFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 4:
                mFragment = AddMusicFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 5:
                mFragment = AddTabletopFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 6:
                mFragment = AddVideoGameFragment.newInstance();
                fragmentTransaction.replace(R.id.add_item_empty_layout, mFragment);
                fab.setVisibility(View.VISIBLE);
                break;
        }
        fragmentTransaction.addToBackStack(null).commit();
    }

    public void updateActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Add " + mTitle);
            if (mTitle.compareToIgnoreCase("Home") == 0)
                actionBar.setTitle("Add Item");
        }
    }

    public interface OnSubmitButtonClickedListener {
        String onSubmitClicked() throws InputException;
    }

    private URL buildUrl() throws MalformedURLException {
        String BASE_URL = "http://10.0.2.2:8080/TheArchive/";
        String type = null;
        switch (itemType) {
            case BOOK:
                type = "books";
                break;
            case COMIC:
                type = "comics";
                break;
            case MOVIETV:
                type = "movies";
                break;
            case MUSIC:
                type = "music";
                break;
            case TABLETOP:
                type = "tabletop";
                break;
            case VIDEOGAME:
                type = "videogames";
        }
        return new URL(BASE_URL + type);
    }

    private String Post(URL url) {
        StringBuilder result = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("PUT");
            //httpURLConnection.connect();
            OutputStreamWriter oWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            oWriter.write(json);
            //oWriter.flush();
            oWriter.close();
            //InputStream inputStream =
            httpURLConnection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return result.toString();
    }

    private class HttpASyncTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            return Post(urls[0]);
        }
    }

}
