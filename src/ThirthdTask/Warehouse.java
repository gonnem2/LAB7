package ThirthdTask;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {

    private final List<Integer> goods; // Список товаров с весами
    private final int MAX_WEIGHT = 150; // Максимальный общий вес
    private int currentWeight = 0; // Текущий общий вес, который несут грузчики
    private final Lock lock = new ReentrantLock(); // Реентерабельная блокировка
    private final Condition canLoad = lock.newCondition(); // Условие для загрузки

    public Warehouse(List<Integer> goods) {
        this.goods = goods;
    }

    public void loadCargo(int workerId) {
        while (true) {
            lock.lock();
            try {
                if (goods.isEmpty() && currentWeight == 0) {
                    System.out.println("Грузчик " + workerId + ": все товары перенесены.");
                    canLoad.signalAll();
                    break;
                }


                while (currentWeight >= MAX_WEIGHT || (goods.isEmpty() && currentWeight > 0)) {
                    canLoad.await();
                }

                if (!goods.isEmpty()) {
                    int weight = goods.remove(0);
                    if (currentWeight + weight <= MAX_WEIGHT) {
                        currentWeight += weight;
                        System.out.println("Грузчик " + workerId + " взял товар весом " + weight + " кг. Общий текущий вес: " + currentWeight);
                    } else {
                        System.out.println("Грузчики отправляются с грузом весом " + currentWeight + " кг.");
                        currentWeight = 0;
                    }
                }

                if (currentWeight >= MAX_WEIGHT) {
                    System.out.println("Грузчики отправляются с грузом весом " + currentWeight + " кг.");
                    currentWeight = 0;
                    canLoad.signalAll();
                }


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}
