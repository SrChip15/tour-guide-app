package com.example.android.tourfc;

public class AttractionDetails {

	private int mImageResourceId;
	private String mTitle;
	private String mDescription;

	/**
	 * Create data object that holds all the details of an attraction
	 * This constructor would be invoked when the details do not include an image resource for the
	 * said attraction
	 *
	 * @param mTitle       a String value for the name of the attraction
	 * @param mDescription a String value for a brief description of the attraction
	 */
	public AttractionDetails(String mTitle, String mDescription) {
		this(0, mTitle, mDescription);
	}

	/**
	 * Create data object that holds all the details of an attraction including an image resource
	 * for the attraction
	 *
	 * @param mImageResourceId an integer value for the image resource ID
	 * @param mTitle           a String value for the name of the attraction
	 * @param mDescription     a String value for a brief description of the attraction
	 */
	public AttractionDetails(int mImageResourceId, String mTitle, String mDescription) {
		this.mImageResourceId = mImageResourceId;
		this.mTitle = mTitle;
		this.mDescription = mDescription;
	}

	/**
	 * Return the image file's unique ID
	 *
	 * @return the ID as an integer value
	 */
	public int getmImageResourceId() {
		return mImageResourceId;
	}

	/**
	 * Get the name of the attraction
	 *
	 * @return the name of the attraction as a String
	 */
	public String getmTitle() {
		return mTitle;
	}

	/**
	 * Get the description of the attraction
	 *
	 * @return brief description of the attraction as a String
	 */
	public String getmDescription() {
		return mDescription;
	}
}
