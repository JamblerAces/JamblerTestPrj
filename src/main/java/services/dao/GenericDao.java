package services.dao;

import java.util.List;

public interface GenericDao<E> {

    void save(E entity);

    void remove(E entity);

    E find(Long key);

    List<E> findAll();

}
