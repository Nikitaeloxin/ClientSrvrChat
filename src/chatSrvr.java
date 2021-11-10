import java.net.*;  
import java.io.*;

public class chatSrvr extends Thread {
    private int port1;
    Boolean isConnected = false;
    String remoteIP;

    public chatSrvr(int port1){
        this.port1 = port1;
    }


    public String GetRemoteIP(){
        return this.remoteIP;
    }
    public void run(){
        System.out.println("runSrvr");
        try{
            ServerSocket ss=new ServerSocket(port1);  
        Socket s=ss.accept();
        this.remoteIP = ((InetSocketAddress)s.getRemoteSocketAddress()).getAddress().toString().substring(1);
        DataInputStream din=new DataInputStream(s.getInputStream());  
       // DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
       // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        this.isConnected =true;
        String str="";  
        while(!str.equals("stop")){ 
         
        str=din.readUTF();  
        System.out.println("client says: "+str);  
        //str2=br.readLine();  
        //dout.writeUTF(str2);  
        //dout.flush();
        
        
        }  
        din.close();  
        s.close();  
        ss.close();  
        }
        catch(Exception e){
            System.out.println(e);
        }  
        }
        
    }


