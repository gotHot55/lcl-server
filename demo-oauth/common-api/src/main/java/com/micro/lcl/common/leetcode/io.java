package com.micro.lcl.common.leetcode;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2414:57
 */
public class io {
}

class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date()+": hello").getBytes());
                        Thread.sleep(2000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            } catch (Exception e) {

            }

        }).start();
    }
}

class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(()->{
            while (true) {
                try {
                    Socket accept = serverSocket.accept();
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = accept.getInputStream();
                            while (!((len=inputStream.read(data)) != -1)) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
