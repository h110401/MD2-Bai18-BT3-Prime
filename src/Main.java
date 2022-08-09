public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimized = new OptimizedPrimeFactorization();

        Thread lazyThread = new Thread(lazy);
        Thread optimizedThread = new Thread(optimized);

        optimizedThread.start();
        lazyThread.start();
    }
}

class LazyPrimeFactorization implements Runnable {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int n = 1000;
        int count = 0;
        int N = 2;
        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println("LazyThread:" + N);
                count++;
            }
            N++;
        }
        long end = System.currentTimeMillis();
        System.out.println("LazyThread time:" + (end - start));
    }
}

class OptimizedPrimeFactorization implements Runnable {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int n = 1000;
        int count = 0;
        int N = 2;
        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println("OptimizedThread:" + N);
                count++;
            }
            N++;
        }
        long end = System.currentTimeMillis();
        System.out.println("OptimizedThread time:" + (end - start));
    }
}
