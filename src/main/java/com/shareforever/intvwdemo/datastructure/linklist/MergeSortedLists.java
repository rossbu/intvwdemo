package com.shareforever.intvwdemo.datastructure.linklist;

public class MergeSortedLists {
    ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public void addToTheLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList(ListNode listnode) {
        while (listnode != null) {
            System.out.print(listnode.val + " ");
            listnode = listnode.next;
        }
    }

    public static void main(String[] args) {
        MergeSortedLists llist1 = new MergeSortedLists();
        MergeSortedLists llist2 = new MergeSortedLists();
        llist1.addToTheLast(new ListNode(1));
        llist1.addToTheLast(new ListNode(5));
        llist1.addToTheLast(new ListNode(10));
        llist1.addToTheLast(new ListNode(15));
        llist1.addToTheLast(new ListNode(25));
        llist1.addToTheLast(new ListNode(44));

        llist2.addToTheLast(new ListNode(2));
        llist2.addToTheLast(new ListNode(3));
        llist2.addToTheLast(new ListNode(7));
        llist2.addToTheLast(new ListNode(11));

        ListNode newlist = mergeTwoLists(llist1.head, llist2.head);
        llist1.printList(newlist);
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode fakehead = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode p = fakehead;

        // iterate through both l1 and l2
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }

        return fakehead.next;


    }

}
