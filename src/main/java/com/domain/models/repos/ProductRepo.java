package com.domain.models.repos;

import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;
import java.util.List;


public interface ProductRepo extends CrudRepository<Product, Long>  {

    List<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name =:name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("select p from Product p where p.name like :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

    @Query("select p from Product p where p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);


    @Query("select p from Product p where :supplier member of p.suppliers")
    public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);

}
