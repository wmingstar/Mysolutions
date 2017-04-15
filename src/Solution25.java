import java.util.ArrayList;
import java.util.List;

/**
 * Created by byuwa on 2017/3/27.
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶节点所经过的结点形成的一条路径。
 */
public class Solution25 {
    public static void findPath(BinaryTreeNode root,int expect_sum){
        if(root == null){
            return;
        }
        List<BinaryTreeNode> path = new ArrayList<BinaryTreeNode>();
        findPath(root,expect_sum,0,path);
    }

    public static void findPath(BinaryTreeNode root,int expect_sum,int cur_sum,List path ){
        if(root == null){
            return;
        }
        cur_sum += root.value;
        path.add(root);
        if(cur_sum<expect_sum){
            findPath(root.left,expect_sum,cur_sum,path);
            findPath(root.right,expect_sum,cur_sum,path);
        }
        else if(cur_sum==expect_sum){
            if(root.left == null && root.right==null){
                for(int i=0;i<path.size();i++){
                    BinaryTreeNode temp = (BinaryTreeNode) path.get(i);
                    System.out.print(temp.value);
                }
            }
        }
        path.remove(path.size()-1);
    }

}
