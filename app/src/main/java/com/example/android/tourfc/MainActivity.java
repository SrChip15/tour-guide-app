package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	// view recycling object
	private RecyclerView mRecyclerView;

	// positions views
	private RecyclerView.LayoutManager mLayoutManager;

	// attaches data to views
	private RecyclerView.Adapter mAdapter;

	// data for the views
	private ArrayList<AttractionDetails> mDataset;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize dataset
		mDataset = new ArrayList<>();
		mDataset.add(new AttractionDetails(R.drawable.moon_over_horsetooth,
				"Horsetooth Mountain Open Space", "Scenic Open Space"));
		mDataset.add(new AttractionDetails(R.drawable.whitewater_rafting,
				"Mountain Whitewater Descents", "White-water rafting"));
		mDataset.add(new AttractionDetails(R.drawable.flower_train_garden,
				"Annual Flower Trial Garden", "Vibrant Horticulture display"));


		// Hook onto recycler view
		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

		// Not a near infinite list
		mRecyclerView.setHasFixedSize(true);

		// use layout manager
		mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mRecyclerView.setLayoutManager(mLayoutManager);

		// Attach adapter
		mAdapter = new RecyclerAdapter(mDataset);
		mRecyclerView.setAdapter(mAdapter);
	}
}
