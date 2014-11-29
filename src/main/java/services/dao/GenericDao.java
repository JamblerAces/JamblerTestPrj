package services.dao;

import java.util.List;

public interface GenericDao<E, K> {

    void save(E entity);

    void remove(E entity);

    E find(K key);

    List<E> findAll();

}
