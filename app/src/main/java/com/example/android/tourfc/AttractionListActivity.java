package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public class AttractionListActivity extends AppCompatActivity {
    private static final String EXTRA_ATTRACTION_TYPE = "om.example.android.tourfc.attraction_type";

    public static Intent newIntent(Context packageContext, String attractionType) {
        Intent intent = new Intent(packageContext, AttractionListActivity.class);
        intent.putExtra(EXTRA_ATTRACTION_TYPE, attractionType);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        String attractionType = getIntent().getStringExtra(EXTRA_ATTRACTION_TYPE);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = AttractionListFragment.newInstance(attractionType);
        fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
