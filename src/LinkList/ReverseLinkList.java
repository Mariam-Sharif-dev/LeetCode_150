package LinkList;

import java.util.Stack;

public class ReverseLinkList {

    public ListNode reverseLinkList(ListNode head) {
        Stack<Integer> valStack = new Stack();

        // null,head will go to next process until head is
        while (head != null) {
            valStack.push(head.val);
            head = head.next;

        }

        // reverse list head will point to minimum value
        ListNode rvrsList = new ListNode(Integer.MIN_VALUE);
        // ptr pointing to reverse list
        ListNode ptr = rvrsList;

        // while value stack not emmpty pop element from stack create a listNode
        // then it will point to its next pointer
        while (!valStack.isEmpty()) {
            ptr.next = new ListNode(valStack.pop());
            ptr = ptr.next;
        }

        return rvrsList.next;

    }

    public static void main(String[] args) {
        ReverseLinkList solver = new ReverseLinkList();

        // Test 1: [1,2,3,4,5] → expected [5,4,3,2,1]
        ListNode head1 = buildList(new int[] { 1, 2, 3, 4, 5 });
        System.out.print("Test 1: ");
        printList(solver.reverseLinkList(head1)); // 5 4 3 2 1

        // Test 2: [1,2] → expected [2,1]
        ListNode head2 = buildList(new int[] { 1, 2 });
        System.out.print("Test 2: ");
        printList(solver.reverseLinkList(head2)); // 2 1

        // Test 3: single node [1] → expected [1]
        ListNode head3 = buildList(new int[] { 1 });
        System.out.print("Test 3: ");
        printList(solver.reverseLinkList(head3)); // 1

        // Test 4: null → expected null
        System.out.print("Test 4: ");
        printList(solver.reverseLinkList(null)); // (empty)
    }

    // Helper: build linked list from array
    public static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        for (int num : nums) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        return dummy.next;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

}
