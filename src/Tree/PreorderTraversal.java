package Tree;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        Integer[] data = {1,null,2,3};
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i=0; i<data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }
        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        PreorderTraversal traversal = new PreorderTraversal();
        List<Integer> integers = traversal.preorderTraversal(nodes[0]);
        Object[] array = integers.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}

