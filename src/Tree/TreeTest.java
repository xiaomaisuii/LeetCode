package Tree;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-21 21:47
 * @ Description: TODO
 **/
public class TreeTest {
    public boolean findTarget(TreeNode root, int k) {
        //LeetCode的核心代码
        return true;
    }

    public static void main(String[] args) {
//        Integer[] data = {5,3,6,null,null,null,7};
        Integer[] data = {1,null,2,3};
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i=0; i<data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }
        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        TreeTest tt = new TreeTest();
        System.out.println(tt.findTarget(nodes[0], -1));
    }
}
