import java.util.LinkedList;
import java.util.List;

/**
 * Created by byuwa on 2017/3/31.
 */
public class Test {
     public String  replaceBlank(String source_str){
         if(source_str==null || source_str.length()<1){
             return null;
         }
         List temp = new LinkedList();
         for(int i=0;i<source_str.length();i++){
             if(source_str.charAt(i)==' '){
                 temp.add('%');
                 temp.add('2');
                 temp.add('0');
             }
             else {
                 temp.add(source_str.charAt(i));
             }
         }
         String result="";
         for (int i =0;i<temp.size();i++){
             result+=temp.get(i);
         }
         return result;
     }

    public static void main(String[] args){
        String input = "We are happy.";
        Test test = new Test();
        String result = test.replaceBlank(input);
        System.out.print(result);
    }
}


