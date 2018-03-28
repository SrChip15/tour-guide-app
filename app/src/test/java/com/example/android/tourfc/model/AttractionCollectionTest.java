package com.example.android.tourfc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mock;

public class AttractionCollectionTest {

    private AttractionCollection subject;

    private static final int TEST_HEADER = 111;

    @Before
    public void setUp() {
        Attraction attraction = mock(Attraction.class);
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(attraction);

        subject = new AttractionCollection(TEST_HEADER, attractions);
    }

    @Test
    public void saveResIdAsHeaderTitle() {
        assertThat(subject.getHeaderTitle(), is(TEST_HEADER));
    }

    @Test
    public void savesAttractionType_getAttractions() {
        assertThat(subject.getAttractions().get(0), isA(Attraction.class));
    }

    @Test
    public void returnsAList_getAttractions() {
        assertThat(subject.getAttractions(), instanceOf(List.class));
    }
}