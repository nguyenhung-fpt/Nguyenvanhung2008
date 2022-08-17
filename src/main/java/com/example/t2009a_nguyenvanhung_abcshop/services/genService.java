package com.example.t2009a_nguyenvanhung_abcshop.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface genService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}


