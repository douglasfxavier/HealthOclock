package com.example.doug.healthoclock.controller;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.doug.healthoclock.R;

public class SearchResultActivity extends AppCompatActivity {
    private TextView textViewSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_layout);
        textViewSearchResult = (TextView) findViewById(
                R.id.textViewSearchResult);
        if (Intent.ACTION_SEARCH.equals(
                getIntent().getAction())) {
            handleSearch(getIntent().getStringExtra(
                    SearchManager.QUERY));
        }
    }

    private void handleSearch(String searchQuery) {
        textViewSearchResult.setText(searchQuery);
    }
}