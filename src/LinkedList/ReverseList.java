package LinkedList;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-19 14:42
 * @ Description: 反转链表
 **/
public class ReverseList {
    /**
     * 有可能使用递归算法进行.
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        // 不断取出和向后移动节点;
        // 并将头节点链接到新节点后面;
        while (head!=null){
            // 单独取出下一个节点
            ListNode next = head.next;
            // 将头节点链接新节点后面;
            head.next = newHead;
            newHead = head;
            // 向后移动头节点;
            head = next;
        }
        return newHead;
    }
}
