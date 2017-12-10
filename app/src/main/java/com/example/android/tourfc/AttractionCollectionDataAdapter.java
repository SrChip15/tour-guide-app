package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class AttractionCollectionDataAdapter
		extends RecyclerView.Adapter<AttractionCollectionDataAdapter.SectionViewHolder> {

	/**
	 * Attractions data stored as an AttractionDetail object in an {@link ArrayList}
	 */
	private ArrayList<AttractionCollection> mDataset;

	private Context mContext;

	/**
	 * Creates custom RecyclerView.Adapter to manage AttractionDetails data object
	 *
	 * @param dataset an {@link ArrayList} of AttractionDetails data object
	 */
	AttractionCollectionDataAdapter(Context context, ArrayList<AttractionCollection> dataset) {
		this.mDataset = dataset;
		this.mContext = context;
	}

	@Override
	public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// Inflate the layout outlined in card for individual row item and
		// Get the layout inflater from the parent view group,
		// which is parsed from R.layout.activity_main, and the inflated view is not attached to root
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.attraction_collection_layout, parent, false);
		// Return the inflated view unattached to root
		return new SectionViewHolder(view);
	}

	/**
	 * This method is called by RecyclerView to display the data at the specified position
	 *
	 * @param holder   the {@link SectionViewHolder} which is a member class is passed to set content
	 *                 for the child view group
	 * @param position the index position of the item in the adapter's data set
	 */
	@SuppressWarnings("ConstantConditions")
	@Override
	public void onBindViewHolder(SectionViewHolder holder, final int position) {
		// Get the data item that is being called to display
		final AttractionCollection currentCollection = mDataset.get(position);

		// Get section header title from collection object
		final String sectionHeader = mDataset.get(position).getHeaderTitle();

		// Get current attraction detail from current collection item
		final ArrayList<AttractionDetails> attractions = currentCollection.getCollection();

		SingleAttractionDataAdapter singleAttractionAdapter = new SingleAttractionDataAdapter(
				mContext, attractions);

		// Set text for section title
		holder.sectionTitle.setText(sectionHeader);

		// Set matching text color for the section title and the secondary text "show all"
		switch (position) {
			case 0:
				int topActivitiesColor =
						ContextCompat.getColor(mContext, R.color.top_activities_text_color);
				holder.sectionTitle.setTextColor(topActivitiesColor);
				holder.showAllClickable.setTextColor(topActivitiesColor);
				break;

			case 1:
				int topRestaurantsColor =
						ContextCompat.getColor(mContext, R.color.top_restaurants_text_color);
				holder.sectionTitle.setTextColor(topRestaurantsColor);
				holder.showAllClickable.setTextColor(topRestaurantsColor);
				break;

			case 2:
				int topBreweriesColor =
						ContextCompat.getColor(mContext, R.color.top_breweries_text_color);
				holder.sectionTitle.setTextColor(topBreweriesColor);
				holder.showAllClickable.setTextColor(topBreweriesColor);
				break;

			case 3:
				int topBarsColor =
						ContextCompat.getColor(mContext, R.color.top_bars_nightlife_text_color);
				holder.sectionTitle.setTextColor(topBarsColor);
				holder.showAllClickable.setTextColor(topBarsColor);
				break;
			default:
				break;
		}

		// Set fixed size true and optimize recycler view performance
		// The data container has fixed number of attractions and is not streaming from a web server
		holder.sectionCollectionRecyclerView.setHasFixedSize(true);

		// Set layout for the attractions collection data using a layout manager
		holder.sectionCollectionRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
				LinearLayout.HORIZONTAL, false));

		// Connect attraction collection recycler view widget to corresponding data adapter
		holder.sectionCollectionRecyclerView.setAdapter(singleAttractionAdapter);
	}

	/**
	 * Returns the number of attractions in the attractions list
	 */
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

	/**
	 * This nested class is basically a member class that hooks into the child view group,
	 * providing the ability to set content for the views contained within the child view group
	 */
	static class SectionViewHolder extends RecyclerView.ViewHolder {

		TextView sectionTitle;
		RecyclerView sectionCollectionRecyclerView;
		TextView showAllClickable;
		ImageView moreArrow;
		LinearLayout linearLayout;
		final Context context;

		/**
		 * Create a {@link SectionViewHolder} that connects itself to all the relevant views
		 * contained within the child view group
		 *
		 * @param itemView a {@link ViewGroup} that is inflated when onCreateViewHolder is called
		 */
		SectionViewHolder(View itemView) {
			super(itemView);
			context = itemView.getContext();

			// Connect to the linear layout
			linearLayout = (LinearLayout) itemView.findViewById(R.id.section_linear_layout);

			// Connect to the image view of the child view group
			sectionTitle = (TextView) itemView.findViewById(R.id.section_title_text_view);

			// Connect to the text view of the child view group
			sectionCollectionRecyclerView = (RecyclerView) itemView
					.findViewById(R.id.section_collection_recycler_view);

			// Connect to the text view of the child view group
			showAllClickable = (TextView) itemView.findViewById(R.id.show_all_text_view);

			// Connect to the image view of the child view group
			moreArrow = itemView.findViewById(R.id.more_arrow_image_view);

			// Setup and register an {@link OnClickListener} to receive "show all" navigation
			// requests by the user
			showAllClickable.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// Declare intent to navigate to the correct activity requested by the user
					final Intent passToActivity;

					// Grab the context from the view
					Context context = v.getContext();

					// Based on the "show all" clickable text of a collection type clicked by the
					// user, navigate to the corresponding attraction collection
					// E.g. the "show all" clickable text next to the "Top Activities" will take
					// the user to a list of all the top activities
					switch (getAdapterPosition()) {
						case 0:
							// First in the list is the TopActivities
							passToActivity = new Intent(context, TopActivities.class);
							// Initiate moving to the activity
							context.startActivity(passToActivity);
							break;

						case 1:
							// Second is the TopRestaurants to visit
							passToActivity = new Intent(context, TopRestaurants.class);
							// Initiate moving to the activity
							context.startActivity(passToActivity);
							break;

						case 2:
							// Third in the list is the TopBreweries of Fort Collins
							passToActivity = new Intent(context, TopBreweries.class);
							// Initiate moving to the activity
							context.startActivity(passToActivity);
							break;

						case 3:
							// Lastly, the best nightlife places to visit
							passToActivity = new Intent(context, TopBarsNightlife.class);
							// Initiate moving to the activity
							context.startActivity(passToActivity);
							break;
					}
				}
			});
		}
	}
}
