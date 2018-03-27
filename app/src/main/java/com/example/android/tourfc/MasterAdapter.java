package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.tourfc.model.Attraction;
import com.example.android.tourfc.model.AttractionCollection;

import java.util.ArrayList;
import java.util.List;

public class MasterAdapter
        extends RecyclerView.Adapter<MasterAdapter.SectionViewHolder> {

    /**
     * Attractions data stored as an AttractionDetail object in an {@link ArrayList}
     */
    private List<AttractionCollection> mData;

    private Context mContext;

    /**
     * Creates custom RecyclerView.Adapter to manage Attraction data object
     *
     * @param data an {@link ArrayList} of Attraction data object
     */
    public MasterAdapter(Context context, List<AttractionCollection> data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout outlined in card for individual row item and
        // Get the layout inflater from the parent view group,
        // which is parsed from R.layout.activity_main, and the inflated view is not attached to root
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attraction_collection, parent, false);
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
        final AttractionCollection currentCollection = mData.get(position);

        // Get section header title from collection object
        final int sectionHeader = mData.get(position).getHeaderTitle();

        // Get current attraction detail from current collection item
        final ArrayList<Attraction> attractions = currentCollection.getAttractions();

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
        holder.sectionRecyclerView.setHasFixedSize(true);

        // Set layout for the attractions collection data using a layout manager
        holder.sectionRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayout.HORIZONTAL, false));

        // Connect attraction collection recycler view widget to corresponding data adapter
        holder.sectionRecyclerView.setAdapter(singleAttractionAdapter);
    }

    /** Returns the number of attractions in the attractions list */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * This nested class is basically a member class that hooks into the child view group,
     * providing the ability to set content for the views contained within the child view group
     */
    static class SectionViewHolder extends RecyclerView.ViewHolder {

        TextView sectionTitle;
        RecyclerView sectionRecyclerView;
        Button showAllClickable;
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

            sectionTitle = itemView.findViewById(R.id.section_title_tv);
            sectionRecyclerView = itemView.findViewById(R.id.section_collection_rv);
            showAllClickable = itemView.findViewById(R.id.show_all_button);

            // Setup listener to receive "show all" navigation requests by the user
            showAllClickable.setOnClickListener(v -> {
                // Declare intent to navigate to the correct activity requested by the user
                Intent passToActivity = AttractionListActivity.newIntent(context, sectionTitle.getText().toString());
                context.startActivity(passToActivity);
            });
        }
    }
}
