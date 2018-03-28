package com.example.android.tourfc.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AttractionTest {

    private Attraction subject;

    private static final int TEST_IMAGE = 11;
    private static final int TEST_TITLE = 22;
    private static final int TEST_SHORT_DESC = 33;
    private static final int TEST_LONG_DESC = 44;

    @Before
    public void setUp() {
        subject = new Attraction(TEST_IMAGE, TEST_TITLE, TEST_SHORT_DESC, TEST_LONG_DESC);
    }

    @Test
    public void storesResIdForImage() {
        assertThat(subject.getImageResourceId(), is(TEST_IMAGE));
    }

    @Test
    public void storesResIdAsTitle() {
        assertThat(subject.getTitle(), is(TEST_TITLE));
    }

    @Test
    public void storesResIdAsShortDesc() {
        assertThat(subject.getShortDesc(), is(TEST_SHORT_DESC));
    }

    @Test
    public void storesResIdAsLongDesc() {
        assertThat(subject.getLongDesc(), is(TEST_LONG_DESC));
    }
}