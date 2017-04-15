import java.util.HashMap;
import java.util.Map;

/**
 * Created by byuwa on 2017/3/30.
 *
 * 在字符串中找出第一个只出现一次的字符。
 */
public class Solution35 {
    public static void findChar(String str){
        if(str==null || str.length()<1){
            return;
        }
        Map<Character,Integer> dic = new HashMap<Character,Integer>();
        char temp = ' ';
        for(int i=0;i< str.length();i++) {
            temp = str.charAt(i);
            if (dic.containsKey(temp)) {
                dic.put(temp, 2);
            } else {
                dic.put(temp, 1);
            }
        }
        int time = 0;
        for(int i=0;i<str.length();i++){
            temp = str.charAt(i);
            time = dic.get(temp);
            if(time ==1){
                System.out.print(temp);
                return;
            }
        }
        System.out.print("no");

    }

    public static void main(String[] args){
        Solution35.findChar("abaccdef");

        int[] tses ={1,2,3};
    }
}
