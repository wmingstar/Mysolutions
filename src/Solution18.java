/**
 * Created by byuwa on 2017/3/25.
 *
 * 输入两棵树 A 和 B，判断 B 是不是 A 的子结构
 *
 */
public class Solution18 {
    public static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;
        if(root1 == root2){
            return true;
        }
        if(root2==null){
            return true;
        }
        if(root1!=null && root2!=null){
            if(root1.value == root2.value){
                result = doseTree1HasTree2(root1,root2);
            }
            if(!result){
                result = hasSubTree(root1.left,root2);
            }
            if(!result){
                result = hasSubTree(root1.right,root2);
            }
        }
        return result;

    }

    public static boolean doseTree1HasTree2(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.value!=root2.value){
            return false;
        }
        return doseTree1HasTree2(root1.left,root2.left) && doseTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
    }


}
