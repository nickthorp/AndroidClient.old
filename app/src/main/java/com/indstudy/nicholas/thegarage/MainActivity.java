package com.indstudy.nicholas.thegarage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.indstudy.nicholas.thegarage.HttpClasses.AddItemActivity;
import com.indstudy.nicholas.thegarage.LibraryObjects.User;
import com.indstudy.nicholas.thegarage.MainFragments.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String mTitle;
    private String mEmail;
    public User user;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mEmail = bundle.getString("user email");
        user = new User();
        user.setEmail(mEmail);
        user.setFirstName("Nick");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, AddItemActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", mTitle);
                bundle1.putString("email", mEmail);
                intent1.putExtras(bundle1);
                startActivity(intent1);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance()).commit();
        try {
            new HttpASyncTask().execute(new URL("http://10.0.2.2:8080/TheArchive/books"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    // TODO: Integrate Fragments into this Main Activity
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (id == R.id.nav_home) {
            transaction.replace(R.id.container, HomeFragment.newInstance());
        } else if (id == R.id.nav_video_games) {
            transaction.replace(R.id.container, VideoGamesFragment.newInstance());
        } else if (id == R.id.nav_music) {
            transaction.replace(R.id.container, MusicFragment.newInstance());
        } else if (id == R.id.nav_books) {
            transaction.replace(R.id.container, BooksFragment.newInstance());
        } else if (id == R.id.nav_movies) {
            transaction.replace(R.id.container, MoviesTVFragment.newInstance());
        } else if (id == R.id.nav_comics) {
            transaction.replace(R.id.container, ComicsFragment.newInstance());
        } else if (id == R.id.nav_tt_games) {
            transaction.replace(R.id.container, TableTopFragment.newInstance());
        }
        transaction.addToBackStack(null).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Get the title of current fragment
    public void onSectionAttached(int number) {
        switch (number) {
            case R.id.nav_home:
                mTitle = getString(R.string.title_fragment_home);
                updateActionBar();
                break;
            case R.id.nav_books:
                mTitle = getString(R.string.title_fragment_books);
                updateActionBar();
                break;
            case R.id.nav_video_games:
                mTitle = getString(R.string.title_fragment_video_games);
                updateActionBar();
                break;
            case R.id.nav_music:
                mTitle = getString(R.string.title_fragment_music);
                updateActionBar();
                break;
            case R.id.nav_movies:
                mTitle = getString(R.string.title_fragment_movies_tv);
                updateActionBar();
                break;
            case R.id.nav_comics:
                mTitle = getString(R.string.title_fragment_comics);
                updateActionBar();
                break;
            case R.id.nav_tt_games:
                mTitle = getString(R.string.title_fragment_tt_games);
                updateActionBar();
                break;
        }
    }

    public void updateActionBar(){
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mTitle);
        }
    }

    public static String GET(URL url){
        InputStream inputStream = null;
        String result = "";
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int data = inputStreamReader.read();
            while (data != -1){
                char temp = (char) data;
                result += temp;
                data = inputStreamReader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private class HttpASyncTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            return GET(urls[0]);
        }
    }
}
