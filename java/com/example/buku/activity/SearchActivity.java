package com.example.buku.activity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buku.R;
import com.example.buku.adapter.SearchListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchListAdapter.ItemClickListener{

    RecyclerView recyclerView;
    SearchView searchView;
    List<ClipData.Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // set up the RecyclerView
        recyclerView = findViewById(R.id.search_book);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();

        // set up the SearchView
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String newText) {
        itemList filteredList = new ArrayList<>();
        for (itemList item : ArrayList){
            if(item.getItemName().toLowerCase())
        }
    }

    void loadData() {
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        SearchListAdapter adapter = new SearchListAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
