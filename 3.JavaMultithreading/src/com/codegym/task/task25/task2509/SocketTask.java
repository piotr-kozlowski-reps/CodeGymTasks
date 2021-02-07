package com.codegym.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        try{
            socket.close();
        } catch (IOException ignored){}
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                // Close all resources here using the proper SocketTask method
                // Call the superclass's method in a finally block
                try{
                    socket.close();
                }catch (IOException ignored){
                } finally {
                    super.cancel(true);
                }
                return false;
            }
        };
    }
}


//2. Implement the logic of the SocketTask class's cancel() method.
//3. Implement the cancel() method's logic for a local class inside the SocketTask class's newTask method.

//2. The SocketTask class's cancel() method must close the resources used by the class.
//3. The cancel() method for the local class inside the newTask method must close the SocketTask resources and call the parent class's cancel() method.
//4. The parent class's method must be called even if an exception is thrown while closing resources.