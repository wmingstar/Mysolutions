import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by byuwa on 2017/4/18.
 */
public class Socket_Server1 {
    private Socket con=null;
    public Socket_Server1(Socket con) {
        this.con = con;
    }

    public void service(){
        try{
            PrintStream out = new PrintStream(con.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
            boolean flag=true;
            while (flag){
                String str = input.readLine();
                if(str==null || "".equals(str)){
                    flag = false;
                }
                else {
                    System.out.print("client info"+str);
                    if("bye".equals(str)){
                        flag=false;
                    }
                    else {
                        out.print("Server echo:"+str);
                    }
                }
            }
            out.close();
            con.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        //创建一个服务端，绑定端口号，监听来自客户端的连接
        ServerSocket server = new ServerSocket(20006);
        Socket con = null;
        con = server.accept();
        System.out.print("与客户端连接成功");
        Socket_Server1 test = new Socket_Server1(con);
        test.service();
    }

}
