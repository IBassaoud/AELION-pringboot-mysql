package org.myownstock.user.helpers.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service<T> {
    ResponseEntity<T> add(T t);
    ResponseEntity<T> update(T t);
    List<T> findAll();
    ResponseEntity<T> remove(Long t);

}
