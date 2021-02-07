package com.codegym.task.task21.task2101;

/* 
Determine the network address

*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddressAchieved = new byte[4];

        for (int i = 0; i < ip.length; i++){
            byte result = (byte) (ip[i] &  mask[i]);
            netAddressAchieved[i] = result;
        }

        return netAddressAchieved;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++){
            int temporartByteIntoInt = (int) bytes[i];
            String temporaryByteAsSubString = String.valueOf(Integer.toBinaryString(temporartByteIntoInt));

            if (temporaryByteAsSubString.length() < 8) {
                for (int j = temporaryByteAsSubString.length() - 8; j < 0; j++){
                    temporaryByteAsSubString = "0" + temporaryByteAsSubString;
                }
            }

            temporaryByteAsSubString = temporaryByteAsSubString.substring(temporaryByteAsSubString.length() - 8,temporaryByteAsSubString.length());

            if (i < (bytes.length - 1)) System.out.print(temporaryByteAsSubString + " ");
            else System.out.print(temporaryByteAsSubString + "\n");
        }
    }
}
