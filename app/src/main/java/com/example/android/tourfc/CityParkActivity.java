package com.example.android.tourfc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CityParkActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_detail);

		// Grab a handle on the image view
		ImageView detailImageView = findViewById(R.id.detail_image_view);
		detailImageView.setImageResource(R.drawable.city_park);

		// Grab a handle on the text view
		TextView textView = findViewById(R.id.detail_long_desc_tv);
		textView.setText(getString(R.string.city_park_detailed_desc));
	}

	/**
	 * This method correctly identifies the immediate parent to this activity and handles the
	 * up navigation effectively for attraction activity views that can have more than one parent
	 *
	 * @param item the menu item that is clicked
	 * @return true when the click event is handled false otherwise
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Get extra information from the intent that caused the activity
		String immediateParent = getIntent().getStringExtra("from_where");

		// Check whether the activity was clicked from the landing page or main activity of the app
		if (immediateParent == null) {
			// Activity was clicked directly at the landing page
			// Set navigation path to main parent or MainActivity
			NavUtils.navigateUpFromSameTask(this);

		} else {
			// Activity was fired from the secondary view, i.e., the list view that lists all the
			// attractions belonging to a particular genre
			// Create an intent to go back to that same list view
			Intent test = new Intent(this, TopActivities.class);
			// Show list view when user clicks up
			startActivity(test);
		}
		return true;
	}

	/**
	 * This OnClick event handler method overlays the geographic coordinates over google maps
	 * and displays the place with a balloon marker along with the name of the attraction
	 *
	 * @param view the {@link View} that has been clicked
	 */
	public void showOnMap(View view) {
		// Parse the uri with the longitude and latitude
		// along with the label for the attraction
		Uri location = Uri
				.parse("geo:0,0?q=40.5852196,-105.1097394(City+Park)");

		// Pass the parsed uri string to the method that creates map intent
		showMap(location);
	}

	/**
	 * Create map intent that takes in the location of the attraction as a {@link Uri}
	 *
	 * @param geoLocation an {@link Uri} for the longitude and latitude of the attraction
	 */
	public void showMap(Uri geoLocation) {
		// Initialize the map intent with an action and the geolocation parameter
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);

		// Make the intent explicit by setting Google Maps package
		mapIntent.setPackage("com.google.android.apps.maps");

		// Check for suitable package that can handle the intent
		// Gracefully handles situations where the host system does not have the required package
		// to handle the intent
		if (mapIntent.resolveActivity(getPackageManager()) != null) {
			startActivity(mapIntent);
		}
	}
}
