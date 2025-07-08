package biblioteca.hilos;

import biblioteca.modelo.PrimesList;

public class PrimeAdder extends Thread {
    private PrimesList lista;
    private int[] numeros;

    public PrimeAdder(PrimesList lista, int[] numeros) {
        this.lista = lista;
        this.numeros = numeros;
    }

    @Override
    public void run() {
        for (int n : numeros) {
            try {
                lista.add(n);
                System.out.println("Agregado: " + n);
            } catch (IllegalArgumentException e) {
                System.out.println("No es primo, no se agrega: " + n);
                System.out.println("Motivo: " + e.getMessage());
            }
        }
    }
}
