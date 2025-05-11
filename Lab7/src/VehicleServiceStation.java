import java.util.concurrent.Semaphore;

public class VehicleServiceStation {
    private static final int QUEUES_COUNT = 6;
    private static final int PARKING_CAPACITY = 10;
    private static final int TOTAL_CARS = 30;

    public static void main(String[] args) throws InterruptedException {
        Semaphore parkingLot = new Semaphore(PARKING_CAPACITY, true);
        Thread[] threads = new Thread[TOTAL_CARS];
        
        System.out.println("Пункт техобслуживания открыт. Очередей: " + QUEUES_COUNT);

        for (int i = 0; i < TOTAL_CARS; i++) {
            int carNumber = i + 1;
            int queueNumber = i % QUEUES_COUNT + 1;
            
            threads[i] = new Thread(() -> {
                try {
                    System.out.printf("Машина %d в очереди %d: прием документов...\n",
                            carNumber, queueNumber);
                    Thread.sleep(100 + (int)(Math.random() * 400));

                    System.out.printf("Машина %d в очереди %d: ожидание места на стоянке...\n",
                            carNumber, queueNumber);
                    parkingLot.acquire();

                    System.out.printf("Машина %d в очереди %d: заехала на стоянку. Свободных мест: %d\n",
                            carNumber, queueNumber, parkingLot.availablePermits());

                    Thread.sleep(1000 + (int)(Math.random() * 1000));

                    System.out.printf("Машина %d в очереди %d: осмотр завершен, покидает стоянку\n",
                            carNumber, queueNumber);
                    parkingLot.release();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все машины обслужены. Пункт техобслуживания закрывается.");
    }
}