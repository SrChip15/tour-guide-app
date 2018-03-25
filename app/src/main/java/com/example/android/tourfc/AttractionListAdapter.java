package com.example.android.tourfc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
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

    /** Layout inflater to inflate custom layout */
    private LayoutInflater mLayoutInflater;

    /** ArrayList for {@link Attraction} object */
    private List<Attraction> mAttractions;

    /**
     * Create new collection adapter
     *
     * @param context     holds the {@link Context} of the {@link android.widget.ListView}
     * @param attractions an {@link ArrayList} of {@link Attraction} objects
     */
    public AttractionListAdapter(@NonNull Context context, List<Attraction> attractions) {
        super(context, 0, attractions);
        mAttractions = new ArrayList<>();
        mAttractions = attractions;
        mLayoutInflater = LayoutInflater.from(context);
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

        // Set the image of the attraction for the {@link ImageView}
        final ImageView attractionImage = convertView.findViewById(R.id.list_item_image);

        // Convert px to dips
        Resources resources = convertView.getResources();
        int dimensionsInDips = (int) TypedValue
                .applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        88,
                        resources.getDisplayMetrics());

        // Use scaled down version of image for the image set in {@link ListView} row
        attractionImage.setImageBitmap(ScaledImages
                .decodeSampledBitmapFromResource(
                        resources,
                        currentAttraction.getImageResourceId(), dimensionsInDips, dimensionsInDips));

        // Set text for the title {@link TextView}
        TextView titleText = convertView.findViewById(R.id.list_item_title_text_view);
        titleText.setText(currentAttraction.getTitle());

        // Set text for the brief description {@link TextView}
        TextView descText = convertView.findViewById(R.id.list_item_brief_desc_text_view);
        descText.setText(currentAttraction.getDescription());

        // Set up the row in the {@link ListView} to respond to click(s)
        // Get a handle on the {@link RelativeLayout} that holds the attraction's data
        RelativeLayout listRow = convertView.findViewById(R.id.list_item_row);

        // Setup and register an {@link OnClickListener} to navigate to the appropriate activity
        listRow.setOnClickListener(v -> {
            // Store the title of the attraction
            final int attractionName;

            // Grab the context from the view
            Context context = v.getContext();

            // Get the name of the attraction that is being viewed by the user presently
            attractionName = currentAttraction.getTitle();

            // Create intent to the appropriate activity based on the name of the attraction
            // item that is being requested by the user
            switch (attractionName) {
                case R.string.horsetooth_mountain_title:
                    Intent horseToothIntent = new Intent(context, HorsetoothMountainActivity.class);
                    horseToothIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(horseToothIntent);
                    break;
                case R.string.mountain_whitewater_title:
                    Intent whiteWaterIntent = new Intent(context, MountainDescentsActivity.class);
                    whiteWaterIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(whiteWaterIntent);
                    break;
                case R.string.flower_trial_garden_title:
                    Intent flowerTrialIntent = new Intent(context, FlowerTrialGardenActivity.class);
                    flowerTrialIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(flowerTrialIntent);
                    break;
                case R.string.horsetooth_reservoir_title:
                    Intent reservoirIntent = new Intent(context, HorsetoothReservoirActivity.class);
                    reservoirIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(reservoirIntent);
                    break;
                case R.string.city_park_title:
                    Intent cityParkIntent = new Intent(context, CityParkActivity.class);
                    cityParkIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(cityParkIntent);
                    break;
                case R.string.melting_pot_title:
                    Intent meltingPotIntent = new Intent(context, MeltingPotActivity.class);
                    meltingPotIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(meltingPotIntent);
                    break;
                case R.string.maza_kabob_title:
                    Intent mazaKabobIntent = new Intent(context, MazaKabobActivity.class);
                    mazaKabobIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(mazaKabobIntent);
                    break;
                case R.string.rio_grande_title:
                    Intent rioGrandeIntent = new Intent(context, RioGrandeActivity.class);
                    rioGrandeIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(rioGrandeIntent);
                    break;
                case R.string.star_of_india_title:
                    Intent starOfIndiaIntent = new Intent(context, StarOfIndiaActivity.class);
                    starOfIndiaIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(starOfIndiaIntent);
                    break;
                case R.string.lucile_title:
                    Intent lucileIntent = new Intent(context, LucileActivity.class);
                    lucileIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(lucileIntent);
                    break;
                case R.string.cafe_athens_title:
                    Intent cafeAthensIntent = new Intent(context, CafeAthensActivity.class);
                    cafeAthensIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(cafeAthensIntent);
                    break;
                case R.string.cafe_de_bangkok_title:
                    Intent bangkokCafeIntent = new Intent(context, CafeDeBangkokActivity.class);
                    bangkokCafeIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(bangkokCafeIntent);
                    break;
                case R.string.new_belgium_title:
                    Intent newBelgiumIntent = new Intent(context, NewBelgiumActivity.class);
                    newBelgiumIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(newBelgiumIntent);
                    break;
                case R.string.odell_brewing_title:
                    Intent odellIntent = new Intent(context, OdellActivity.class);
                    odellIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(odellIntent);
                    break;
                case R.string.anheuser_busch_title:
                    Intent buschIntent = new Intent(context, AnheuserBuschActivity.class);
                    buschIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(buschIntent);
                    break;
                case R.string.coopersmith_title:
                    Intent cooperSmithIntent = new Intent(context, CooperSmithActivity.class);
                    cooperSmithIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(cooperSmithIntent);
                    break;
                case R.string.social_title:
                    Intent socialIntent = new Intent(context, SocialActivity.class);
                    socialIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(socialIntent);
                    break;
                case R.string.mayor_old_town_title:
                    Intent mayorIntent = new Intent(context, MayorOfOldTownActivity.class);
                    mayorIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(mayorIntent);
                    break;
                case R.string.colorado_room_title:
                    Intent coloradoRoomIntent = new Intent(context, ColoradoRoomActivity.class);
                    coloradoRoomIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(coloradoRoomIntent);
                    break;
                case R.string.ace_gilletts_title:
                    Intent aceIntent = new Intent(context, AceGillettsActivity.class);
                    aceIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(aceIntent);
                    break;
                case R.string.elliots_martini_title:
                    Intent elliotIntent = new Intent(context, ElliotMartiniActivity.class);
                    elliotIntent.putExtra("from_where", "AttractionListAdapter");
                    context.startActivity(elliotIntent);
                    break;
                default:
                    throw new IllegalArgumentException("Not an valid attraction!");
            }
        });

        // Return the data bound inflated view
        return convertView;
    }

    @Override
    public int getCount() {
        return mAttractions == null ? 0 : mAttractions.size();
    }
}
