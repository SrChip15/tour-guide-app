package com.example.android.tourfc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourfc.model.Attraction;
import com.example.android.tourfc.model.AttractionRepository;

import java.util.List;


@SuppressWarnings("FieldCanBeLocal")
public class AttractionListFragment extends Fragment {
    /* Class Constants */
    private static final String ARG_SECTION_TITLE = "sectionTitle";
    private static final String TAG = AttractionListFragment.class.getSimpleName();

    /* Class variables */
    private int sectionTitle;
    private ListView attractionListView;
    private AttractionListAdapter listViewAdapter;

    public static AttractionListFragment newInstance(int sectionTitle) {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_TITLE, sectionTitle);

        AttractionListFragment fragment = new AttractionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null) {
            sectionTitle = getArguments().getInt(ARG_SECTION_TITLE);
            Log.d(TAG, "onCreate: section title = " + sectionTitle);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.show_all_view, container, false);

        AttractionRepository repository = AttractionRepository.getInstance(getActivity());
        List<Attraction> attractions = repository.getCollection(sectionTitle).getAttractions();

        attractionListView = v.findViewById(R.id.show_all_list_view);
        listViewAdapter = new AttractionListAdapter(getActivity(), attractions, sectionTitle);
        attractionListView.setAdapter(listViewAdapter);

        return v;
    }
}
