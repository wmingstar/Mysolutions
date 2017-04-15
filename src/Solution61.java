import java.util.LinkedList;
import java.util.List;

/**
 * Created by byuwa on 2017/4/5.
 *请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左顺序打印，第三行再按照从左到右的顺序打印，其他以此类推。
 *
 */
public class Solution61 {
    public static void print(BinaryTreeNode root) {

        if (root == null) {
            return;
        }
        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (current.size() > 0) {
            // 从最后一个开始取
            node = current.remove(current.size() - 1);

            System.out.printf("%-3d", node.value);

            // 当前是从左往右打印的，那就按从左往右入栈
            if (flag == 0) {
                if (node.left != null) {
                    reverse.add(node.left);
                }

                if (node.right != null) {
                    reverse.add(node.right);
                }


            }
            // 当前是从右往左打印的，那就按从右往左入栈
            else {
                if (node.right != null) {
                    reverse.add(node.right);
                }

                if (node.left != null) {
                    reverse.add(node.left);
                }
            }

            if (current.size() == 0) {
                flag = 1 - flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }


}
