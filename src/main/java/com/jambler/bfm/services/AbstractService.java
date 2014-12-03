package com.jambler.bfm.services;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.jambler.bfm.services.dao.GenericDao;

import java.util.List;

public abstract class AbstractService<E> implements GenericService<E> {

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void add(E entity) {
        getLogger().debug("Saving entity: " + entity);
        getDao().save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void update(E entity) {
        getLogger().debug("Updating entity: " + entity);
        getDao().save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void remove(E entity) {
        getLogger().debug("Removing entity: " + entity);
        getDao().remove(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public E find(long key) {
        getLogger().debug("Looking for entity with key = " + key);
        return getDao().find(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<E> list() {
        getLogger().debug("Looking for all entities");
        return getDao().findAll();
    }

    protected abstract GenericDao<E> getDao();

    protected abstract Logger getLogger();
}
