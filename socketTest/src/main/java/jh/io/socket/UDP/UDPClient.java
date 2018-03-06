package jh.io.socket.UDP;

import java.io.IOException;
import java.net.*;

/**
 * Created by 17020751 on 2018/3/5.
 */
public class UDPClient {
    private static final int TIMEOUT = 3000; // Resend timeout (milliseconds)
    private static final int MAXTRIES = 5; // Maximum retransmissions

    public static void main(String[] args) throws IOException {
        String str_send = "Hello UDPserver";
        byte[] bytesToSend = new byte[1024];
        bytesToSend = str_send.getBytes();
        InetAddress loc = InetAddress.getLocalHost();

        DatagramSocket socket = new DatagramSocket(9000);
        socket.setSoTimeout(TIMEOUT); // Maximum receive blocking time (milliseconds)
        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, // Sending packet
                 bytesToSend.length, loc,3000);

        DatagramPacket receivePacket =  new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);

        socket.send(sendPacket); // Send the echo string
        socket.receive(receivePacket); // Attempt echo reply reception
        System.out.println("Received: " + new String(receivePacket.getData()));
    }
}
