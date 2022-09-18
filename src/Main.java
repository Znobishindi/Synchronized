public class Main {
    public static void main(String[] args) {
        final MachineManufacturer machineManufacturer = new MachineManufacturer();
        ThreadGroup threadGroup = new ThreadGroup("Группа покупателей");

        Buyer buyer = new Buyer(machineManufacturer);
        Runnable buy = buyer;
        new Thread(threadGroup, buy, "Покупатель 1").start();
        new Thread(threadGroup, buy, "Покупатель 2").start();
        new Thread(threadGroup, buy, "Покупатель 3").start();
        new Thread(threadGroup, buy, "Покупатель 4").start();


        machineManufacturer.start();

        if (!machineManufacturer.isAlive()) {
            threadGroup.interrupt();
        }
    }

    }



