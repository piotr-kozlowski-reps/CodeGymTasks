package pl.codegym.task.task17.task1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        while (continueWorking || !manager.getDishQueue().isEmpty()) {
            if (!manager.getDishQueue().isEmpty()) {       // Podaje przygotowane danie
                Dish dish = manager.getDishQueue().poll();
                System.out.println("Kelner dostarczył zamówienie do stolika " + dish.getTableNumber());
            } else {                                         // Przyjmuje nowe zamówienie
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Przyjęto zamówienie ze stolika " + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  // Przejście do następnego stolika
            } catch (InterruptedException ignored) {
            }
        }
    }
}
