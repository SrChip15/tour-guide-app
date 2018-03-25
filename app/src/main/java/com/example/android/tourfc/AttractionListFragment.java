package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourfc.model.Attraction;
import com.example.android.tourfc.model.AttractionCollection;
import com.example.android.tourfc.model.AttractionRepository;

import java.util.ArrayList;
import java.util.List;


public class AttractionListFragment extends Fragment {

    private static final String ARG_ATTRACTION_TYPE = "attractionType";
    private String attractionType;
    private ListView attractionListView;
    private AttractionListAdapter listViewAdapter;

    public static AttractionListFragment newInstance(String attractionType) {
        Bundle args = new Bundle();
        args.putString(ARG_ATTRACTION_TYPE, attractionType);

        AttractionListFragment fragment = new AttractionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attractionType = getArguments().getString(ARG_ATTRACTION_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.show_all_view, container, false);
        List<Attraction> attractions = new ArrayList<>();
        SparseArray<AttractionCollection> collection = AttractionRepository.getInstance(getActivity())
                .getCollections();
        if (attractionType.equals(getString(R.string.top_activities))) {
            attractions = collection.get(R.string.top_activities).getAttractions();
            getActivity().setTitle(R.string.top_activities);
        } else if (attractionType.equals(getString(R.string.top_bars_nightlife))) {
            attractions = collection.get(R.string.top_bars_nightlife).getAttractions();
            getActivity().setTitle(R.string.top_bars_nightlife);
        } else if (attractionType.equals(getString(R.string.top_breweries))) {
            attractions = collection.get(R.string.top_breweries).getAttractions();
            getActivity().setTitle(R.string.top_breweries);
        } else if (attractionType.equals(getString(R.string.top_restaurants))) {
            attractions = collection.get(R.string.top_restaurants).getAttractions();
            getActivity().setTitle(R.string.top_restaurants);
        }

        attractionListView = v.findViewById(R.id.show_all_list_view);
        listViewAdapter = new AttractionListAdapter(getActivity(), attractions);
        attractionListView.setAdapter(listViewAdapter);

        return v;
    }
}
