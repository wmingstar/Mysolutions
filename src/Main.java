import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int k=in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();

        }

        for(int i=0;i<k;i++){
            int[] temp = nums.clone();
            for(int j = 0;j<n;j++){
                if(j==n-1){
                    nums[j]=temp[j]+temp[0];
                }
                else{
                    nums[j]=temp[j]+temp[j+1];
                }
                if(nums[j]>100){
                    nums[j]=nums[j]%100;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
        System.out.format("%d%n%d",2,2);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }
}