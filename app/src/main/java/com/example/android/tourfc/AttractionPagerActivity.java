package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tourfc.model.Attraction;
import com.example.android.tourfc.model.AttractionCollection;
import com.example.android.tourfc.model.AttractionRepository;

import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class AttractionPagerActivity extends AppCompatActivity {
    /* Class variables */
    private ViewPager viewPager;
    private List<Attraction> attractions;
    private int sectionTitle;

    /* Class Constants */
    private static final String EXTRA_SECTION_TITLE = "com.example.android.tourfc.section_title";
    private static final String EXTRA_ATTRACTION_TITLE = "com.example.android.tourfc.attraction_title";

    public static Intent newIntent(Context packageContext, int sectionTitle, int attractionTitle) {
        Intent intent = new Intent(packageContext, AttractionPagerActivity.class);
        intent.putExtra(EXTRA_SECTION_TITLE, sectionTitle);
        intent.putExtra(EXTRA_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_pager);

        sectionTitle = getIntent().getIntExtra(EXTRA_SECTION_TITLE, 0);
        if (sectionTitle == 0) {
            throw new IllegalArgumentException("AttractionListAdapter has not reported on section title");
        } else {
            List<AttractionCollection> collections = AttractionRepository.getInstance(this).getCollections();
            for (AttractionCollection collection : collections) {
                if (collection.getHeaderTitle() == sectionTitle) {
                    attractions = collection.getAttractions();
                    break;
                }
            }
        }

        int attractionTitle = getIntent().getIntExtra(EXTRA_ATTRACTION_TITLE, 0);
        if (attractionTitle == 0) {
            throw new IllegalArgumentException("AttractionListAdapter has not reported on attraction title");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager = findViewById(R.id.attraction_view_pager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public int getCount() {
                return attractions.size();
            }

            @Override
            public Fragment getItem(int position) {
                Attraction attraction = attractions.get(position);
                return AttractionFragment.newInstance(attraction);
            }
        });

        for (int i = 0; i < attractions.size(); i++) {
            if (attractionTitle == attractions.get(i).getTitle()) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
