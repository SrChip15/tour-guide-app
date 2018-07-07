package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tourfc.model.Attraction;

import java.util.ArrayList;
import java.util.List;

class AttractionListAdapter extends ArrayAdapter<Attraction> {
    
    private LayoutInflater mLayoutInflater;
    private List<Attraction> mAttractions;
    private int sectionTitle;
    
    public static final int LIST_ITEM_IMAGE_DECODE = 444;
    
    /**
     * Create new collection adapter
     *
     * @param context     holds the {@link Context} of the {@link android.widget.ListView}
     * @param attractions an {@link ArrayList} of {@link Attraction} objects
     */
    AttractionListAdapter(@NonNull Context context, List<Attraction> attractions, int sectionTitle) {
        super(context, 0, attractions);
        mAttractions = new ArrayList<>();
        mAttractions = attractions;
        mLayoutInflater = LayoutInflater.from(context);
        this.sectionTitle = sectionTitle;
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
        final Attraction currentAttraction = mAttractions.get(position);
        
        // Set the image of the attraction
        final ImageView imageContainer = convertView.findViewById(R.id.list_item_image);
        
        // Convert px to dips
        Resources resources = convertView.getResources();
        
        // Use scaled down version of image for the image set in {@link ListView} row
        imageContainer.setImageBitmap(ScaledImages.decodeSampledBitmapFromResource(
                resources,
                currentAttraction.getImageResourceId(),
                LIST_ITEM_IMAGE_DECODE
        ));
        
        // Set text for the title {@link TextView}
        TextView titleText = convertView.findViewById(R.id.list_item_title_text_view);
        titleText.setText(currentAttraction.getTitle());
        
        // Set text for the brief description {@link TextView}
        TextView descText = convertView.findViewById(R.id.list_item_brief_desc_text_view);
        descText.setText(currentAttraction.getShortDesc());
        
        // Set up the row in the {@link ListView} to respond to click(s)
        // Get a handle on the {@link RelativeLayout} that holds the attraction's data
        RelativeLayout listRow = convertView.findViewById(R.id.list_item_row);
        
        // Setup and register OnClickListener to navigate to the appropriate activity
        listRow.setOnClickListener(v -> {
            Intent intent = AttractionPagerActivity
                    .newIntent(getContext(), sectionTitle, currentAttraction.getTitle());
            getContext().startActivity(intent);
        });
        
        return convertView;
    }
    
    @Override
    public int getCount() {
        return mAttractions == null ? 0 : mAttractions.size();
    }
}
