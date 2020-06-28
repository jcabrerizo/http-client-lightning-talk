package io.cloudsoft.lightningtalk.httpclientapi.persistence;

import java.util.List;

public interface Storage<T,K> {

    T save(T item);

    T read(K id);

    void update(T item);

    void delete(K id);

    List<T> listAll();
}
