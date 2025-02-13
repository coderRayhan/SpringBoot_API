package com.hrm.smartHR.base;

import java.util.List;

public interface BaseService<T> {
    T save(T obj);
    T update(T obj);
    Boolean delete(T obj);
    T getById(int id);
    List<T> getAll();
}
