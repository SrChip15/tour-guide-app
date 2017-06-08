package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	// Attractions data stored as an AttractionDetail object in an {@link ArrayList}
	private ArrayList<AttractionCollection> mActivityCollection;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// Create the activity with the most recent data supplied in, if not, merely start activity
		super.onCreate(savedInstanceState);

		// Inflate the activity's UI
		setContentView(R.layout.activity_main);


		mActivityCollection = new ArrayList<>();

		// Set section header
		String activityHeader = getString(R.string.top_activities);

		// Initialize list for list of attractions
		ArrayList<AttractionDetails> activityAttractionsData = new ArrayList<>();

		// Add activity attractions data
		activityAttractionsData.add(new AttractionDetails(R.drawable.moon_over_horsetooth,
				"Horsetooth Mountain Park", "Scenic Open Space"));
		activityAttractionsData.add(new AttractionDetails(R.drawable.whitewater_rafting,
				"Mountain Whitewater Descents", "White-water rafting"));
		activityAttractionsData.add(new AttractionDetails(R.drawable.flower_train_garden,
				"Annual Flower Trial Garden", "Vibrant Horticulture display"));

		// Consolidate data into collection data container
		mActivityCollection.add(new AttractionCollection(activityHeader, activityAttractionsData));

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
				(this, mActivityCollection);
		recyclerView.setAdapter(collectionAdapter);
	}
}
