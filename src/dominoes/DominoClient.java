/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import dominoes.players.LocalPlayer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tom
 */
public class DominoClient {
    private static ComInterface connection;
    private static UIControl control;
    
    public static void main(String[] args) throws RemoteException {
        control = new ConsoleControl();
        DominoPlayer player = new LocalPlayer("Bill", control);

        connection = new ComImpl();
        DominoClient client = new DominoClient();
        client.start(80, "0.0.0.0", player);
    }
    
    private void start(int port, String ipAddress, DominoPlayer player) throws RemoteException {
        try {
            System.out.println("Connecting to server.");
            RemotePlayerInter remotePlayer = new RemotePlayerImpl(player, control);
            UnicastRemoteObject.exportObject(remotePlayer, 8080);
            Registry myRegistry = LocateRegistry.getRegistry(ipAddress, port);
            connection = (ComInterface) myRegistry.lookup("reg");
            connection.passRemote(remotePlayer);
            System.out.println(connection.getPlayerCount());
            //String response = connection.communicate(name, clientMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
