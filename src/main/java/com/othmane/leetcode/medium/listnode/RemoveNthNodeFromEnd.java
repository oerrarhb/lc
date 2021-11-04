package com.othmane.leetcode.medium.listnode;

/*
19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/
public class RemoveNthNodeFromEnd {

    public ListNode strategyOne(ListNode head, int n) {
        var l = size(head);
        var positionToDelete = l - n + 1;
        if (positionToDelete == 1) {
            return head.next;
        } else {
            var iterator = 0;
            var result = new ListNode();
            var r = result;
            var it = 0;
            while (head != null) {
                iterator++;
                if (iterator != positionToDelete) {
                    result.val = head.val;
                    head = head.next;
                    if (head != null && iterator < l - 1) {
                        result.next = new ListNode();
                        result = result.next;
                    }

                } else {
                    head = head.next;
                }
            }
            return r;
        }
    }

    public ListNode strategyTwo(ListNode head, int n) {
        var l = size(head);
        var positionToDelete = l - n + 1;
        if (positionToDelete == 1) {
            return head.next;
        } else {
            var iterator = 0;
            var result = new ListNode();
            var r = result;
            var it = 0;
            while (head != null) {
                iterator++;
                if (iterator != positionToDelete) {
                    result.val = head.val;
                    head = head.next;
                    if (head != null) {
                        result.next = new ListNode();
                        result = result.next;
                    }

                } else {
                    head = head.next;
                }
            }
            return r;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1) {
            return strategyOne(head, n);
        } else {
            return strategyTwo(head, n);
        }

    }

    public int size(ListNode ln) {
        if (ln == null) {
            return 0;
        } else {
            var current = ln;
            var i = 0;
            while (current != null) {
                current = current.next;
                i++;
            }
            return i;
        }
    }

}
