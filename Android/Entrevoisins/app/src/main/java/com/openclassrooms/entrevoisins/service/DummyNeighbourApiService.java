package com.openclassrooms.entrevoisins.service;

import android.widget.Toast;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailNeighbourActivity;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbours = DummyNeighbourGenerator.generateFavoriteNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }


    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        return favoriteNeighbours;
    }

    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {

        favoriteNeighbours.add(neighbour);
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteNeighbours.remove(neighbour);
    }

    @Override
    public boolean verifyNeighbourFavorite(Neighbour neighbour) {
        boolean verificationDoublon;

        if (favoriteNeighbours.contains(neighbour)) {
            verificationDoublon = true;
        } else {
            verificationDoublon = false;
        }

        return verificationDoublon;
    }
}
