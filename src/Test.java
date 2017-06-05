public class Test {
    public static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;
        if(root2 ==null){
            return true;
        }
        if(root1==root2){
            return true;
        }
        if(root1!=null && root2!=null){
            if(root1.value==root2.value){
                result = doseTree1HasTree2(root1,root2);
            }
            if(!result){
                result = hasSubTree(root1.left,root2);
            }
            if (!result){
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

}