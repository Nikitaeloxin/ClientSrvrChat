import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*; 

public class App {
    public static void main(String[] args) throws Exception {
        
        int port1 = Integer.parseInt(args[0]);
        int port2 = Integer.parseInt(args[1]);
        chatClient chatCl = null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String trmStrIP = "";
        
        chatSrvr chatSrv =new chatSrvr(port1);
        chatSrv.start();

        System.out.println("Enter client IP");
            trmStrIP = br.readLine();
            
        if (trmStrIP.isEmpty()){
            while (chatSrv.GetRemoteIP().isEmpty()){
               TimeUnit.SECONDS.sleep(1);     
                
            }
            chatCl = new chatClient(chatSrv.GetRemoteIP(),port2);    
            
        }
        else{
            chatCl = new chatClient(trmStrIP,port2); 
        }

        System.out.println("Starting MT Chat App...");
        
        
        
        chatCl.start();

        
    }
}

