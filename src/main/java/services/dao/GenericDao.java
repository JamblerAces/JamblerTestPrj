package services.dao;

import java.util.List;

public interface GenericDao<E, K> {

    void create(E entity);

    void update(E entity);

    void remove(E entity);

    E find(K key);

    List<E> findAll();

}
