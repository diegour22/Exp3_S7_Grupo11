package biblioteca.hilos;

import biblioteca.modelo.PrimesList;

public class PrimeRemover extends Thread {
    private PrimesList lista;

    public PrimeRemover(PrimesList lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while (!lista.isEmpty()) {
            try {
                Integer eliminado = lista.remove(0);
                System.out.println("Eliminado: " + eliminado);
                Thread.sleep(100); // simula carga
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Intento de eliminar de lista vacía.");
            } catch (InterruptedException e) {
                System.out.println("Remover interrumpido.");
            }
        }
    }
}
