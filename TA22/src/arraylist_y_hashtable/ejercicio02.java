package arraylist_y_hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio02 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> carrito = new ArrayList<>();

        while (true) {
            System.out.print("Ingrese el precio del artículo (o 0 para finalizar la compra): ");
            double precio = Double.parseDouble(scanner.nextLine());

            if (precio == 0) {
                break;
            }

            carrito.add(precio);
        }

        double iva = 0.21;  
        System.out.print("¿El cliente tiene IVA reducido (4%)? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            iva = 0.04;
        }

        double precioTotalBruto = 0;
        for (double precio : carrito) {
            precioTotalBruto += precio;
        }

        double precioTotalConIva = precioTotalBruto * (1 + iva);

        System.out.println("\nResumen de compra:");
        System.out.println("IVA aplicado: " + (iva * 100) + "%");
        System.out.println("Precio total bruto: " + precioTotalBruto);
        System.out.println("Precio total + IVA: " + precioTotalConIva);

        System.out.print("Número de artículos comprados: " + carrito.size());

        System.out.print("\nIngrese la cantidad pagada por el cliente: ");
        double cantidadPagada = Double.parseDouble(scanner.nextLine());

        double cambio = cantidadPagada - precioTotalConIva;
        System.out.println("Cambio a devolver al cliente: " + cambio);
    }
}