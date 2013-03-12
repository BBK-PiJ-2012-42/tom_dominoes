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
    
    private static void wait (int k) {
        long time0, time1;
        time0 = System.currentTimeMillis();
        do{
            time1 = System.currentTimeMillis();
        } while ((time1 - time0) < k*1000);
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
            while(!"0".equals(mes)) {
                System.out.println("FROM CLIENT// " + mes);
                wait(2);
                mes = server.getClientMessage();
                if(mes != null) {
                    server.setServerMessage("Recieved: "+ mes);
                }
            }
            System.out.println("Server no longer listening.");
        } else {
            Client client = new Client();
            //client.connect();
            System.out.println("Client connected...");
            String mes = "Test Message!";
            System.out.println("Send: "+mes);
            client.sendMessage(mes);
            String res = null;
            int i = 0;
            while(!"0".equals(mes)) {
                if(i > 5) {
                    mes = Integer.toString(i)+" secs now..."; 
                }
                res = client.sendMessage(mes);
                System.out.println("FROM SERVER// "+res);
                wait(2);
                i++;
            }

            
        }
        
    }
    
}
