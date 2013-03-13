/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tom
 */
public class DominoServer {
    private static ComInterface connection;
    
    public static void main(String[] args) throws RemoteException {
        connection = new ComImpl();
        DominoServer server = new DominoServer();
        server.start(80);
    }
    
    private void start(int port) throws RemoteException {
        boolean playerRdy = false;
        RemotePlayerInter playerOne = null;
        RemotePlayerInter playerTwo = null;
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("reg", connection);
        } catch (Exception e) {
            System.out.println(e);
        }      
        System.out.println("Server Ready");
        while(!playerRdy) {
            if(connection.getPlayerCount() == 1) {
                playerOne = connection.getRemote();
                playerRdy = true;
                System.out.println("Player one connected.");
            }
        }
        playerRdy = false;
        while(!playerRdy) {
            if(connection.getPlayerCount() == 2) {
                playerTwo = connection.getRemote();
                playerRdy = true;
                System.out.println("Player two connected.");
            }
        }
        try {
            startGame(playerOne, playerTwo);
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
    
    private void startGame(RemotePlayerInter playerOne, RemotePlayerInter playerTwo) throws RemoteException {
        System.out.println("Starting game...");
        DominoUI gameUI = new ServerUI(playerOne, playerTwo);
        Dominoes game = new Dominoes(gameUI, (DominoPlayer) playerOne,(DominoPlayer) playerTwo, 30, 6);
        game.play();       
        System.out.println("Game started.");
    }
    
    public void setServerMessage(String serverMessage) throws RemoteException {
        connection.setServerMessage(serverMessage);
    }
    
    public String getClientMessage() throws RemoteException {
        return connection.getClientMessage();
    }
    
    public String getClientName() throws RemoteException {
        return connection.getClientName();
    }
}
