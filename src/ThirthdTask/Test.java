package ThirthdTask;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> goods = new ArrayList<>(List.of(30, 50, 70, 40, 20, 80, 60, 90, 10, 50));

        Warehouse warehouse = new Warehouse(goods);

        WarehouseWorker worker1 = new WarehouseWorker(warehouse, 1);
        WarehouseWorker worker2 = new WarehouseWorker(warehouse, 2);
        WarehouseWorker worker3 = new WarehouseWorker(warehouse, 3);

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Все работы завершены.");
    }
}
