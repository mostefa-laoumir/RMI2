import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main(String[] args) {
        try {
            RemoteImpl remoteImpl = new RemoteImpl();
            IRemote objet = (IRemote) UnicastRemoteObject.exportObject(remoteImpl, 22222);
            LocateRegistry.createRegistry(22222).bind("objet-calculatrice", objet);
            while (1==1) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}