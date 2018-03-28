package com.example.android.tourfc.model;

import java.util.List;

public class AttractionCollection {

	private int headerTitle;
	private List<Attraction> listOfAttractions;

	public AttractionCollection(int headerTextResId, List<Attraction> listOfAttractions) {
		this.headerTitle = headerTextResId;
		this.listOfAttractions = listOfAttractions;
	}

	public int getHeaderTitle() {
		return headerTitle;
	}

	public List<Attraction> getAttractions() {
		return listOfAttractions;
	}
}
