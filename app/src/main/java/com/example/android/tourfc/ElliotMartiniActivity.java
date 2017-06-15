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

public class ElliotMartiniActivity extends AppCompatActivity {

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		String immediateParent = getIntent().getStringExtra("from_where");

		if (immediateParent == null) {

			NavUtils.navigateUpFromSameTask(this);

		} else {
			Intent test = new Intent(this, TopBarsNightlife.class);
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
		CardView cardView = (CardView) findViewById(R.id.detailed_description_card_widget);
		// Convert px to dips
		Resources r = getResources();
		int contentPadding = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP,
				8,
				r.getDisplayMetrics());
		// Set padding for detailed description within the card widget
		cardView.setContentPadding(contentPadding, contentPadding, contentPadding, contentPadding);

		// Grab a handle on the image view
		ImageView detailImageView = (ImageView) findViewById(R.id.attraction_detail_image_view);
		detailImageView.setImageResource(R.drawable.elliot_martini_bar);

		// grab a handle on the text view
		TextView textView = (TextView) findViewById(R.id.attraction_detail_text_view);
		textView.setText(getString(R.string.elliot_martini_bar_detailed_desc_card_text));
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
				.parse("geo:0,0?q=40.5884398,-105.0766902(Elliot\'s+Martini+Bar)");

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
