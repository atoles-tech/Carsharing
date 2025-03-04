package carsharing.server.util;

import carsharing.common.model.AdminDTO;
import carsharing.common.util.Connection;
import carsharing.common.util.Message;
import carsharing.common.util.MessageType;
import carsharing.server.db.EmployeManager;

import java.io.EOFException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ClientHandler extends Thread {

    private Connection connection;

    public ClientHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Message message = new Message(EmployeManager.getInstance().getUsers(), MessageType.ANSWER);

                connection.send(message);

                Message receiveMessage = (Message) connection.receive();
            }
        } catch (EOFException eofex) {
            System.out.println("Клиент " + connection.getSocket().getInetAddress() + " отключился");
            connection.close();
        } catch (IOException ex) {
            System.err.println("Ошибка получения сообщения: " + ex.getMessage());
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Полученый класс не найден: " + ex.getMessage());
            connection.close();
        }

    }


}
