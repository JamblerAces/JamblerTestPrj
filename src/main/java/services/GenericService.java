package services;

import java.util.List;

public interface GenericService<E> {

    void add(E entity);

    void update(E entity);

    void remove(E entity);

    E find(long key);

    List<E> list();
}
