package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }


    @Test
    public void getFavoriteNeighbourWithSuccess() {
        List<Neighbour> favoriteNeighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedFavoriteNeighbours = DummyNeighbourGenerator.DUMMY_FAVORITE_NEIGHBOURS;
        assertThat(favoriteNeighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));

    }

    @Test
    public void addNeighbourToFavorite() {
        Neighbour mNeighbour = Mockito.mock(Neighbour.class);
        List<Neighbour> mListFavoriteNeighbour = service.getFavoriteNeighbours();
        assertEquals(0, mListFavoriteNeighbour.size());

        service.addFavoriteNeighbour(mNeighbour);
        assertEquals(1, mListFavoriteNeighbour.size());

    }

    @Test
    public void verifyNeighbourFavorite() {
        Neighbour mNeighbour = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2 = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3 = Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour2);
        service.addFavoriteNeighbour(mNeighbour3);

        assertTrue(service.verifyNeighbourFavorite(mNeighbour));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour2));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour3));

    }

    @Test
    public void verifyNeighbourNotFavorite() {
        Neighbour mNeighbour = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2 = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3 = Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour3);

        assertTrue(service.verifyNeighbourFavorite(mNeighbour));
        assertFalse(service.verifyNeighbourFavorite(mNeighbour2));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour3));

    }

    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        Neighbour mNeighbour = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2 = Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3 = Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour2);
        service.addFavoriteNeighbour(mNeighbour3);

        assertEquals(3, service.getFavoriteNeighbours().size());

        service.deleteFavoriteNeighbour(mNeighbour2);
        assertEquals(2, service.getFavoriteNeighbours().size());

    }


}



