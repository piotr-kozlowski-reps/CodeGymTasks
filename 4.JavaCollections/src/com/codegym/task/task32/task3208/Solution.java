package com.codegym.task.task32.task3208;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI (part 2)

*/

public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {

            Remote stubCat;
            Remote stubDog;
            try {
                registry = LocateRegistry.createRegistry(2099);
                final Animal cat = new Cat("cat");
                final Animal dog = new Dog("dog");

                stubCat = UnicastRemoteObject.exportObject(cat, 2099);
                stubDog = UnicastRemoteObject.exportObject(dog, 2099);

                registry.bind("cat", stubCat);
                registry.bind("dog", stubDog);

            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    });


    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
