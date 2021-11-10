import java.net.*;  
import java.io.*; 
import java.util.Scanner;

public class chatClient extends Thread {
    
    private int port2;
    private String ip;

    public chatClient(String ip,int port2){
        this.port2 = port2;
        this.ip = ip;
    }

    public void run(){
        try {
            System.out.println("runClient");
            String str="";
            boolean isConnected = false;
            Socket s = new Socket();
            

            while (!isConnected){
                try{
                    s = null;
                    //SocketAddress socketAddress = new InetSocketAddress("localhost", port2);
                    s = new Socket(ip, port2);
                    //s.connect(socketAddress);
                    isConnected = true;
                     
                }
                catch (Exception e){
                    isConnected = false;
                    continue;
                }
            }

        //ServerSocket ss=new ServerSocket(3333);  
        //Socket s=ss.accept();  
        //Socket s=new Socket("localhost",3333);  
        //DataInputStream din=new DataInputStream(s.getInputStream());  
         
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
          
        while(!str.equals("stop")){  
            str=br.readLine();  
            dout.writeUTF(str);  
            dout.flush();  
            //str2=din.readUTF();  
            //System.out.println("Server says: "+str2);  
        }  
  
        dout.close();  
        s.close();  
        }
        catch (Exception e){
            System.out.println(e);
        }
        }  
    }
