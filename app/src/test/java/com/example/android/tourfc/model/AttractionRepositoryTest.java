package com.example.android.tourfc.model;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class AttractionRepositoryTest {

    @Test
    public void saveAsAttractionCollection_buildActivityCollection() {
        assertThat(AttractionRepository.buildActivityCollection(), instanceOf(AttractionCollection.class));
    }

    // TODO - Try injection to write tests for this class
}