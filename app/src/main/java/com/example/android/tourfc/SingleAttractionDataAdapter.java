package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourfc.model.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom RecyclerView adapter for mapping data to recycled views
 */
class SingleAttractionDataAdapter
        extends RecyclerView.Adapter<SingleAttractionDataAdapter.SingleAttractionViewHolder> {
    
    private List<Attraction> mAttractions;
    private Context mContext;
    
    /**
     * Create the adapter for a single Attraction class object
     *
     * @param context     a {@link Context} to get a handle on the application's environment
     * @param attractions a {@link ArrayList} of {@link Attraction}
     */
    SingleAttractionDataAdapter(Context context, List<Attraction> attractions) {
        this.mAttractions = attractions;
        this.mContext = context;
    }
    
    /**
     * This method is called when a new {@link RecyclerView.ViewHolder} is required by the
     * recycler view to display an {@link Attraction} item
     *
     * @param parent   the primary {@link ViewGroup} for the application
     * @param viewType a {@link boolean} value indicating whether the inflated view is to be attached
     *                 to the root view
     * @return the {@link SingleAttractionViewHolder} that has a backing inflated layout
     */
    @NonNull
    @Override
    public SingleAttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attraction_card, parent, false);
        return new SingleAttractionViewHolder(view);
    }
    
    /**
     * This method is responsible for mapping data to the item that is being currently displayed to
     * the user
     *
     * @param holder   the {@link SingleAttractionViewHolder} with the inflated custom layout to
     *                 display the {@link Attraction} object item
     * @param position the position of the item in the recycler view that is being viewed by the
     *                 user
     */
    @Override
    public void onBindViewHolder(@NonNull SingleAttractionViewHolder holder, int position) {
        
        final Attraction attraction = mAttractions.get(position);
        
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
        holder.attractionBriefDescription.setText(attraction.getShortDesc());
        
        // Setup and register {@link OnClickListener} to the {@link CardView} that is displaying
        // the {@link Attraction} item
        holder.attractionCardView.setOnClickListener(v -> {
            Intent intent = AttractionActivity.newIntent(mContext, attraction);
            mContext.startActivity(intent);
        });
    }
    
    /**
     * Provides information to the adapter on how many items are present in the data set
     *
     * @return the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return mAttractions == null ? 0 : mAttractions.size();
    }
    
    /**
     * Nested inner class that provides the adapter with cached expensive findViewById results
     * Basically, a custom {@link RecyclerView.ViewHolder} implementation to handle the complexity
     * of the item that is to be displayed by the {@link RecyclerView}
     */
    static class SingleAttractionViewHolder
            extends RecyclerView.ViewHolder {
        
        ImageView attractionImage;
        TextView attractionTitle;
        TextView attractionBriefDescription;
        CardView attractionCardView;
        
        /**
         * This is the method that handles caching of the findViewById results to avoid repeatedly
         * performing such expensive tasks
         *
         * @param itemView holds the {@link ViewGroup} information of the inflated view
         */
        SingleAttractionViewHolder(View itemView) {
            super(itemView);
            
            attractionCardView = itemView.findViewById(R.id.attraction_card_view);
            attractionImage = itemView.findViewById(R.id.attraction_image_view);
            attractionTitle = itemView.findViewById(R.id.attraction_title_text_view);
            attractionBriefDescription = itemView.findViewById(R.id.attraction_brief_desc_text_view);
        }
    }
}
