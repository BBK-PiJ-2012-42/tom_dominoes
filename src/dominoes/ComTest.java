package dominoes;

import java.rmi.RemoteException;

/**
 *
 * @author tom
 */
public class ComTest {
    
    public static void main(String[] args) throws RemoteException {
        ComTest test = new ComTest();
        test.launch();
    }
        
    private void launch() throws RemoteException {
        ConsoleControl console = new ConsoleControl();
        System.out.println("(0)Server or (1)Client?");
        if(console.getInt() == 0) {
            Server server = new Server();
            server.start();
            System.out.println("Started server...");
            server.setServerMessage("rdy");
            String mes = server.getClientMessage();
            while(mes != "0") {
                if(mes != null) {
                    System.out.println(server.getClientMessage());
                }
                
            }
            System.out.println("Server no longer listening.");
        } else {
            Client client = new Client();
            client.connect();
            System.out.println("Client connected...");
            System.out.println("Send:");
            String mes = Integer.toString(console.getInt());
            client.sendMessage(mes);
            
        }
        
    }
    
}
