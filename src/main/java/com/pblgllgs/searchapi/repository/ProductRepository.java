package com.pblgllgs.searchapi.repository;

import com.pblgllgs.searchapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(
            "SELECT p " +
            "FROM Product p " +
            "WHERE  p.name LIKE CONCAT('%',:query, '%') OR p.description LIKE CONCAT('%',:query, '%')")
    Optional<List<Product>> searchProductsBy(String query);

    @Query(
            value = "SELECT *" +
                    " FROM products as p" +
                    " WHERE  p.name LIKE CONCAT('%',:query, '%') OR p.description LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    Optional<List<Product>> searchProductsBySQL(String query);
}
