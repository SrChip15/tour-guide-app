package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

		// Set the image file to be displayed for the attraction
		// Load scaled down version of image file into memory
		holder.attractionImage
				.setImageBitmap(ScaledImages
						.decodeSampledBitmapFromResource(
								mContext.getResources(),
								attraction.getImageResourceId(),
								200,
								100));

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

				switch (attraction.getTitle()) {
					case "Horsetooth Mountain Park":
						attractionDetailViewIntent = new Intent(
								mContext,
								HorsetoothMountainActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Mountain Whitewater Descents":
						attractionDetailViewIntent = new Intent(
								mContext,
								MountainDescentsActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Annual Flower Trial Garden":
						attractionDetailViewIntent = new Intent(
								mContext,
								FlowerTrialGardenActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Horsetooth Reservoir":
						attractionDetailViewIntent = new Intent(
								mContext,
								HorsetoothReservoirActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "City Park":
						attractionDetailViewIntent = new Intent(mContext, CityParkActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "The Melting Pot":
						attractionDetailViewIntent = new Intent(mContext, MeltingPotActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Maza Kabob":
						attractionDetailViewIntent = new Intent(mContext, MazaKabobActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Rio Grande":
						attractionDetailViewIntent = new Intent(mContext, RioGrandeActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Star of India":
						attractionDetailViewIntent = new Intent(
								mContext,
								StarOfIndiaActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Lucile's":
						attractionDetailViewIntent = new Intent(mContext, LucileActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Cafe Athens":
						attractionDetailViewIntent = new Intent(mContext, CafeAthensActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Cafe de Bangkok":
						attractionDetailViewIntent = new Intent(
								mContext,
								CafeDeBangkokActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "New Belgium Brewing Company":
						attractionDetailViewIntent = new Intent(mContext, NewBelgiumActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Odell Brewing Company":
						attractionDetailViewIntent = new Intent(mContext, OdellActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Anheuser Busch Brewery":
						attractionDetailViewIntent = new Intent(
								mContext,
								AnheuserBuschActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Coopersmith Pub and Brewing":
						attractionDetailViewIntent = new Intent(
								mContext,
								CooperSmithActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Social":
						attractionDetailViewIntent = new Intent(mContext, SocialActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Mayor of Old Town":
						attractionDetailViewIntent = new Intent(
								mContext,
								MayorOfOldTownActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "The Colorado Room":
						attractionDetailViewIntent = new Intent(
								mContext,
								ColoradoRoomActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Ace Gilletts":
						attractionDetailViewIntent = new Intent(
								mContext,
								AceGillettsActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;

					case "Elliot's Martini bar":
						attractionDetailViewIntent = new Intent(
								mContext,
								ElliotMartiniActivity.class);
						mContext.startActivity(attractionDetailViewIntent);
						break;
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
