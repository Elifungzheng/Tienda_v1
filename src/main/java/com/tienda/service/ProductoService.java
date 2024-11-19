package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoService {
    
    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);
 
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta una nueva producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    
}