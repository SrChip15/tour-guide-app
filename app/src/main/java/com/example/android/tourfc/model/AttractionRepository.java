package com.example.android.tourfc.model;


import android.content.Context;
import android.util.SparseArray;

import com.example.android.tourfc.R;

import java.util.ArrayList;

public class AttractionRepository {

    private Context context;
    private SparseArray<AttractionCollection> collections;
    private static AttractionRepository attractionRepository;

    public static AttractionRepository getInstance(Context packageContext) {
        if (attractionRepository == null) {
            attractionRepository = new AttractionRepository(packageContext);
        }
        return attractionRepository;
    }

    private AttractionRepository(Context context) {
        this.context = context.getApplicationContext();
        collections = new SparseArray<>();

        // Build collection
        AttractionCollection activity = buildActivityCollection();
        collections.put(activity.getHeaderTitle(), activity);

        AttractionCollection restaurants = buildRestaurantsCollection();
        collections.put(restaurants.getHeaderTitle(), restaurants);

        AttractionCollection breweries = buildBreweriesCollection();
        collections.put(breweries.getHeaderTitle(), breweries);

        AttractionCollection nightLife = buildNightLifeCollection();
        collections.put(nightLife.getHeaderTitle(), nightLife);
    }

    public SparseArray<AttractionCollection> getCollections() {
        return collections;
    }

    private AttractionCollection buildActivityCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.moon_over_horsetooth,
                        R.string.horsetooth_mountain_title,
                        R.string.scenic_open_space
                )
        );
        attractions.add(new Attraction(
                        R.drawable.whitewater_rafting,
                        R.string.mountain_whitewater_title,
                        R.string.white_water_rafting
                )
        );
        attractions.add(new Attraction(
                        R.drawable.flower_trail_garden,
                        R.string.flower_trial_garden_title,
                        R.string.horticulture_display
                )
        );
        attractions.add(new Attraction(
                        R.drawable.horsetooth_reservoir,
                        R.string.horsetooth_reservoir_title,
                        R.string.best_outdoors
                )
        );
        attractions.add(new Attraction(
                        R.drawable.city_park,
                        R.string.city_park_title,
                        R.string.ideal_relaxing_spot
                )
        );

        return new AttractionCollection(R.string.top_activities, attractions);
    }

    private AttractionCollection buildRestaurantsCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.the_melting_pot,
                        R.string.melting_pot_title,
                        R.string.amazing_fondue
                )
        );
        attractions.add(new Attraction(
                        R.drawable.maza_kabob,
                        R.string.maza_kabob_title,
                        R.string.afghan_specialty
                )
        );
        attractions.add(new Attraction(
                        R.drawable.rio_grande,
                        R.string.rio_grande_title,
                        R.string.amazing_margarita
                )
        );
        attractions.add(new Attraction(
                        R.drawable.star_of_india,
                        R.string.star_of_india_title,
                        R.string.indian_buffet
                )
        );
        attractions.add(new Attraction(
                        R.drawable.lucile_creole,
                        R.string.lucile_title,
                        R.string.breakfast_place
                )
        );
        attractions.add(new Attraction(
                        R.drawable.cafe_athens,
                        R.string.cafe_athens_title,
                        R.string.greek_mediterranean
                )
        );
        attractions.add(new Attraction(
                        R.drawable.cafe_de_bangkok,
                        R.string.cafe_de_bangkok_title,
                        R.string.traditional_thai
                )
        );

        return new AttractionCollection(R.string.top_restaurants, attractions);
    }

    private AttractionCollection buildBreweriesCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.new_belgium,
                        R.string.new_belgium_title,
                        R.string.new_belgium_free_tours
                )
        );
        attractions.add(new Attraction(
                        R.drawable.odell_brewing,
                        R.string.odell_brewing_title,
                        R.string.odell_microbrew
                )
        );
        attractions.add(new Attraction(
                        R.drawable.anheuser_busch,
                        R.string.anheuser_busch_title,
                        R.string.grand_tour
                )
        );
        attractions.add(new Attraction(
                        R.drawable.coopersmith_brewing,
                        R.string.coopersmith_title,
                        R.string.coopersmith_mixed_desc
                )
        );

        return new AttractionCollection(R.string.top_breweries, attractions);
    }

    private AttractionCollection buildNightLifeCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.social,
                        R.string.social_title,
                        R.string.creative_cocktails
                )
        );
        attractions.add(new Attraction(
                        R.drawable.mayor_old_town,
                        R.string.mayor_old_town_title,
                        R.string.mayor_great_selction
                )
        );
        attractions.add(new Attraction(
                        R.drawable.colorado_room,
                        R.string.colorado_room_title,
                        R.string.colorado_beers_and_spirits
                )
        );
        attractions.add(new Attraction(
                        R.drawable.ace_gilletts,
                        R.string.ace_gilletts_title,
                        R.string.gilletts_crafted_beers
                )
        );
        attractions.add(new Attraction(
                        R.drawable.elliot_martini_bar,
                        R.string.elliots_martini_title,
                        R.string.elliot_martini_variety
                )
        );

        return new AttractionCollection(R.string.top_bars_nightlife, attractions);
    }
}
