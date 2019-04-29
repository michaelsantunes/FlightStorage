package com.pt.flights.price.app.dev.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface DBCommonInterface<T1, T2, T3 extends Serializable> {

    T1 save(T1 entity);
    public T1 saveIfNotExist(T1 entity);
    T1 update(T1 entity);
    T1 findById(T2 id);
    Page<T1> findAll(Pageable pageable);
    boolean deleteById(T2 id);
    boolean deleteAll();
    T2 countByCriteriaQueryWithoutParameter() throws InterruptedException;
    T2 countByCriteriaQueryGreaterThanOrEqualToDate(T3 entity) throws InterruptedException;

}
