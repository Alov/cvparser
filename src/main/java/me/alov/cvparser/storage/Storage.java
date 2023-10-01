package me.alov.cvparser.storage;

public interface Storage<T, ID> {

    T save(T entity);
}
