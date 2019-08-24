package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-21 20:56
 * @ Description: 二叉树的前序遍历
 **/
public class PreorderTraversal {
    /**
     * 利用递归的思想貌似比较简单
     * 但是发现自己构建的Tree数据结构和leetCode上面的数据结构不一样,所以明天需要修改一下数据结构;
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        if (root.left!=null){
            List<Integer> integersLeft = preorderTraversal(root.left);
            integers.addAll(integersLeft);
        }
        if (root.right!=null){
            List<Integer> integersRight = preorderTraversal(root.right);
            integers.addAll(integersRight);
        }
        return integers;
    }


    /**
     * 使用迭代算法实现，这个比较难。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) return integers;
        // 充分利用了LinkedList的数据结构去存放节点。
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        // 必须先存放右节点；
        while (!list.isEmpty()){
            // 取出最后一个元素并删除
            TreeNode node = list.removeLast();
            integers.add(node.val);
            // 先存放右节点
            if (node.right!=null){
                list.add(node.right);
            }
            if (node.left!=null){
                list.add(node.left);
            }
        }
        return integers;
    }

}

