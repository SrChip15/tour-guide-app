package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class TopRestaurants extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout
		setContentView(R.layout.show_all_view);

		// Add data
		ArrayList<AttractionDetails> mAttractions = new ArrayList<>();
		mAttractions.add(new AttractionDetails(
				R.drawable.the_melting_pot,
				getString(R.string.melting_pot_title),
				getString(R.string.amazing_fondue)));
		mAttractions.add(new AttractionDetails(
				R.drawable.maza_kabob,
				getString(R.string.maza_kabob_title),
				getString(R.string.afghan_specialty)));
		mAttractions.add(new AttractionDetails(
				R.drawable.rio_grande,
				getString(R.string.rio_grande_title),
				getString(R.string.amazing_margarita)));
		mAttractions.add(new AttractionDetails(
				R.drawable.star_of_india,
				getString(R.string.star_of_india_title),
				getString(R.string.indian_buffet)));
		mAttractions.add(new AttractionDetails(
				R.drawable.lucile_creole,
				getString(R.string.lucile_title),
				getString(R.string.breakfast_place)));
		mAttractions.add(new AttractionDetails(
				R.drawable.cafe_athens,
				getString(R.string.cafe_athens_title),
				getString(R.string.greek_mediterranean)));
		mAttractions.add(new AttractionDetails(
				R.drawable.cafe_de_bangkok,
				getString(R.string.cafe_de_bangkok_title),
				getString(R.string.traditional_thai)));

		// Initialize custom adapter to hold data
		CollectionAdapter listViewAdapter = new CollectionAdapter(TopRestaurants.this, mAttractions);

		// Handle on {@link LisView}
		ListView attractionListView = (ListView) findViewById(R.id.show_all_list_view);

		// Attach adapter to view
		attractionListView.setAdapter(listViewAdapter);
	}
}
