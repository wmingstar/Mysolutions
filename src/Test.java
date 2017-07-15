import java.io.File;
import java.io.IOException;

public class Test {
    public static String test(){
        File a = new File(".");
        String name = "";
        try {
            name = a.getCanonicalPath().toString();
            System.out.print(name);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }
    public static  void  main(String[] args) {
        String name = Test.test();
        System.out.print(name);
    }
}