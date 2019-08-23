package Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-23 19:37
 * @ Description: 中序遍历二叉树
 **/
public class InorderTraversal {
    /**
     * 递归调用
     * 时间:2个番茄时间
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root==null) return integers;
        if (root.left==null) {
            integers.add(root.val);
        }
        if (root.left != null){
            List<Integer> integersLeft = inorderTraversal(root.left);
            integers.addAll(integersLeft);
            integers.add(root.val);
        }
        if (root.right!=null){
            List<Integer> integersRight = inorderTraversal(root.right);
            integers.addAll(integersRight);
        }
        return integers;
    }
}
