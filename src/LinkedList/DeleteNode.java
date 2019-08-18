package LinkedList;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-18 22:01
 * @ Description: 删除链表中的节点
 **/
public class DeleteNode {
    /**
     * 思路: 就是把当前节点的值等于下一个节点的值,然后下一个节点等于下一个节点就ok了;
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
