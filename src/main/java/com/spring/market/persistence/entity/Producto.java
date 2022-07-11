package com.spring.market.persistence.entity;

import javax.persistence.*;

@Entity//anotacion que indica a java que mapea a base de datos
@Table(name = "productos")//para el nombre de la tabla ya que es diferente al nombre de la clase
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para generar id de forma automatica
    //como el atributo se llama diferente a la tabla se le hace referencia con la anotacion column
    @Column(name = "id_producto")
    private Integer idProducto;
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //Relacion entre tablas Producto y Categoria
    @ManyToOne(fetch = FetchType.LAZY)//anotacion para relacionar (de muchos a uno)
    @JoinColumn(name = "id_categoria",insertable=false, updatable=false) //sirve para recuperar a que categoria pertenece cada producto(no para crear categorias)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
