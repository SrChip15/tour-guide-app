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

		/** Data feed for different categories */

		// Set section header for top activities
		String topActivityHeader = getString(R.string.top_activities);

		// Initialize list for list of attractions
		ArrayList<AttractionDetails> activityAttractionsData = new ArrayList<>();

		// Add activities attractions data
		activityAttractionsData.add(new AttractionDetails(R.drawable.moon_over_horsetooth,
				"Horsetooth Mountain Park", getString(R.string.scenic_open_space)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.whitewater_rafting,
				"Mountain Whitewater Descents", getString(R.string.white_water_rafting)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.flower_train_garden,
				"Annual Flower Trial Garden", getString(R.string.horticulture_display)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.horsetooth_reservoir,
				"Horsetooth Reservoir", getString(R.string.best_outdoors)));
		activityAttractionsData.add(new AttractionDetails(R.drawable.city_park,
				"City Park", getString(R.string.ideal_relaxing_spot)));

		// Set section header for top restaurants
		String topRestaurantsHeader = getString(R.string.top_restaurants);

		// Initialize list for restaurants
		ArrayList<AttractionDetails> restaurantAttractionsData = new ArrayList<>();

		// Add restaurants attractions data
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.the_melting_pot,
				"The Melting Pot", getString(R.string.amazing_fondue)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.maza_kabob,
				"Maza Kabob", getString(R.string.afghan_specialty)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.rio_grande,
				"Rio Grande", getString(R.string.amazing_margarita)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.star_of_india,
				"Star of India", getString(R.string.indian_buffet)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.lucile_creole,
				"Lucile's", getString(R.string.breakfast_place)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.cafe_athens,
				"Cafe Athens", getString(R.string.greek_mediterranean)));
		restaurantAttractionsData.add(new AttractionDetails(R.drawable.cafe_de_bangkok,
				"Cafe de Bangkok", getString(R.string.traditional_thai)));

		// Set section header for top breweries
		String topBreweriesHeader = getString(R.string.top_breweries);

		// Initialize list for breweries
		ArrayList<AttractionDetails> breweriesAttractionsData = new ArrayList<>();

		// Add breweries attractions data
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.new_belgium,
				"New Belgium Brewing Company", getString(R.string.new_belgium_free_tours)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.odell_brewing,
				"Odell Brewing Company", getString(R.string.odell_microbrew)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.anheuser_busch,
				"Anheuser Busch Brewery", getString(R.string.grand_tour)));
		breweriesAttractionsData.add(new AttractionDetails(R.drawable.coopersmith_brewing,
				"Coopersmith Pub and Brewing", getString(R.string.coopersmith_mixed_desc)));

		// Set section header for top bars or nightlife
		String topBarsNightlifeHeader = getString(R.string.top_bars_nightlife);

		// Initialize list for bars or nightlife hangouts
		ArrayList<AttractionDetails> barsNightlifeAttractionsData = new ArrayList<>();

		// Add bars/nightlife attractions data
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.social,
				"Social", getString(R.string.creative_cocktails)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.test_mayor_old_town,
				"Mayor of Old Town", getString(R.string.mayor_great_selction)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.colorado_room,
				"The Colorado Room", getString(R.string.colorado_beers_and_spirits)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.ace_gilletts,
				"Ace Gilletts", getString(R.string.gilletts_crafted_beers)));
		barsNightlifeAttractionsData.add(new AttractionDetails(R.drawable.elliot_martini_bar,
				"Elliot's Martini bar", getString(R.string.elliot_martini_variety)));

		// Consolidate data into collection data container
		activityCollection.add(new AttractionCollection(topActivityHeader,
				activityAttractionsData));
		activityCollection.add(new AttractionCollection(topRestaurantsHeader,
				restaurantAttractionsData));
		activityCollection.add(new AttractionCollection(topBreweriesHeader,
				breweriesAttractionsData));
		activityCollection.add(new AttractionCollection(topBarsNightlifeHeader,
				barsNightlifeAttractionsData));

		// Hook the recycler view
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

		// Set fixed size true and optimize recycler view performance
		// The data container has fixed number of attractions and is not streaming from a web server
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
