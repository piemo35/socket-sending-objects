import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void  runServer() throws IOException, ClassNotFoundException{

        // istanza del socket
        ServerSocket ss = new ServerSocket(Utils.port);
        Socket socket = ss.accept();



        // RICEVO OGGETTO DAL CLIENT

        // istanza dell'oggetto in input dal client
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        // memorizzo l'oggetto in arrivo dal client in una variabile
        Message m = (Message) is.readObject();

        //modifica del contenuto dell'oggetto
        Utils.moltiplica(m);



        // INVIO OGGETTO AL CLIENT

        // istanza dell'oggetto in output verso il client
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        // invio dell'oggetto modificato al client
        os.writeObject(m);

        // chiusura del socket
        socket.close();
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new Server().runServer();
    }
}
