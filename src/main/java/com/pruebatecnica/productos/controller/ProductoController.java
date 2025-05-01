package com.pruebatecnica.productos.controller;

import com.pruebatecnica.productos.model.Producto;
import com.pruebatecnica.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Endpoint GET: Obtener todos los productos
    @GetMapping
    public List<Producto> buscarProductos(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean inStock) {
        if (name == null && category == null && inStock == null) {
            return productoRepository.findAll();
        }
        return productoRepository.findByQueryParams(name, category, inStock);
    }

    // Example of another method with a unique path
    @GetMapping("/all")
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // Endpoint POST: Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.ok(nuevoProducto);
    }
}