package ThirthdTask;

public class WarehouseWorker extends Thread {
    private final Warehouse warehouse;
    private final int workerId;

    public WarehouseWorker(Warehouse warehouse, int workerId) {
        this.warehouse = warehouse;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        warehouse.loadCargo(workerId);
    }
}
