package com.example.android.tourfc;

import android.content.Context;

public final class Utils {

    public static int resolveStringToResId(Context context, CharSequence text) {
        if (context.getString(R.string.top_activities).equals(text)) return R.string.top_activities;
        else if (context.getString(R.string.top_bars_nightlife).equals(text)) return R.string.top_bars_nightlife;
        else if (context.getString(R.string.top_breweries).equals(text)) return R.string.top_breweries;
        else if (context.getString(R.string.top_restaurants).equals(text)) return R.string.top_restaurants;
        else return 0;
    }
}
