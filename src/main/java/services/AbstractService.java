package services;

import services.GenericService;
import services.dao.GenericDao;

import java.util.List;

public abstract class AbstractService<E> implements GenericService<E> {

    @Override
    public void add(E entity) {
        getDao().add(entity);
    }

    @Override
    public void update(E entity) {
        getDao().update(entity);
    }

    @Override
    public void remove(E entity) {
        getDao().remove(entity);
    }

    @Override
    public E find(long key) {
        return getDao().find(key);
    }

    @Override
    public List<E> list() {
        return getDao().list();
    }

    protected abstract GenericDao<E, Long> getDao();
}
