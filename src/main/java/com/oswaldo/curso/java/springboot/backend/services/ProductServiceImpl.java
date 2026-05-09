package com.oswaldo.curso.java.springboot.backend.services;

import com.oswaldo.curso.java.springboot.backend.entities.Product;
import com.oswaldo.curso.java.springboot.backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    final private ProductRepository respository;

    /***
     *
     * @param respository Ya que se implementarán los métodos que tiene la Interface
     */
    public ProductServiceImpl(ProductRepository respository) {
        this.respository = respository;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return respository.findAll(); //Se quitó el cast -> (List<Product>)
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return respository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return respository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> deleteById(Long id) {
        Optional<Product> productOptional = respository.findById(id);
        if(productOptional.isPresent()){
            respository.deleteById(id);
            return productOptional;
        }
        return Optional.empty();
    }
}
