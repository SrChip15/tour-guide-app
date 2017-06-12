package com.example.android.tourfc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
	 * @param reqWidth  an {@link int} value for the target image width
	 * @param reqHeight an {@link int} value for the target image height
	 * @return the scaling factor for the image file given its actual bounds
	 */
	private static int calculateInSampleSize(
			BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) >= reqHeight
					&& (halfWidth / inSampleSize) >= reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	/**
	 * This method gets the scaling factor from the calculateInSampleSize method and scales the
	 * image properly to present an overall nicer looking image
	 *
	 * @param res       a Resources object passing the control of the app's resources to access the image
	 * @param resId     an {@link int} value of the image resource ID
	 * @param reqWidth  an {@link int} value of the target width of the image
	 * @param reqHeight an {@link int} value of the target height of the imaage
	 * @return a scaled down {@link Bitmap} of the image file
	 */
	static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	                                              int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}
}
