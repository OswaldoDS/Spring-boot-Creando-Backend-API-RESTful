package com.oswaldo.curso.java.springboot.backend.repositories;

import com.oswaldo.curso.java.springboot.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * JpaRepository se puede usar en vez de CrudRepository
 * Ya que esta tiene más funcionalidades y métodos aplicados
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
}
