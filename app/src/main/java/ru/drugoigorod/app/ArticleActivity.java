package ru.drugoigorod.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ru.drugoigorod.app.fragment.NDrawerFragment;
import ru.drugoigorod.app.web.Request;

class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    private NDrawerFragment myFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setToolbar();
        setNavigationDrawer();

        Article article = new Article("Article");
        List<Article> data = article.initializeData();

        RecyclerView articlesRecycler = (RecyclerView) findViewById(R.id.activityMainRecycler);

        articlesRecycler.setHasFixedSize(true);

        mAdapter = new ArticlesRecycler(data);
        articlesRecycler.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        articlesRecycler.setLayoutManager(mLayoutManager);



       /* if (savedInstanceState == null) {

            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager
                    .beginTransaction();
            myFragment = new NDrawerFragment();

            fragmentTransaction.add(R.id.drawer_container, myFragment);
            fragmentTransaction.commit();

            myFragment
        }
*/
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }


    private void setNavigationDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.mainDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.closeDrawer(GravityCompat.START);

        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.setHomeAsUpIndicator(R.drawable.arrow);
        toggle.syncState();
    }

/*    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("id", "test id");
        intent.putExtra("url", "some url");
        startActivity(intent);
    }*/

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        return true;
    }
}























