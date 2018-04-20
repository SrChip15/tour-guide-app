package com.example.android.tourfc;

import android.app.Activity;
import android.support.test.filters.SmallTest;

import org.junit.Test;
import org.robolectric.Robolectric;

@SmallTest
public class AttractionActivityTest {

    @Test
    public void shouldShowAttractionFragment() {
        Activity activity = Robolectric.setupActivity(AttractionActivity.class);
        activity.findViewById(R.id.detail_image_view).setBackgroundResource(R.drawable.sample);
    }
}