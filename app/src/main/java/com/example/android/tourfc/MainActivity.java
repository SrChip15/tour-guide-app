package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// Create the activity with the most recent data supplied in, if not, merely start activity
		super.onCreate(savedInstanceState);

		// Inflate the activity's UI
		setContentView(R.layout.activity_main);

		// Initialize list to store collection of attractions
		ArrayList<AttractionCollection> activityCollection = new ArrayList<>();

		// Begin compiling of data set for the recycler view
		// Set section header for top activities
		String topActivityHeader = getString(R.string.top_activities);

		// Initialize list for list of attractions
		ArrayList<AttractionDetails> activityAttractionsData = new ArrayList<>();

		// Add activities attractions data
		activityAttractionsData.add(new AttractionDetails(R.drawable.moon_over_horsetooth,
				getString(R.string.horsetooth_mountain_title), getString(R.string.scenic_open_space)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.whitewater_rafting,
				getString(R.string.mountain_whitewater_title), getString(R.string.white_water_rafting)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.flower_trail_garden,
				getString(R.string.flower_trail_garden_title), getString(R.string.horticulture_display)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.horsetooth_reservoir,
				getString(R.string.horsetooth_reservoir_title), getString(R.string.best_outdoors)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.city_park,
				getString(R.string.city_park_title), getString(R.string.ideal_relaxing_spot)));

		// Set section header for top restaurants
		String topRestaurantsHeader = getString(R.string.top_restaurants);

		// Initialize list for restaurants
		ArrayList<AttractionDetails> restaurantAttractionsData = new ArrayList<>();

		// Add restaurants attractions data
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.the_melting_pot,
				getString(R.string.melting_pot_title), getString(R.string.amazing_fondue)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.maza_kabob,
				getString(R.string.maza_kabob_title), getString(R.string.afghan_specialty)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.rio_grande,
				getString(R.string.rio_grande_title), getString(R.string.amazing_margarita)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.star_of_india,
				getString(R.string.star_of_india_title), getString(R.string.indian_buffet)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.lucile_creole,
				getString(R.string.lucile_title), getString(R.string.breakfast_place)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.cafe_athens,
				getString(R.string.cafe_athens_title), getString(R.string.greek_mediterranean)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.cafe_de_bangkok,
				getString(R.string.cafe_de_bangkok_title), getString(R.string.traditional_thai)));

		// Set section header for top breweries
		String topBreweriesHeader = getString(R.string.top_breweries);

		// Initialize list for breweries
		ArrayList<AttractionDetails> breweriesAttractionsData = new ArrayList<>();

		// Add breweries attractions data
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.new_belgium,
				getString(R.string.new_belgium_title), getString(R.string.new_belgium_free_tours)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.odell_brewing,
				getString(R.string.odell_brewing_title), getString(R.string.odell_microbrew)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.anheuser_busch,
				getString(R.string.anheuser_busch_title), getString(R.string.grand_tour)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.coopersmith_brewing,
				getString(R.string.coopersmith_title), getString(R.string.coopersmith_mixed_desc)));

		// Set section header for top bars or nightlife
		String topBarsNightlifeHeader = getString(R.string.top_bars_nightlife);

		// Initialize list for bars or nightlife hangouts
		ArrayList<AttractionDetails> barsNightlifeAttractionsData = new ArrayList<>();

		// Add bars/nightlife attractions data
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.social,
				getString(R.string.social_title), getString(R.string.creative_cocktails)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.mayor_old_town,
				getString(R.string.mayor_old_town_title), getString(R.string.mayor_great_selction)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.colorado_room,
				getString(R.string.colorado_room_title), getString(R.string.colorado_beers_and_spirits)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.ace_gilletts,
				getString(R.string.ace_gilletts_title), getString(R.string.gilletts_crafted_beers)));
		barsNightlifeAttractionsData.add(new AttractionDetails(
				R.drawable.elliot_martini_bar,
				getString(R.string.elliots_martini_title),
				getString(R.string.elliot_martini_variety)));

		// Consolidate data into collection data container
		activityCollection.add(new AttractionCollection(topActivityHeader,
				activityAttractionsData));
		activityCollection.add(new AttractionCollection(topRestaurantsHeader,
				restaurantAttractionsData));
		activityCollection.add(new AttractionCollection(topBreweriesHeader,
				breweriesAttractionsData));
		activityCollection.add(new AttractionCollection(topBarsNightlifeHeader,
				barsNightlifeAttractionsData));
		// End of data set compilation

		// Hook the recycler view
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

		// Set fixed size true and optimize recycler view performance
		// The data container has fixed number of attractions and not infinite list
		recyclerView.setHasFixedSize(true);

		// Connect the {@link RecyclerView} widget to the vertical linear layout
		// (not reverse layout - hence false)
		recyclerView.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL, false));

		// Attach adapter to the {@link RecyclerView} widget which is connected to a layout manager
		AttractionCollectionDataAdapter collectionAdapter = new AttractionCollectionDataAdapter
				(this, activityCollection);
		recyclerView.setAdapter(collectionAdapter);
	}
}
