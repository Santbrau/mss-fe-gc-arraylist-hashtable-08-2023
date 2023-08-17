package arraylist_y_hashtable;
import java.util.*;

public class ejercicio01 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> notasMedias = new HashMap<>();

        while (true) {
            System.out.print("Ingrese el nombre del alumno (o 'salir' para terminar): ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese la cantidad de notas: ");
            int cantidadNotas = Integer.parseInt(scanner.nextLine());

            double sumaNotas = 0;
            for (int i = 1; i <= cantidadNotas; i++) {
                System.out.print("Ingrese la nota " + i + ": ");
                double nota = Double.parseDouble(scanner.nextLine());
                sumaNotas += nota;
            }

            double notaMedia = sumaNotas / cantidadNotas;
            notasMedias.put(nombre, notaMedia);
        }

        System.out.println("\nNotas medias de los alumnos:");
        for (Map.Entry<String, Double> entry : notasMedias.entrySet()) {
            System.out.println("Alumno: " + entry.getKey() + ", Nota media: " + entry.getValue());
        }
    }
}

