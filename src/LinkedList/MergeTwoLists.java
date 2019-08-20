package LinkedList;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-20 14:05
 * @ Description: 合并两个有序链表
 **/
public class MergeTwoLists {
    /**
     * 遍历方法: 同时不断的遍历两个链表,取出小的追加新的头节点后面,直至两者其中一个为空.
     * 在将另一个追加到链表后面.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(-1);
        ListNode curNode =ln;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }else {
                curNode.next = l2;
                l2 = l2.next;
            }
            // 需要把临时的节点把下边移动一下
            curNode = curNode.next;
        }

        curNode.next = (l1 != null) ? l1 : l2;
        return ln.next;
    }

    /**
     * 这个用递归的算法去解题
     * 把问题规模不断缩小化,
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 这两个条件是代表的是递归算法的出口;
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }

}
