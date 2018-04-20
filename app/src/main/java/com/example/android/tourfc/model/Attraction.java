package com.example.android.tourfc.model;

import java.io.Serializable;

public class Attraction implements Serializable{

    /** Image resource ID for the image file associated with the attraction */
    private int imageResourceId;

    /** Title of the attraction */
    private int titleTextResId;

    /** Brief description of the attraction */
    private int shortDescTextResId;

    /** Long description of the attraction */
    private int longDescTextResId;

    /** Map Query String of attraction */
    private int mapQueryStrId;

    /**
     * Create data object that holds all the details of an attraction including an image resource
     * for the attraction
     *
     * @param imageResourceId an integer value for the image resource ID
     * @param titleTextResId           a String value for the name of the attraction
     * @param shortDescTextResId     a String value for a brief description of the attraction
     */
    public Attraction(int imageResourceId, int titleTextResId, int shortDescTextResId, int longDescTextResId, int mapQueryStrId) {
        this.imageResourceId = imageResourceId;
        this.titleTextResId = titleTextResId;
        this.shortDescTextResId = shortDescTextResId;
        this.longDescTextResId = longDescTextResId;
        this.mapQueryStrId = mapQueryStrId;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getTitle() {
        return titleTextResId;
    }

    public int getShortDesc() {
        return shortDescTextResId;
    }

    public int getLongDesc() {
        return longDescTextResId;
    }

    public int getMapQueryStrId() {
        return mapQueryStrId;
    }
}
