import java.util.ArrayList;
import java.util.List;

/**
 * Created by byuwa on 2017/3/20.
 *
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.
 */
public class Solution4 {
    public static void replaceString(String input){
        if(input.length()<1){
            return;
        }
        List str_list = new ArrayList<Character>();
        for(int i =0;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch ==' '){
                str_list.add('%');
                str_list.add('2');
                str_list.add('0');
            }
            else{
                str_list.add(ch);
            }
        }
        String result ="";
        for(int i =0;i<str_list.size();i++) {
            result += str_list.get(i);
        }
        System.out.print(result);
    }

    public static void main(String[] args){
        String input = "We are happy.";
        Solution4.replaceString(input);
    }

}
