package com.example.android.tourfc;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LucileActivity extends AppCompatActivity {

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
			Intent test = new Intent(this, TopRestaurants.class);
			// Show list view when user clicks up
			startActivity(test);
		}
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout for the activity
		setContentView(R.layout.attraction_detail_view);

		// Grab a handle on the card view for the detailed description of the attraction
		CardView cardView = findViewById(R.id.detailed_description_card_widget);
		// Convert px to dips
		Resources r = getResources();
		int contentPadding = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP,
				8,
				r.getDisplayMetrics());
		// Set padding for detailed description within the card widget
		cardView.setContentPadding(contentPadding, contentPadding, contentPadding, contentPadding);

		// Grab a handle on the image view
		ImageView detailImageView = findViewById(R.id.attraction_detail_image_view);
		detailImageView.setImageResource(R.drawable.lucile_creole);

		// grab a handle on the text view
		TextView textView = findViewById(R.id.attraction_detail_text_view);
		textView.setText(getString(R.string.lucile_creole_detailed_desc_card_text));
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
				.parse("geo:0,0?q=40.5826753,-105.0843392(Lucile's)");

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
