package carsharing.client;

import carsharing.common.model.AdminDTO;
import carsharing.common.util.Connection;
import carsharing.common.util.Message;
import carsharing.common.util.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {

            Connection connection = new Connection(socket);
            Message message = (Message) connection.receive();

            if(message.getData() instanceof List list){
                list.stream().forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при подключении к серверу: " + e.getMessage());
        } catch (ClassNotFoundException e){
            System.err.println("Получен неизвестный класс: " + e.getMessage());
        }
    }
}
