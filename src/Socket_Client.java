import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * Created by byuwa on 2017/4/18.
 */
public class Socket_Client {
        public static void main(String[] args) throws IOException {
            //客户端请求与本机在20006端口建立TCP连接
            Socket client = new Socket("127.0.0.1", 20006);
            client.setSoTimeout(10000);
            //获取键盘输入
            Scanner get_user_input = new Scanner(System.in);
            //获取Socket的输出流，用来发送数据到服务端
            PrintStream send_channel = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从服务端发送过来的数据
            BufferedReader recieve_channel =  new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while(flag){
                System.out.print("输入信息：");
                String str = get_user_input.nextLine();
                //发送数据到服务端
                send_channel.println(str);
                if("bye".equals(str)){
                    flag = false;
                }else{
                    try{
                        //从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
                        String echo =recieve_channel.readLine();
                        System.out.println(echo);
                    }catch(SocketTimeoutException e){
                        System.out.println("Time out, No response");
                    }
                }
            }
            get_user_input.close();
            if(client != null){
                //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
                client.close(); //只关闭socket，其关联的输入输出流也会被关闭
            }
        }
}

