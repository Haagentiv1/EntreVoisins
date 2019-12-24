package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public List<Neighbour> getFavoriteNeighbours(){
        List<Neighbour> FavoriteNeighbours = new ArrayList<>();
        for (Neighbour neighbour:neighbours){
            if (neighbour.isFavorites()== true){
                FavoriteNeighbours.add(neighbour);
            }
        }return FavoriteNeighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void addFavoritesOrRemove(Neighbour neighbour){
        if (neighbours.get(neighbours.indexOf(neighbour)).isFavorites() == true){
            neighbours.get(neighbours.indexOf(neighbour)).setFavorites(false);
        }else{ neighbours.get(neighbours.indexOf(neighbour)).setFavorites(true);}
    }
}

