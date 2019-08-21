package Tree;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-21 21:41
 * @ Description: 创建一个树的数据结构
 **/
public class Tree {
    public void createTreeAsLevel(TreeNode[] nodes){
        int n = nodes.length;
        // 暗层构造时第一个值为null, 则之后他的孩子应该相应的减去2 flag.
        int flag = 0;
        // i<= (n-3)/2是对2*i+2<=n-1的变形
        for(int i=0; 2*i+1 < n-1; i++){
            if(nodes[i] != null){
                nodes[i].left = nodes[2*i+1-2*flag];
                nodes[i].right = 2*i+2 == n ? null : nodes[2*i+2-2*flag];
            }else{
                flag++;
            }
        }
        System.out.println();
    }
}
