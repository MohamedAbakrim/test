package com.infotech.avocatech.services;

import java.util.List;

public interface AbstractService<T> {

    T save(T dto);

    List<T> findAll();

    T findById(Integer id);

    Integer delete(Integer id);

}
