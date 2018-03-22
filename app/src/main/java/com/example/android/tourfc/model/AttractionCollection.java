package com.example.android.tourfc.model;

import java.util.ArrayList;

public class AttractionCollection {

	private int headerTitle;
	private ArrayList<Attraction> listOfAttractions;

	public AttractionCollection(int headerTextResId, ArrayList<Attraction> listOfAttractions) {
		this.headerTitle = headerTextResId;
		this.listOfAttractions = listOfAttractions;
	}

	public int getHeaderTitle() {
		return headerTitle;
	}

	public ArrayList<Attraction> getAttractions() {
		return listOfAttractions;
	}
}
