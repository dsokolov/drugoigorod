package ru.drugoigorod.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebView;

import java.util.Random;


public class Article extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
        String id = getIntent().getStringExtra("id");
        String url = getIntent().getStringExtra("url");
        setToolbar(id, url);

      //  webView = (WebView) findViewById(R.id.webViewContent);

      //  webView.loadUrl("file:///android_asset/articles/bloodwork.html");


    }

    private void setToolbar(String id, String url) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Random random = new Random();
        boolean idOrUrl = random.nextBoolean();

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (url.isEmpty()) {
                Log.d("Intent", "url: " + url);
            }
            if (id.isEmpty()) {
                Log.d("Intent", "id: " + id);
            }

            if (idOrUrl) {
                collapsingToolbarLayout.setTitle(id);
            }

            if (!idOrUrl) {
                collapsingToolbarLayout.setTitle(url);
            }
            collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorAccent));
            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
            collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}

