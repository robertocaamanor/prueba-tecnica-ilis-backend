package com.pruebatecnica.productos.repository;

import com.pruebatecnica.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM producto p " +
            "WHERE (:name IS NULL OR LOWER(public.UNACCENT(p.nombre::TEXT)) LIKE LOWER(public.UNACCENT(CONCAT('%', :name, '%')::TEXT))) " +
            "AND (:category IS NULL OR LOWER(public.UNACCENT(p.categoria::TEXT)) LIKE LOWER(public.UNACCENT(CONCAT('%', :category, '%')::TEXT))) " +
            "AND (:inStock IS NULL OR (:inStock = TRUE AND p.stock_disponible > 0) OR (:inStock = FALSE AND p.stock_disponible = 0))",
            nativeQuery = true)
    List<Producto> findByQueryParams(@Param("name") String name,
                                     @Param("category") String category,
                                     @Param("inStock") Boolean inStock);
}