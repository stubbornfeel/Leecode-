package Leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Code876Code19 {

    public static class ListNode{
        public int val;
        public ListNode next;

        public  ListNode(){

        }

        public ListNode(int val,ListNode next){
            next = this.next;
            val = this.val;
        }
        public ListNode(int val){
            val = this.val;
        }
    }

    /**
     * 876. 链表的中间结点
     * @param head
     * @return
     */
    //数组方法
    public static ListNode middleNode1(ListNode head) {
        ListNode[]  arr = new ListNode[100];
        ListNode he = head;
        int i = 0;
        while (he.next != null)
        {
            arr[i++] = he;
            he = he.next;
        }
        return arr[i/2];
    }
    //单指针
    public static ListNode middleNode2(ListNode head) {
        ListNode ku = head;
        int i = 0;
        while (ku != null)
        {
            head = head.next;
            i++;
        }

        int j = 0;
        ListNode cur = head;

        while(j < i/2){
            cur = cur.next;
            j++;
        }
        return  cur;
    }
    //快慢指针
    public static ListNode middleNode3(ListNode head) {
        ListNode first = head,slow = head;
        while ( first != null && first.next != null)
        {
            first = first.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     *19. 删除链表的倒数第 N 个结点
     * 计算链表长度
     * 栈
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for(int i = 1;i < length-n+1;i++)
        {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode Ans = dummy.next;
        return  Ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummny = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummny;

        while (cur.next != null)
        {
            stack.push(cur);
        }

        for(int i = 0;i<n;i++)
        {
            stack.pop();
        }

        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        ListNode res = dummny.next;

        return res;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fast = head;
        ListNode clow = head;
        ListNode sur = new ListNode(0,head);

        for(int i = 0;i < n;i++)
        {
            fast = fast.next;
        }
        while (fast.next != null)
        {
            fast = fast.next;
            clow = clow.next;
        }
        clow.next = clow.next.next;
        ListNode wu = sur.next;

        return wu;
    }





    public static void main(String[] args) {
        ListNode newNode = new ListNode();
        ListNode head = newNode;

        Scanner in = new Scanner(System.in);

        while (in.hasNext())
        {
            int value = in.nextInt();
            if(value == 0){
                break;
            }
            ListNode newsNode = new ListNode(value);
            insertNode(newsNode,head);
            head = newNode;
        }

    }

    public static void insertNode(ListNode node,ListNode head)
    {
        head.next = node;
    }


}
