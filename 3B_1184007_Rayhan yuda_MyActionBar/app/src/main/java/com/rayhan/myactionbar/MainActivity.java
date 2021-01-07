package com.rayhan.myactionbar;

import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView)
                    (menu.findItem(R.id.search)).getActionView();

            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new
                                                      SearchView.OnQueryTextListener() {
                                                          @Override
                                                          public boolean onQueryTextSubmit(String query) {
                                                              Toast.makeText(MainActivity.this, query,
                                                                      Toast.LENGTH_SHORT).show();
                                                              return true;
                                                          }

                                                          @Override
                                                          public boolean onQueryTextChange(String newText) {
                                                              return false;
                                                          }
                                                      });
        }
        return true;
    }
}
