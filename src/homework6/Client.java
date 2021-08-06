package homework6;
//1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения,
// как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать "Привет",
// нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
// Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
// Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать
//
//        Разобраться с кодом с занятия, он является фундаментом проекта-чата
//        ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиентов

import java.net.*;
import java.io.*;


public class Client {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private static final int PORT = 8189;
    public Client(String address, int port) {

        try {

            socket = new Socket(address, port);
            System.out.println("Клиент подсоединился");

            new Thread(() -> {

                try {
                    input = new DataInputStream(System.in);
                    out = new DataOutputStream(socket.getOutputStream());
                    String line = "";

                    while (!line.equals("/end")) {
                        try            {
                            line = input.readLine();
                            out.writeUTF(line);
                        }
                        catch(IOException i) {
                            System.out.println(i);
                        }
                    }

                    input.close();
                    out.close();
                    socket.close();
                    System.out.println("Соединение закрыто");

                } catch(IOException u) {
                    System.out.println(u);
                }
            }).start();

            new Thread(() -> {
                try {
                    in = new DataInputStream(socket.getInputStream());
                    String line = "";

                    while (!line.equals("/end")) {
                        try {
                            line = in.readUTF();
                            System.out.println(line);
                        } catch (IOException i) {
                            System.out.println(i);
                        }
                    }

                    in.close();
                    socket.close();
                    System.out.println("Соединение закрыто");

                } catch(IOException i) {
                    System.out.println(i);
                }
            }).start();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("192.168.1.136",PORT);

    }
}
