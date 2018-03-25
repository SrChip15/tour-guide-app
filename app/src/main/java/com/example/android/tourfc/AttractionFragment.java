package com.example.android.tourfc;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class AttractionFragment extends Fragment {

    private static final String ARG_NAME = "nameResId";
    private static final String ARG_IMAGE_ID = "imageResId";
    private static final String ARG_DESC_ID = "descResId";

    private int titleResId;
    private int imageResId;
    private int descriptionTextResId;

    public static AttractionFragment newInstance(int nameResId, int drawableResId, int descResId) {
        Bundle args = new Bundle();
        args.putInt(ARG_NAME, nameResId);
        args.putInt(ARG_IMAGE_ID, drawableResId);
        args.putInt(ARG_DESC_ID, descResId);

        AttractionFragment fragment = new AttractionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleResId = getArguments().getInt(ARG_NAME);
        imageResId = getArguments().getInt(ARG_IMAGE_ID);
        descriptionTextResId = getArguments().getInt(ARG_DESC_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        getActivity().setTitle(titleResId);

        // Grab a handle on the card view for the detailed description of the attraction
        CardView cardView = view.findViewById(R.id.detailed_description_card_widget);
        // Convert px to dips
        Resources r = getResources();
        int contentPadding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                8,
                r.getDisplayMetrics());
        // Set padding for detailed description within the card widget
        cardView.setContentPadding(contentPadding, contentPadding, contentPadding, contentPadding);

        // Grab a handle on the image view
        ImageView detailImageView = view.findViewById(R.id.detail_image_view);
        detailImageView.setImageResource(imageResId);

        // grab a handle on the text view
        TextView textView = view.findViewById(R.id.detail_text_view);
        textView.setText(descriptionTextResId);

        return view;
    }
}
