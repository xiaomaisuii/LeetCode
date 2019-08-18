package LinkedList;

import org.junit.Test;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-18 22:37
 * @ Description: 删除链表的倒数第N个节点
 * 这个链表的思想特别要记住,要多思考一下.
 **/
public class RemoveNthFromEnd {
    /**
     * 使用快慢指针的方式:快指针比慢指针快n个单元,当快指针到达尾部的时,慢指针指向待删除节点的前节点.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head; // 快指针
        ListNode slow = head; // 慢指针
        // 快指针提前移动n次
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 这块链表小于等于2 于是要删除链表的头部
        if (fast == null) {
            return head.next;
        }
        // 同时移动快慢指针,直到快指针到达尾部;
        // 说明慢指针正好在要删除的位置上;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 用慢指针删除
        slow.next = slow.next.next;

        return head;
    }

    /**
     * 思路:先遍历一遍单链表,得到单链表的长度,然后在删除指定位置的元素
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return null;
        int len = 0;
        // 缓存一份链表
        ListNode cur = head;
        // 计算链表长度
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        // 计算正向的位置
        int where = len - n + 1;
        if (where==1){
            return head.next;
        }

        cur = head;
        int i = 0;
        while (cur!=null){
            i++;
            while(i == where - 1){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(5);
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println(listNode);
    }

}
