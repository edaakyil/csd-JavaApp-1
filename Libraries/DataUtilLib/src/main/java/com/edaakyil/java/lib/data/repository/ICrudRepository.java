package com.edaakyil.java.lib.data.repository;

import java.util.Optional;

public interface ICrudRepository<T, ID> {
    long count();
    void delete(T entity);
    void deleteById(ID id);
    void deleteAll();
    void deleteAll(Iterable<? extends T> entities);
    void deleteAllById(Iterable<? extends ID> ids);
    boolean existsById(ID id);
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
}
