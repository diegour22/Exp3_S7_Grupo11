package biblioteca.modelo;

import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    @Override
    public boolean add(Integer number) {
        if (isPrime(number)) {
            return super.add(number);
        } else {
            throw new IllegalArgumentException("Solo se pueden agregar números primos.");
        }
    }

    @Override
    public Integer remove(int index) {
        return super.remove(index);
    }

    public int getPrimesCount() {
        return this.size();
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
