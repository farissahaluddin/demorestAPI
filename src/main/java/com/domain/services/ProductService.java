package com.domain.services;

import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import com.domain.models.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product create(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public  void removeId(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }

    @PostMapping("/{id}")
    public void addSuppliers(Supplier supplier, Long productID){
        Product product = findOne(productID);

        if (product == null){
            throw new RuntimeException("ID: "+productID+" ora ketemu");
        }
        product.getSuppliers().add(supplier);
        create(product);
    }
}
