package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-23 20:52
 * @ Description: 二叉树的后序遍历
 **/
public class PostorderTraversal {
    /**
     * 递归算法
     * 时间: 一个番茄时间
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root==null) return integers;
        if (root.left!=null){
            List<Integer> integersLeft = postorderTraversal(root.left);
            integers.addAll(integersLeft);
        }
        if (root.right!=null){
            List<Integer> integersRight = postorderTraversal(root.right);
            integers.addAll(integersRight);
        }
        integers.add(root.val);
        return integers;
    }
}
