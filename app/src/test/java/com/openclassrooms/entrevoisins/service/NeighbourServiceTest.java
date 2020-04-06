package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

    @After
    public void backup(){
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
    public void getFavoriteNeighboursWithSuccess(){
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavoritesOrRemove(neighbour);
        List<Neighbour> favoritesNeighbours = service.getFavoriteNeighbours();
        assertTrue(favoritesNeighbours.get(0).isFavorites());

    }

    @Test
    public void addFavoriteOrRemoveWithSuccess(){
        Neighbour neighbour = service.getNeighbours().get(1);
        assertFalse(neighbour.isFavorites());
        service.addFavoritesOrRemove(neighbour);
        assertTrue(neighbour.isFavorites());
        service.addFavoritesOrRemove(neighbour);
        assertFalse(neighbour.isFavorites());

    }
}
