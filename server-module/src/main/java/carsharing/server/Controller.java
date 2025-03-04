package carsharing.server;

import carsharing.common.model.CarTypeDTO;
import carsharing.common.util.Connection;
import carsharing.server.db.EmployeeManager;
import carsharing.server.model.*;
import carsharing.server.util.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Controller {

    public final Integer PORT = 12345;

    public void run() {

        EmployeeManager.init();


        Car car = EmployeeManager.getInstance().getCarById(1);

        EmployeeManager.getInstance().saveServiceRecord(new ServiceRecord(car,LocalDateTime.now(),100.,"Замена масла и фильтров"));

        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("Сервер запущен, порт: " + PORT);

            while (true) {

                Socket socket = server.accept();
                Connection clientConnection = new Connection(socket);
                new ClientHandler(clientConnection).start();

                System.out.println("Клиент под адресом " + socket.getInetAddress() + " подключился");

            }

        } catch (IOException exception) {
            System.err.println("Ошибка сервера" + exception.getMessage());
        }

    }



}
