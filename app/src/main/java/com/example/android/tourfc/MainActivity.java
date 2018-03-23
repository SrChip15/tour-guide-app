package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import com.example.android.tourfc.model.AttractionCollection;
import com.example.android.tourfc.model.AttractionRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// Create the activity with the most recent data supplied in, if not, merely start activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize list to store collection of attractions
		AttractionRepository repository = AttractionRepository.getInstance(this);
		SparseArray<AttractionCollection> collection = repository.getCollections();
		List<AttractionCollection> data = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			data.add(collection.valueAt(i));
		}

		// Hook the recycler view
		RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

		// Set fixed size true and optimize recycler view performance
		// The data container has fixed number of attractions and not infinite list
		recyclerView.setHasFixedSize(true);

		// Connect the RecyclerView widget to the vertical linear layout
		// (not reverse layout - hence false)
		recyclerView.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL, false));

		// Attach adapter to the {@link RecyclerView} widget which is connected to a layout manager
		MasterAdapter collectionAdapter = new MasterAdapter(this, data);
		recyclerView.setAdapter(collectionAdapter);
	}
}
