package com.openclassrooms.entrevoisins.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.OpenNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter;


import org.greenrobot.eventbus.EventBus;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.w3c.dom.Text;

import java.util.List;

import butterknife.OnClick;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private Neighbour mNeighbour;
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
    public void getFavoriteNeighbourWithSuccess () {
        List<Neighbour> favoriteNeighbours= service.getFavoriteNeighbours();
        List<Neighbour> expectedFavoriteNeighbours= DummyNeighbourGenerator.DUMMY_FAVORITE_NEIGHBOURS;
        assertThat(favoriteNeighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));

    }

    @Test
    public void addNeighbourToFavorite() {
        Neighbour mNeighbour= Mockito.mock(Neighbour.class);
        List<Neighbour> mListFavoriteNeighbour= service.getFavoriteNeighbours();
        assertEquals(0, mListFavoriteNeighbour.size());

        service.addFavoriteNeighbour(mNeighbour);
        assertEquals(1, mListFavoriteNeighbour.size());

    }

    @Test
    public void verifyNeighbourFavorite() {
        Neighbour mNeighbour= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3=Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour2);
        service.addFavoriteNeighbour(mNeighbour3);

        assertTrue(service.verifyNeighbourFavorite(mNeighbour));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour2));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour3));

    }

    @Test
    public void verifyNeighbourNotFavorite() {
        Neighbour mNeighbour= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3=Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour3);

        assertTrue(service.verifyNeighbourFavorite(mNeighbour));
        assertFalse(service.verifyNeighbourFavorite(mNeighbour2));
        assertTrue(service.verifyNeighbourFavorite(mNeighbour3));

    }

    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        Neighbour mNeighbour= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour2= Mockito.mock(Neighbour.class);
        Neighbour mNeighbour3=Mockito.mock(Neighbour.class);

        service.addFavoriteNeighbour(mNeighbour);
        service.addFavoriteNeighbour(mNeighbour2);
        service.addFavoriteNeighbour(mNeighbour3);

        assertEquals(3, service.getFavoriteNeighbours().size());

       service.deleteFavoriteNeighbour(mNeighbour2);
       assertEquals(2, service.getFavoriteNeighbours().size());

    }


}



