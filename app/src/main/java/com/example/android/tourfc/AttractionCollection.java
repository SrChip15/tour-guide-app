package com.example.android.tourfc;

import java.util.ArrayList;

class AttractionCollection {

	private String mHeaderTitle;
	private ArrayList<AttractionDetails> mCollection;

	AttractionCollection(String mHeaderTitle, ArrayList<AttractionDetails> mCollection) {
		this.mHeaderTitle = mHeaderTitle;
		this.mCollection = mCollection;
	}

	String getHeaderTitle() {
		return mHeaderTitle;
	}

	ArrayList<AttractionDetails> getCollection() {
		return mCollection;
	}
}
