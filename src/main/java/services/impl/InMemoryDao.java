package services.impl;

import services.GenericDao;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDao<E, K> implements GenericDao<E, K> {

    private List<E> entities = new ArrayList<E>();

    @Override
    public void add(E entity) {
        entities.add(entity);
    }

    @Override
    public void update(E entity) {
        throw new UnsupportedOperationException("Not supported in dummy in-memory impl!");
    }

    @Override
    public void remove(E entity) {
        entities.remove(entity);
    }

    @Override
    public E find(K key) {
        if (entities.isEmpty()) {
            return null;
        }
        // just return the first one since we are not using any keys ATM
        return entities.get(0);
    }

    @Override
    public List<E> list() {
        return entities;
    }

}
