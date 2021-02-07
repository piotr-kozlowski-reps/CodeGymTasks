package com.codegym.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Work up a sweat!

*/

//Use the superclass's method in a finally block.



//4. The thread should be interrupted no matter what, even if an exception is thrown while closing resources.

public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    // 2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try{
            in.close();
            socket.close();
        } catch (IOException ignored){
        } finally {
            super.interrupt();
        }

    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        // Process the buffer here
                    }
                }
            }
        } catch (IOException ignored) {}
    }

    public static void main(String[] args) {
    }
}
