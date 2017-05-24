import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by byuwa on 2017/4/18.
 */
public class Socket_Server  implements Runnable {
    private Socket con=null;
    public Socket_Server(Socket con) {
        this.con = con;
    }
    @Override
    public void run(){
        try{
            //获取socket的输出流，向客户端发送数据
            PrintStream send_channel = new PrintStream(con.getOutputStream());
            //获取socket的输入流，获取客户端发送过来的数据
            BufferedReader recieve_channel = new BufferedReader(new InputStreamReader(con.getInputStream()));
            boolean flag=true;
            while (flag){
                String client_message = recieve_channel.readLine();
                if(client_message==null || "".equals(client_message)){
                    flag = false;
                }
                else {
                    System.out.print("client info"+client_message);
                    if("bye".equals(client_message)){
                        flag=false;
                    }
                    else {
                        send_channel.print("Server echo:"+client_message);
                    }
                }
            }
            send_channel.close();
            con.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        //创建一个服务端，绑定端口号，监听来自客户端的连接
        ServerSocket server = new ServerSocket(2017);
        Socket connect = null;
        boolean flag = true;
        while (flag) {
            //接收来自客户端的连接
            connect  = server.accept();
            System.out.print("与客户端连接成功");
            //为新建立的连接，创建一个单独的线程
            new Thread(new Socket_Server( connect )).start();
            // 当子线程全部结束时，flag = false;
            // 如何判断子线程是否全部结束
        }
        server.close();
    }

}
