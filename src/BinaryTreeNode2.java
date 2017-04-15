/**
 * Created by byuwa on 2017/4/3.
 */
public class BinaryTreeNode2 {
    private int val;
    public BinaryTreeNode2 left;
    public BinaryTreeNode2 right;
    public BinaryTreeNode2 parent;

    public BinaryTreeNode2() {
    }

    public BinaryTreeNode2(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
