package ru.drugoigorod.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ru.drugoigorod.app.web.Request;

public class ArticleActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Button button = (Button) findViewById(R.id.goto_article);
        button.setOnClickListener(this);
        button.setText("goto article");

        setToolbar();

     /*   if (savedInstanceState == null) {

            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager
                    .beginTransaction();
            NDrawerFragment myFragment = new NDrawerFragment();

            fragmentTransaction.add(R.id.drawer_container, myFragment);
            fragmentTransaction.commit();
        }*/

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    String s = new Request("https://ya.ru").request();
                    Log.v("Sokolov", s);
                } catch (Request.RequestException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }


    private void setNavigationDrawer() {







   /*     Fragment drawerFragment =  getSupportFragmentManager().findFragmentById(R.id.drawer_container);
        if (drawerFragment == null) {
            drawerFragment = new NDrawerFragment();
            getSupportFragmentManager().
                    beginTransaction().add(R.id.drawer_container, drawerFragment)
                    .commit();
        }*/


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Article.class);
        intent.putExtra("id", "test id");
        intent.putExtra("url", "some url");
        startActivity(intent);
    }
}























