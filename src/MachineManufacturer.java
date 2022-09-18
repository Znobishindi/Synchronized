import java.util.LinkedList;
import java.util.List;

public class MachineManufacturer extends Thread {

    protected final int PRODUCTION_PROCESS_TIME = 2000;
    protected final List<String> cars;
    protected final int MAX_COUNT = 10;


    public List<String> getCars() {
        return cars;
    }

    public MachineManufacturer() {
        this.cars = new LinkedList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < MAX_COUNT; i++) {
            try {
                Thread.sleep(PRODUCTION_PROCESS_TIME);
                synchronized (cars) {
                    cars.add("Лада гранта");
                    System.out.println("Автомобиль выпущен");
                    cars.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
