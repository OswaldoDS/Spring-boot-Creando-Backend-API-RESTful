package com.oswaldo.curso.java.springboot.backend.repositories;

import com.oswaldo.curso.java.springboot.backend.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
