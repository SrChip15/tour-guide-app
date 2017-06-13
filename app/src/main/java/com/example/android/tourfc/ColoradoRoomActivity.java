package com.example.android.tourfc;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ColoradoRoomActivity extends AppCompatActivity {

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
		detailImageView.setImageResource(R.drawable.colorado_room);

		// grab a handle on the text view
		TextView textView = (TextView) findViewById(R.id.attraction_detail_text_view);
		textView.setText(getString(R.string.the_colorado_room_detailed_desc_card_text));

		// Grab a handle on the button view
		Button buttonView = (Button) findViewById(R.id.attraction_detail_button_view);
	}
}
