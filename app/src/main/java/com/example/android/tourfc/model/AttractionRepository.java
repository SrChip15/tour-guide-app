package com.example.android.tourfc.model;


import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.example.android.tourfc.R;

import java.util.ArrayList;
import java.util.List;

public class AttractionRepository {

    private Context context;
    private List<AttractionCollection> collections;
    private static AttractionRepository attractionRepository;

    public static AttractionRepository getInstance(Context packageContext) {
        if (attractionRepository == null) {
            attractionRepository = new AttractionRepository(packageContext);
        }
        return attractionRepository;
    }

    public AttractionCollection getCollection(int sectionTitle) {
        for (int i = 0; i < collections.size(); i++) {
            if (sectionTitle == collections.get(i).getHeaderTitle()) {
                return collections.get(i);
            }
        }

        return null;
    }

    private AttractionRepository(Context context) {
        this.context = context.getApplicationContext();
        collections = new ArrayList<>();

        // Build collection
        AttractionCollection activity = buildActivityCollection();
        collections.add(activity);

        AttractionCollection restaurants = buildRestaurantsCollection();
        collections.add(restaurants);

        AttractionCollection breweries = buildBreweriesCollection();
        collections.add(breweries);

        AttractionCollection nightLife = buildNightLifeCollection();
        collections.add(nightLife);
    }

    public List<AttractionCollection> getCollections() {
        return collections;
    }

    @VisibleForTesting
    static AttractionCollection buildActivityCollection() {
        List<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.horsetooth_mountain_park,
                        R.string.horsetooth_mountain_title,
                        R.string.scenic_open_space,
                        R.string.horsetooth_mountain_park_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.whitewater_rafting,
                        R.string.mountain_whitewater_title,
                        R.string.white_water_rafting,
                        R.string.mountain_whitewater_descents_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.flower_trail_garden,
                        R.string.flower_trial_garden_title,
                        R.string.horticulture_display,
                        R.string.flower_trail_garden_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.horsetooth_reservoir,
                        R.string.horsetooth_reservoir_title,
                        R.string.best_outdoors,
                        R.string.horsetooth_reservoir_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.city_park,
                        R.string.city_park_title,
                        R.string.ideal_relaxing_spot,
                        R.string.city_park_detailed_desc
                )
        );

        return new AttractionCollection(R.string.top_activities, attractions);
    }

    @VisibleForTesting
    static AttractionCollection buildRestaurantsCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.the_melting_pot,
                        R.string.melting_pot_title,
                        R.string.amazing_fondue,
                        R.string.the_melting_pot_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.maza_kabob,
                        R.string.maza_kabob_title,
                        R.string.afghan_specialty,
                        R.string.maza_kabob_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.rio_grande,
                        R.string.rio_grande_title,
                        R.string.amazing_margarita,
                        R.string.rio_grande_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.star_of_india,
                        R.string.star_of_india_title,
                        R.string.indian_buffet,
                        R.string.star_of_india_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.lucile_creole,
                        R.string.lucile_title,
                        R.string.breakfast_place,
                        R.string.lucile_creole_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.cafe_athens,
                        R.string.cafe_athens_title,
                        R.string.greek_mediterranean,
                        R.string.cafe_athens_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.cafe_de_bangkok,
                        R.string.cafe_de_bangkok_title,
                        R.string.traditional_thai,
                        R.string.cafe_de_bangkok_detailed_desc
                )
        );

        return new AttractionCollection(R.string.top_restaurants, attractions);
    }

    @VisibleForTesting
    static AttractionCollection buildBreweriesCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.new_belgium,
                        R.string.new_belgium_title,
                        R.string.new_belgium_free_tours,
                        R.string.new_belgium_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.odell_brewing,
                        R.string.odell_brewing_title,
                        R.string.odell_microbrew,
                        R.string.odell_brewing_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.anheuser_busch,
                        R.string.anheuser_busch_title,
                        R.string.grand_tour,
                        R.string.anheuser_busch_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.coopersmith_brewing,
                        R.string.coopersmith_title,
                        R.string.coopersmith_mixed_desc,
                        R.string.coopersmith_detailed_desc
                )
        );

        return new AttractionCollection(R.string.top_breweries, attractions);
    }

    @VisibleForTesting
    static AttractionCollection buildNightLifeCollection() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(
                        R.drawable.social,
                        R.string.social_title,
                        R.string.creative_cocktails,
                        R.string.social_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.mayor_old_town,
                        R.string.mayor_old_town_title,
                        R.string.mayor_great_selction,
                        R.string.mayor_of_old_town_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.colorado_room,
                        R.string.colorado_room_title,
                        R.string.colorado_beers_and_spirits,
                        R.string.the_colorado_room_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.ace_gilletts,
                        R.string.ace_gilletts_title,
                        R.string.gilletts_crafted_beers,
                        R.string.ace_gilletts_detailed_desc
                )
        );
        attractions.add(new Attraction(
                        R.drawable.elliot_martini_bar,
                        R.string.elliots_martini_title,
                        R.string.elliot_martini_variety,
                        R.string.elliot_martini_bar_detailed_desc
                )
        );

        return new AttractionCollection(R.string.top_bars_nightlife, attractions);
    }
}
