public class Buyer extends Thread {

    private final MachineManufacturer machineManufacturer;
    private final Integer TIME_UNTIL_THE_NEXT_PURCHASE = 1000;

    public Buyer(MachineManufacturer machineManufacturer) {
        this.machineManufacturer = machineManufacturer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            try {
                Thread.sleep(TIME_UNTIL_THE_NEXT_PURCHASE);
                synchronized (machineManufacturer.getCars()) {
                    System.out.println(Thread.currentThread().getName() + " пришел в автосалон");
                    if (!machineManufacturer.getCars().isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " уехал домой на новенькой " + machineManufacturer.getCars().remove(0));
                    } else {
                        System.out.println("Машин нет");
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}


