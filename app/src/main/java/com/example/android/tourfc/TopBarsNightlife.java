package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class TopBarsNightlife extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout
		setContentView(R.layout.show_all_view);

		// Initialize the attractions {@link ArrayList}
		ArrayList<AttractionDetails> mAttractions = new ArrayList<>();

		// Add attractions to the initialized {@link ArrayList}
		mAttractions.add(new AttractionDetails(
				R.drawable.social,
				getString(R.string.social_title),
				getString(R.string.creative_cocktails)));
		mAttractions.add(new AttractionDetails(
				R.drawable.mayor_old_town,
				getString(R.string.mayor_old_town_title),
				getString(R.string.mayor_great_selction)));
		mAttractions.add(new AttractionDetails(
				R.drawable.colorado_room,
				getString(R.string.colorado_room_title),
				getString(R.string.colorado_beers_and_spirits)));
		mAttractions.add(new AttractionDetails(
				R.drawable.ace_gilletts,
				getString(R.string.ace_gilletts_title),
				getString(R.string.gilletts_crafted_beers)));
		mAttractions.add(new AttractionDetails(
				R.drawable.elliot_martini_bar,
				getString(R.string.elliots_martini_title),
				getString(R.string.elliot_martini_variety)));

		// Initialize custom adapter to hold data
		CollectionAdapter listViewAdapter = new CollectionAdapter(TopBarsNightlife.this, mAttractions);

		// Handle on {@link LisView}
		ListView attractionListView = findViewById(R.id.show_all_list_view);

		// Attach adapter to view
		attractionListView.setAdapter(listViewAdapter);
	}
}
