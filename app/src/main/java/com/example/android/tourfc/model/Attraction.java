package com.example.android.tourfc.model;

public class Attraction {

    /** Image resource ID for the image file associated with the attraction */
    private int imageResourceId;

    /** Title of the attraction */
    private int titleTextResId;

    /** Brief description of the attraction */
    private int descriptionTextResId;

    /**
     * Create data object that holds all the details of an attraction including an image resource
     * for the attraction
     *
     * @param imageResourceId an integer value for the image resource ID
     * @param titleTextResId           a String value for the name of the attraction
     * @param descriptionTextResId     a String value for a brief description of the attraction
     */
    public Attraction(int imageResourceId, int titleTextResId, int descriptionTextResId) {
        this.imageResourceId = imageResourceId;
        this.titleTextResId = titleTextResId;
        this.descriptionTextResId = descriptionTextResId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getTitle() {
        return titleTextResId;
    }

    public int getDescription() {
        return descriptionTextResId;
    }
}
