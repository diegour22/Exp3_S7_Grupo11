package biblioteca.app;

import biblioteca.hilos.PrimeAdder;
import biblioteca.hilos.PrimeRemover;
import biblioteca.modelo.PrimesList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrimesList listaPrimos = new PrimesList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos números quieres ingresar? ");
        int cantidad = scanner.nextInt();
        int[] numeros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        PrimeAdder adder = new PrimeAdder(listaPrimos, numeros);
        PrimeRemover remover = new PrimeRemover(listaPrimos);

        adder.start();

        try {
            adder.join(); // espera que termine de agregar
        } catch (InterruptedException e) {
            System.out.println("Error esperando al hilo adder.");
        }

        remover.start();
    }
}
