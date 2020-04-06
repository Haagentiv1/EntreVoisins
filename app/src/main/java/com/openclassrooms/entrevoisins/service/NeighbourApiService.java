package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * change the favorite state
     * @param neighbour
     */
    void addFavoritesOrRemove(Neighbour neighbour);

    /**
     * Get all neighbours who's have favorites state = true
     * @return
     */
    List<Neighbour> getFavoriteNeighbours();
}
