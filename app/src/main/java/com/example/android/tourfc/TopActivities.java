package com.example.android.tourfc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class TopActivities extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout
		setContentView(R.layout.show_all_view);

		// Add data
		ArrayList<AttractionDetails> mAttractions = new ArrayList<>();
		mAttractions.add(new AttractionDetails(
				R.drawable.moon_over_horsetooth,
				getString(R.string.horsetooth_mountain_title),
				getString(R.string.scenic_open_space)));
		mAttractions.add(new AttractionDetails(
				R.drawable.whitewater_rafting,
				getString(R.string.mountain_whitewater_title),
				getString(R.string.white_water_rafting)));
		mAttractions.add(new AttractionDetails(
				R.drawable.flower_trail_garden,
				getString(R.string.flower_trail_garden_title),
				getString(R.string.horticulture_display)));
		mAttractions.add(new AttractionDetails(
				R.drawable.horsetooth_reservoir,
				getString(R.string.horsetooth_reservoir_title),
				getString(R.string.best_outdoors)));
		mAttractions.add(new AttractionDetails(
				R.drawable.city_park,
				getString(R.string.city_park_title),
				getString(R.string.ideal_relaxing_spot)));

		// Initialize custom adapter to hold data
		CollectionAdapter listViewAdapter = new CollectionAdapter(TopActivities.this, mAttractions);

		// Handle on {@link LisView}
		ListView attractionListView = (ListView) findViewById(R.id.show_all_list_view);

		// Attach adapter to view
		attractionListView.setAdapter(listViewAdapter);
	}
}
