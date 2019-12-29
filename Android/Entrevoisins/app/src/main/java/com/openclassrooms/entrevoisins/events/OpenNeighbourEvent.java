package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user open a Neighbour
 */
public class OpenNeighbourEvent {

    /**
     * Neighbour to Open
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public OpenNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
