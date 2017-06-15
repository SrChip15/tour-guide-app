package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

class CollectionAdapter extends ArrayAdapter<AttractionDetails> {

	/** Layout inflater to inflate custom layout */
	private LayoutInflater mLayoutInflater;

	/** ArrayList for {@link AttractionDetails} object */
	private ArrayList<AttractionDetails> mAttractions;

	/**
	 * Create new collection adapter
	 *
	 * @param context holds the {@link Context} of the {@link android.widget.ListView}
	 * @param attractions an {@link ArrayList} of {@link AttractionDetails} objects
	 */
	CollectionAdapter(@NonNull Context context, ArrayList<AttractionDetails> attractions) {
		super(context, 0, attractions);
		this.mAttractions = attractions;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@NonNull
	@Override
	public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		if (convertView == null) {
			// There are no views in the recycle pool
			// Inflate layout for first time view render
			convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
		}

		// Get item currently viewed by user
		final AttractionDetails currentAttraction = mAttractions.get(position);

		// Set the image of the attraction for the {@link ImageView}
		final ImageView attractionImage = (ImageView) convertView.findViewById(R.id.list_item_image);

		// Convert px to dips
		Resources resources = convertView.getResources();
		int dimensionsInDips = (int) TypedValue
				.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP,
						88,
						resources.getDisplayMetrics());

		// Use scaled down version of image for the image set in {@link ListView} row
		attractionImage.setImageBitmap(ScaledImages
				.decodeSampledBitmapFromResource(
						resources,
						currentAttraction.getImageResourceId(), dimensionsInDips, dimensionsInDips));

		// Set text for the title {@link TextView}
		TextView titleText = (TextView) convertView.findViewById(R.id.list_item_title_text_view);
		titleText.setText(currentAttraction.getTitle());

		// Set text for the brief description {@link TextView}
		TextView descText = (TextView) convertView.findViewById(R.id.list_item_brief_desc_text_view);
		descText.setText(currentAttraction.getDescription());

		// Set up the row in the {@link ListView} to respond to click(s)
		// Get a handle on the {@link RelativeLayout} that holds the attraction's data
		RelativeLayout listRow = (RelativeLayout) convertView.findViewById(R.id.list_item_row);

		// Setup and register an {@link OnClickListener} to navigate to the appropriate activity
		listRow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Declare a final Intent variable to hook up the intent to the appropriate
				// activity as scrolled and clicked by the user
				final Intent detailedActivityView;

				// Store the title of the attraction
				final String attractionName;

				// Grab the context from the view
				Context context = v.getContext();

				// Get the name of the attraction that is being viewed by the user presently
				attractionName = currentAttraction.getTitle();

				// Create intent to the appropriate activity based on the name of the attraction
				// item that is being requested by the user
				if (attractionName.equals(context.getString(R.string.horsetooth_mountain_title))) {
					detailedActivityView = new Intent(context, HorsetoothMountainActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.mountain_whitewater_title))) {
					detailedActivityView = new Intent(context, MountainDescentsActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.flower_trial_garden_title))) {
					detailedActivityView = new Intent(context, FlowerTrialGardenActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.horsetooth_reservoir_title))) {
					detailedActivityView = new Intent(context, HorsetoothReservoirActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.city_park_title))) {
					detailedActivityView = new Intent(context, CityParkActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.melting_pot_title))) {
					detailedActivityView = new Intent(context, MeltingPotActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.maza_kabob_title))) {
					detailedActivityView = new Intent(context, MazaKabobActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.rio_grande_title))) {
					detailedActivityView = new Intent(context, RioGrandeActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.star_of_india_title))) {
					detailedActivityView = new Intent(context, StarOfIndiaActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.lucile_title))) {
					detailedActivityView = new Intent(context, LucileActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.cafe_athens_title))) {
					detailedActivityView = new Intent(context, CafeAthensActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.cafe_de_bangkok_title))) {
					detailedActivityView = new Intent(context, CafeDeBangkokActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.new_belgium_title))) {
					detailedActivityView = new Intent(context, NewBelgiumActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.odell_brewing_title))) {
					detailedActivityView = new Intent(context, OdellActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.anheuser_busch_title))) {
					detailedActivityView = new Intent(context, AnheuserBuschActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.coopersmith_title))) {
					detailedActivityView = new Intent(context, CooperSmithActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.social_title))) {
					detailedActivityView = new Intent(context, SocialActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.mayor_old_town_title))) {
					detailedActivityView = new Intent(context, MayorOfOldTownActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.colorado_room_title))) {
					detailedActivityView = new Intent(context, ColoradoRoomActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else if (attractionName.equals(context.getString(R.string.ace_gilletts_title))) {
					detailedActivityView = new Intent(context, AceGillettsActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				} else {
					detailedActivityView = new Intent(context, ElliotMartiniActivity.class);
					// Pass in the class name to identify the immediate parent of the activity
					detailedActivityView.putExtra("from_where","CollectionAdapter");
					context.startActivity(detailedActivityView);
				}
			}
		});

		// Return the data bound inflated view
		return convertView;
	}

	@Override
	public int getCount() {
		// Returns the number of objects in the {@link ArrayAdapter}
		return mAttractions.size();
	}
}
