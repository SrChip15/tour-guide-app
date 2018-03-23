package com.example.android.tourfc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.tourfc.model.AttractionCollection;
import com.example.android.tourfc.model.AttractionRepository;

public class TopActivities extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all_view);

        AttractionCollection collection = AttractionRepository.getInstance(this)
                .getCollections()
                .get(R.string.top_activities);

        // Initialize custom adapter to hold data
        CollectionAdapter listViewAdapter = new CollectionAdapter(this, collection.getAttractions());

        // Handle on {@link LisView}
        ListView attractionListView = findViewById(R.id.show_all_list_view);

        // Attach adapter to view
        attractionListView.setAdapter(listViewAdapter);
    }
}
