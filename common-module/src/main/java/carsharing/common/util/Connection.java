package carsharing.common.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    private Socket socket;
    private ObjectInputStream inp;
    private ObjectOutputStream out;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        inp = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message obj) throws IOException{
        out.writeObject(obj);
    }

    public Object receive() throws ClassNotFoundException, IOException{
        return inp.readObject();
    }

    public void close() {
        try {
            socket.close();
            inp.close();
            out.close();
        }catch (IOException ignored){}
    }

    public Socket getSocket() {
        return socket;
    }
}
