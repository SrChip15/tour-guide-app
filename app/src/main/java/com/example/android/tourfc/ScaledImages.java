package com.example.android.tourfc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

/**
 * Helper class for scaling down images to efficiently load images
 * Deliberately going with manually tweaking the Bitmaps
 * as opposed to using stable image loading frameworks for Android like Glide or Picasso,
 * so that I understand the inner workings of such frameworks as it is my first time
 */
final class ScaledImages {
    
    /**
     * This method reduces the size of the image to a power of two larger than my target size
     *
     * @param options   a nested class object of the factory that holds default values for a bunch
     *                  of bitmap configurations
     * @param reqWidth  an int value for the target image width
     * @param reqHeight an int value for the target image height
     * @return the scaling factor for the image file given its actual bounds
     */
    private static int calculateInSampleSize(BitmapFactory.Options options,
                                             int reqWidth, int reqHeight) {
        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;
        int inSampleSize = 1;
        
        if (srcHeight > reqHeight || srcWidth > reqWidth) {
            
            float widthScale = srcWidth / 2;
            float heightScale = srcHeight / 2;
            
            inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);
        }
        
        return inSampleSize;
    }
    
    /**
     * This method gets the scaling factor from the calculateInSampleSize method and scales the
     * image properly to present an overall nicer looking image
     *
     * @param res   a Resources object passing the control of the app's resources to access the image
     * @param resId an {@link int} value of the image resource ID
     * @return a scaled down {@link Bitmap} of the image file
     */
    static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int viewType) {
        
        int imageWidth = 0;
        int imageHeight = 0;
        
        switch (viewType) {
            case SingleAttractionDataAdapter.CARD_SIZE_IMAGE_DECODE:
                imageWidth = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        300,
                        res.getDisplayMetrics());
                imageHeight = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        150,
                        res.getDisplayMetrics());
                break;
            case AttractionListAdapter.LIST_ITEM_IMAGE_DECODE:
                imageWidth = imageHeight =
                        (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                88,
                                res.getDisplayMetrics()
                        );
            default:
                break;
        }
        
        // First decode with inJustDecodeBounds=true to check dimensions
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int inSampleSize = calculateInSampleSize(options, imageWidth, imageHeight);
        
        // Decode bitmap with inSampleSize set
        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
