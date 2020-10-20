package Models;

public class Oficios {
    private int id_oficio;
    private String nombre;
    private String categoria;
    private double precio;

    public int getId_oficio() {
        return id_oficio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId_oficio(int id_oficio) {
        this.id_oficio = id_oficio;
    }
}
