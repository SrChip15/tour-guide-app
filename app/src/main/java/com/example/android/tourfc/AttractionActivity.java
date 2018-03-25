package com.example.android.tourfc;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class AttractionActivity extends SingleActivity {

    private static final String EXTRA_NAME = "com.example.android.tourfc.attraction_name";
    private static final String EXTRA_IMAGE = "com.example.android.tourfc.attraction_image";
    private static final String EXTRA_DESC = "com.example.android.tourfc.attraction_desc";
    private static final int ERROR_PARAM_VALUE = 404;

    private int nameResId;
    private int imageResId;
    private int descResId;

    public static Intent newIntent(Context packageContext, int name, int image, int desc) {
        Intent intent = new Intent(packageContext, AttractionActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_IMAGE, image);
        intent.putExtra(EXTRA_DESC, desc);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        getParams();
        return AttractionFragment.newInstance(nameResId, imageResId, descResId);
    }

    private void getParams() {
        nameResId = getIntent().getIntExtra(EXTRA_NAME, ERROR_PARAM_VALUE);
        imageResId = getIntent().getIntExtra(EXTRA_IMAGE, ERROR_PARAM_VALUE);
        descResId = getIntent().getIntExtra(EXTRA_DESC, ERROR_PARAM_VALUE);
    }
}
