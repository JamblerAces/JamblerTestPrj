package services;

import services.dao.GenericDao;

import java.util.List;

public abstract class AbstractService<E> implements GenericService<E> {

    @Override
    public void add(E entity) {
        getDao().save(entity);
    }

    @Override
    public void update(E entity) {
        getDao().save(entity);
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
        return getDao().findAll();
    }

    protected abstract GenericDao<E> getDao();
}