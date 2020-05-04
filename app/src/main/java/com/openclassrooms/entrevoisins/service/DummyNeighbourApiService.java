package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> mFavNeighbours = DummyNeighbourGenerator.generateFavNeighbours();

    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public List<Neighbour> getFavoriteNeighbours(){
        List<Neighbour> FavoriteNeighbours = new ArrayList<>();
        for (Neighbour neighbour:neighbours){
            if (neighbour.isFavorites()){
                FavoriteNeighbours.add(neighbour);
            }
        }return FavoriteNeighbours;
    }



    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void deleteFavNeighbour(Neighbour neighbour) {
        mFavNeighbours.remove(neighbour);
    }

    @Override
    public void addFavoritesOrRemove(Neighbour neighbour){
            neighbours.get(neighbours.indexOf(neighbour)).setFavorites(!neighbour.isFavorites());
    }


}

