package com.example.t2009a_nguyenvanhung_abcshop.repostory;

import com.example.t2009a_nguyenvanhung_abcshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}

