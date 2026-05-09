package com.oswaldo.curso.java.springboot.backend.controllers;

import com.oswaldo.curso.java.springboot.backend.entities.Product;
import com.oswaldo.curso.java.springboot.backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/***
 * @author Oswaldo de los Santos
 * @version 1.0
 * @since 1.0
 */

@RestController
public class ProductController {
    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * ResponseEntity -> Es el JSON
     *
     * @return una lista (arreglo) con los objetos productos en estructura JSON
     */
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    /***
     *
     * @param id ID del producto
     * @return Se verifica si existe el producto en caso de que no retorna un mensaje 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        }
        return ResponseEntity.notFound().build();
    }

    /***
     * @RequestBody es donde se envia en formato JSON el objeto de Producto
     * @param product Nuevo producto a crear
     * @return Regresa un mensaje 200, ya que el producto se creó en la tabla
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productDB = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDB);
    }

    /***
     *
     * @param product Es para crear un nuevo objeto en la DB
     * @param id Con el ID se verifica que exista el producto que se busca editar
     * @return En caso que exista el producto con id se guarda en caso que no generara un mensaje 404
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        //Primero buscamos en base de datos que exista el objeto
        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) {
            Product productDB = optionalProduct.get(); //se puede usar .get() o .orElseThrow()
            productDB.setDescription(product.getDescription());
            productDB.setName(product.getName());
            productDB.setPrice(product.getPrice());
            //Lo que hace es pasar el status de la petición
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDB));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id Para verificar que exista el producto por ID
     * @return Regresa un mensaje 200 si se elimino, sino un 404
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.deleteById(id);
        if (optionalProduct.isPresent()) {
            Product productDelete = optionalProduct.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
