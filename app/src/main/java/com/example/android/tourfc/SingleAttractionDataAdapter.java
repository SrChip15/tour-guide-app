package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom RecyclerView adapter for mapping data to recycled views
 */
class SingleAttractionDataAdapter
		extends RecyclerView.Adapter<SingleAttractionDataAdapter.SingleAttractionViewHolder> {

	/**
	 * Holds list of AttractionDetails class object
	 */
	private ArrayList<AttractionDetails> mAttractions;

	/**
	 * Hold context information to manipulate the application environment
	 */
	private Context mContext;

	/**
	 * Create the adapter for a single AttractionDetails class object
	 *
	 * @param context     a {@link Context} to get a handle on the application's environment
	 * @param attractions a {@link ArrayList} of {@link AttractionDetails}
	 */
	SingleAttractionDataAdapter(Context context, ArrayList<AttractionDetails> attractions) {
		this.mAttractions = attractions;
		this.mContext = context;
	}

	/**
	 * This method is called when a new {@link RecyclerView.ViewHolder} is required by the
	 * recycler view to display an {@link AttractionDetails} item
	 *
	 * @param parent   the primary {@link ViewGroup} for the application
	 * @param viewType a {@link boolean} value indicating whether the inflated view is to be attached
	 *                 to the root view
	 * @return the {@link SingleAttractionViewHolder} that has a backing inflated layout
	 */
	@Override
	public SingleAttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attraction_card, parent, false);
		return new SingleAttractionViewHolder(view);
	}

	/**
	 * This method is responsible for mapping data to the item that is being currently displayed to
	 * the user
	 *
	 * @param holder   the {@link SingleAttractionViewHolder} with the inflated custom layout to
	 *                 display the {@link AttractionDetails} object item
	 * @param position the position of the item in the recycler view that is being viewed by the
	 *                 user
	 */
	@Override
	public void onBindViewHolder(SingleAttractionViewHolder holder, int position) {

		final AttractionDetails attraction = mAttractions.get(position);

		// Convert px to dips
		// Grab the context's resources
		Resources r = mContext.getResources();

		// Convert image's width dimension in pixels to dips to fit the card layout
		int imageWidth = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP,
				300,
				r.getDisplayMetrics());

		// Convert image's height dimension in pixels to dips to fit the card layout
		int imageHeight = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP,
				150,
				r.getDisplayMetrics());

		// Set the image file to be displayed for the attraction
		// Load scaled down version of image file into memory
		holder.attractionImage
				.setImageBitmap(ScaledImages
						.decodeSampledBitmapFromResource(
								mContext.getResources(),
								attraction.getImageResourceId(),
								imageWidth, // previous value 200
								imageHeight)); // previous value 100

		// Set the title of the attraction
		holder.attractionTitle.setText(attraction.getTitle());

		// Set the description of the attraction
		holder.attractionBriefDescription.setText(attraction.getDescription());

		// Setup and register {@link OnClickListener} to the {@link CardView} that is displaying
		// the {@link AttractionDetails} item
		holder.attractionCardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Declare a final Intent variable to hook up the intent to the appropriate
				// activity as scrolled and clicked by the user
				final Intent attractionDetailViewIntent;

				// Grab the context from the view
				Context context = v.getContext();


				final String attractionName = attraction.getTitle();

				// Check which attraction is clicked based on the title of the attraction
				if (attractionName.equals(context.getString(R.string.horsetooth_mountain_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							HorsetoothMountainActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.mountain_whitewater_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							MountainDescentsActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.flower_trial_garden_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							FlowerTrialGardenActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.horsetooth_reservoir_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							HorsetoothReservoirActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.city_park_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							CityParkActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.melting_pot_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, MeltingPotActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.maza_kabob_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, MazaKabobActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.rio_grande_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, RioGrandeActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.star_of_india_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							StarOfIndiaActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.lucile_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, LucileActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.cafe_athens_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, CafeAthensActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.cafe_de_bangkok_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							CafeDeBangkokActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.new_belgium_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, NewBelgiumActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.odell_brewing_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, OdellActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.anheuser_busch_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							AnheuserBuschActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.coopersmith_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							CooperSmithActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.social_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(mContext, SocialActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.mayor_old_town_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							MayorOfOldTownActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.colorado_room_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							ColoradoRoomActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else if (attractionName
						.equals(
								context
										.getString(R.string.ace_gilletts_title))) {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							AceGillettsActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);

				} else {
					// Create Intent to navigate to the appropriate activity
					attractionDetailViewIntent = new Intent(
							mContext,
							ElliotMartiniActivity.class);
					// Start the activity passed within the intent
					mContext.startActivity(attractionDetailViewIntent);
				}
			}
		});
	}

	/**
	 * Provides information to the adapter on how many items are present in the data set
	 *
	 * @return the total number of items in the data set held by the adapter.
	 */
	@Override
	public int getItemCount() {
		return mAttractions.size();
	}

	/**
	 * Nested inner class that provides the adapter with cached expensive findViewById results
	 * Basically, a custom {@link RecyclerView.ViewHolder} implementation to handle the complexity
	 * of the item that is to be displayed by the {@link RecyclerView}
	 */
	static class SingleAttractionViewHolder
			extends RecyclerView.ViewHolder {

		/** Holds {@link ImageView} from the layout that is inflated via the onCreateViewHolder */
		ImageView attractionImage;

		/** Hold {@link TextView} from the layout that is inflated via the onCreateViewHolder */
		TextView attractionTitle;

		/** Hold {@link TextView} from the layout that is inflated via the onCreateViewHolder */
		TextView attractionBriefDescription;

		/** Holds {@link CardView} from the layout that is inflated via the onCreateViewHolder */
		CardView attractionCardView;

		/**
		 * This is the method that handles caching of the findViewById results to avoid repeatedly
		 * performing such expensive tasks
		 *
		 * @param itemView holds the {@link ViewGroup} information of the inflated view
		 */
		SingleAttractionViewHolder(View itemView) {
			super(itemView);

			// Grab a handle on the {@link CardView} of the {@link ViewGroup}
			attractionCardView = (CardView) itemView.findViewById(R.id.attraction_card_view);

			// Grab a handle on the {@link ImageView} of the {@link ViewGroup}
			attractionImage = (ImageView) itemView.findViewById(R.id.attraction_image_view);

			// Grab a handle on the title {@link TextView} of the {@link ViewGroup}
			attractionTitle = (TextView) itemView.findViewById(R.id.attraction_title_text_view);

			// Grab a handle on the description {@link TextView} of the {@link ViewGroup}
			attractionBriefDescription = (TextView) itemView
					.findViewById(R.id.attraction_brief_desc_text_view);
		}
	}
}
