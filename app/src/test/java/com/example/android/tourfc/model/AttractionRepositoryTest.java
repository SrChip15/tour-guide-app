package com.example.android.tourfc.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class AttractionRepositoryTest {

    private AttractionRepository subject;

    @Before
    public void setup() {
        // Nothing for now
    }

    @Test
    public void saveAsAttractionCollection_buildActivityCollection() {
        assertThat(AttractionRepository.buildActivityCollection(), instanceOf(AttractionCollection.class));
    }

    @Test
    public void saveAsAttractionCollection_buildRestaurantsCollection() {
        assertThat(AttractionRepository.buildRestaurantsCollection(), instanceOf(AttractionCollection.class));
    }

    @Test
    public void saveAsAttractionCollection_buildBreweriesCollection() {
        assertThat(AttractionRepository.buildBreweriesCollection(), instanceOf(AttractionCollection.class));
    }

    @Test
    public void saveAsAttractionCollection_buildNightLifeCollection() {
        assertThat(AttractionRepository.buildNightLifeCollection(), instanceOf(AttractionCollection.class));
    }

    // TODO - Try injection to write tests for this class
}