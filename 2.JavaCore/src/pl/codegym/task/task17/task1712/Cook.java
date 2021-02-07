package pl.codegym.task.task17.task1712;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Kucharz odpoczywa");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // Kucharz przyjmuje zamówienie od osoby z kolejki
        System.out.println(String.format("Zamówienie dla stolika %d zostanie przygotowane w %d ms", order.getTableNumber(), order.getTime()));
        Thread.sleep(order.getTime());     // Przygotowuje danie
        Dish dish = new Dish(order.getTableNumber());       // To przygotowane danie
        System.out.println(String.format("Zamówienie dla stolika %d jest gotowe", dish.getTableNumber()));
        manager.getDishQueue().add(dish);
    }
}
