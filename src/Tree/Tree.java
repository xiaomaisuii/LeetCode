package Tree;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-21 21:41
 * @ Description: 创建一个树的数据结构.这个数据结构不满足LeetCode的测试用例;
 **/
public class Tree {
    public void createTreeAsLevel(TreeNode[] nodes){
        int n = nodes.length;
        int flag = 0;//按层构造时一个值为null，则它之后的孩子序号应该相应减2flag
        for(int i=0; i<= (n-3)/2; i++){
            if(nodes[i] != null){
                nodes[i].left = nodes[2*i+1-2*flag];
                nodes[i].right = 2*i+2 == n ? null : nodes[2*i+2-2*flag];
            }else{
                flag++;
            }
        }
//      System.out.println();
    }
}
