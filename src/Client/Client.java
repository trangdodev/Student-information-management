package Client;

import Common.Response_Rating;
import studentma.RequestSendToServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static Common.Constants.HOST;
import static Common.Constants.PORT;
import Lookup.LookupScores;
import Rating.StudentRanking;
import studentma.RequestSendToServer_Rating;
import java.util.logging.Level;
import java.util.logging.Logger;

// singleton and observer pattern and socket
public class Client implements SubjectNotify {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    private static Client instance;
    private List<ObserverNotify> observerNotifyList = new ArrayList<>();

    private Client() {

    }

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        instance.initListen();
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            new Thread(runnable).start();
        }
        return instance;
    }

    private void initListen() throws IOException {
        try {
            socket = new Socket(HOST, PORT);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                System.out.println("Client is running");

                try {
                    Object object = ois.readObject();
                    if (object instanceof Response_Rating) {
                        Response_Rating response = (Response_Rating) object;
                        for (ObserverNotify observerNotify : observerNotifyList) {
                            System.out.println(observerNotify);
                            if(observerNotify instanceof LookupScores){
                                System.out.println("lockup");
                                 observerNotify.fetchData(response);
                            }
                             if(observerNotify instanceof StudentRanking){
                                 System.out.println("StudentRanking");

                                 observerNotify.fetchData(response);
                                    
                            }
                        }

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Server is not running");
            e.printStackTrace();
        } finally {
                ois.close();
                oos.close();
                socket.close();

        }

    }

    public boolean sendRequest(RequestSendToServer requestSendToServer) {
        System.out.println(requestSendToServer);
        try {
            oos.writeObject(requestSendToServer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    @Override
    public void attach(ObserverNotify observer) {
        this.observerNotifyList.add(observer);
        System.out.println(this.observerNotifyList);

    }

    @Override
    public void detach(ObserverNotify observer) {
        this.observerNotifyList.remove(observer);
    }

    

}
