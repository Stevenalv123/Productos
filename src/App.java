import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Producto newProducto;
    public static ArrayList<Producto> productos=new ArrayList<Producto>();

    public static int Codigo;
    public static String Nombre;
    public static double Precio;
    public static double Costo;
    public static String Descrip;
    public static int i=1;

    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        LeerProductosDesdeArchivo();
        boolean key=true;

        while (key) {
            System.out.println("\n<----------Menu--------->");
            System.out.println("1. Agregar productos");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Actualizar productos");
            System.out.println("4. Eliminar productos");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    AgregarProducto();
                    break;
                case 2:
                    MostrarProducto();
                    break;
                case 3:
                    ActualizarProducto();
                    break;
                case 4:
                    EliminarProducto();
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    key=false;
                    break;
            
                default:
                System.out.println("Opcion invalida.....");
                    break;
            }
        }
    }

    public static void AgregarProducto(){
        System.out.print("Codigo: ");
        Codigo=sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        Nombre=sc.nextLine();
        System.out.print("Precio: ");
        Precio=sc.nextDouble();
        System.out.print("Costo: ");
        Costo=sc.nextDouble();
        sc.nextLine();
        System.out.print("Descripcion: ");
        Descrip=sc.nextLine();

        newProducto=new Producto(Codigo, Nombre, Precio, Costo, Descrip);
        productos.add(newProducto);
        EscribirProductos();
    }

    public static void MostrarProducto(){
            System.out.println("    Codigo       Nombre      Precio      Costo      Descripcion");
            for (Producto producto : productos) {
                System.out.println(i + ".   " + producto.codigo + "            " + producto.nombre + "      C$" + producto.precio + "       C$" + producto.getcosto() + "         " + producto.descripcion);
                i++;
        }
    }

    public static void ActualizarProducto(){
        System.out.print("Ingrese el codigo del producto a actualizar: ");
        int codigo=sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        Nombre=sc.nextLine();
        System.out.print("Ingrese el nuevo precio: ");
        Precio=sc.nextDouble();
        System.out.print("Ingrese el nuevo costo: ");
        Costo=sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la nueva descripcion: ");
        Descrip=sc.nextLine();

        newProducto=new Producto(Codigo, Nombre, Precio, Costo, Descrip);
        productos.set(codigo-1, newProducto);
        System.out.println("Producto actualizado correctamente.....");

    }

    public static void EliminarProducto(){
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        int codigo=sc.nextInt();
        productos.remove(codigo-1);
        System.out.println("Producto eliminado correctamente.....");
    }

    public static void EscribirProductos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Productos.txt"))) {
            for (Producto producto : productos) {
                writer.write(producto.toString());
                writer.newLine();
            }
            System.out.println("Producto guardado correctamente...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LeerProductosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Productos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                productos.add(Producto.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Verifique la existencia del archivo Productos.txt");
        }
    }
}
