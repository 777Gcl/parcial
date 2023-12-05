package modelproduct;

import java.io.Serializable;

public class Product implements Serializable {
    private String nombre;
    private String descripcion;
    private String tipo;
    private double precio;

    
    public Product() {
       
    }
    public Product(String nombre, String descripcion, String tipo, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precio = precio;
	}

 

   

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	 @Override
	    public String toString() {
	        return "Nombre: " + nombre + ", Descripci�n: " + descripcion + ", Tipo: " + tipo + ", Precio: " + precio;
	    }
}
