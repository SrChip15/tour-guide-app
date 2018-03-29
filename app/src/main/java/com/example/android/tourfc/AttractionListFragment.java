package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourfc.model.Attraction;
import com.example.android.tourfc.model.AttractionRepository;

import java.util.List;


public class AttractionListFragment extends Fragment {

    private static final String ARG_ATTRACTION_TYPE = "attractionType";
    private int attractionType;
    private ListView attractionListView;
    private AttractionListAdapter listViewAdapter;

    public static AttractionListFragment newInstance(int attractionType) {
        Bundle args = new Bundle();
        args.putInt(ARG_ATTRACTION_TYPE, attractionType);

        AttractionListFragment fragment = new AttractionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        attractionType = getArguments().getInt(ARG_ATTRACTION_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.show_all_view, container, false);

        AttractionRepository repository = AttractionRepository.getInstance(getActivity());
        List<Attraction> attractions = repository.getCollection(attractionType).getAttractions();

        attractionListView = v.findViewById(R.id.show_all_list_view);
        listViewAdapter = new AttractionListAdapter(getActivity(), attractions);
        attractionListView.setAdapter(listViewAdapter);

        return v;
    }
}
