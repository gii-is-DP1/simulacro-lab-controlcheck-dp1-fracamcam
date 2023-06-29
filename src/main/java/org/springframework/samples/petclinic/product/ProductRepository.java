package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<Product,String> {
    List<Product> findAll();

    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
    @Query("SELECT p FROM Product p WHERE p.price < :n")
    List<Product> findByPriceLessThan(@Param("n")double n);

    @Query("Select pt FROM ProductType pt WHERE pt.name = :typeName")
    ProductType findProductTypeByName(@Param("typeName")String typeName);
}