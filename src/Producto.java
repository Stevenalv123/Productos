public class Producto {
    public int codigo;
    public String nombre;
    public double precio;
    private double costo;
    public String descripcion;

    public Producto(int codigo, String nombre, double precio, double costo, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public double getcosto(){
        return costo;
    }

    public void setcosto(double costo){
        this.costo=costo;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + precio + "," + costo + "," + descripcion;
    }
    
    public static Producto fromString(String str) {
        String[] parts = str.split(",");
        int codigo = Integer.parseInt(parts[0]);
        String nombre = parts[1];
        double precio = Double.parseDouble(parts[2]);
        double costo = Double.parseDouble(parts[3]);
        String descripcion = parts[4];
        return new Producto(codigo, nombre, precio, costo, descripcion);
    }
}
