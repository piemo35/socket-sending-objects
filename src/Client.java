import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

        public static void runClient() throws IOException, ClassNotFoundException{

        // istanza del socket
        Socket socket = new Socket("localhost", 4444);


        // INVIO AL SERVER

        // istanza dell'oggetto OutputStream per inviare dati al server
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        // istanza dell'oggetto da inviare al server
        Message message = new Message(4, 3);

        // invio dell'oggetto al server
        os.writeObject(message);



        // RICEZIONE DAL SERVER

        // istanza dell'oggetto InputStream per ricevere dati dal server
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        // istanza dell'oggetto modificato ricevuto dal server + memorizzazione in variabile returnMessage
        Message returnMessage = (Message) is.readObject();

        System.out.println("return Message is = " + returnMessage);

        // chiusura del socket
        socket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runClient();
    }
}
