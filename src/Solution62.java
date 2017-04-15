import java.util.LinkedList;
import java.util.List;

/**
 * Created by byuwa on 2017/4/6.
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 */
public class Solution62 {
    public static void serialize(BinaryTreeNode root, List<Integer> result) {

        List<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        BinaryTreeNode node;
        while (list.size() > 0) {
            node = list.remove(0);
            if (node == null) {
                result.add(null);
            }else {
                result.add(node.value);
                list.add(node.left);
                list.add(node.right);
            }
        }
    }

    public static BinaryTreeNode deserialize(List<Integer> result, int idx) {

        if (result.size() < 1 || idx < 0 || result.size() <= idx || result.get(idx) == null) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(result.get(idx));
        root.left = deserialize(result, idx * 2 + 1);
        root.right = deserialize(result, idx * 2 + 2);
        return root;

    }

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        List<Integer> result = new LinkedList<>();
        serialize(n1, result);
        System.out.println(result);
        System.out.println();

        BinaryTreeNode root = deserialize(result, 0) ;
        printTree(root);

    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.printf("%-3d", root.value);
            printTree(root.right);
        }
    }
}
