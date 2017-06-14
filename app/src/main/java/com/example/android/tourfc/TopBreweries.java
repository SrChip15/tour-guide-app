package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class TopBreweries extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout
		setContentView(R.layout.show_all_view);

		// Initialize the attractions {@link ArrayList}
		ArrayList<AttractionDetails> mAttractions = new ArrayList<>();

		// Add attractions to the initialized {@link ArrayList}
		mAttractions.add(new AttractionDetails(
				R.drawable.new_belgium,
				getString(R.string.new_belgium_title),
				getString(R.string.new_belgium_free_tours)));
		mAttractions.add(new AttractionDetails(
				R.drawable.odell_brewing,
				getString(R.string.odell_brewing_title),
				getString(R.string.odell_microbrew)));
		mAttractions.add(new AttractionDetails(
				R.drawable.anheuser_busch,
				getString(R.string.anheuser_busch_title),
				getString(R.string.grand_tour)));
		mAttractions.add(new AttractionDetails(
				R.drawable.coopersmith_brewing,
				getString(R.string.coopersmith_title),
				getString(R.string.coopersmith_mixed_desc)));

		// Initialize custom adapter to hold data
		CollectionAdapter listViewAdapter = new CollectionAdapter(TopBreweries.this, mAttractions);

		// Handle on {@link LisView}
		ListView attractionListView = (ListView) findViewById(R.id.show_all_list_view);

		// Attach adapter to view
		attractionListView.setAdapter(listViewAdapter);
	}
}
