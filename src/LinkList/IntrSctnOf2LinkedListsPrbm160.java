package LinkList;

public class IntrSctnOf2LinkedListsPrbm160 {

    ListNode intersectionOf2LinkedList(ListNode headFrst, ListNode headScnd) {
        if (headFrst == null)
            return headFrst;
        if (headScnd == null)
            return headScnd;

        int lenghtFrst = getListLength(headFrst);
        int lenghtScnd = getListLength(headScnd);

        while (lenghtFrst > lenghtScnd) {
            lenghtFrst--;
            headFrst = headFrst.next;
        }

        while (lenghtScnd > lenghtFrst) {
            lenghtScnd--;
            headScnd = headScnd.next;
        }

        while (headFrst != headScnd) {
            headFrst = headFrst.next;
            headScnd = headScnd.next;

        }

        return headFrst;

    }

    private int getListLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static void main(String[] args) {
        IntrSctnOf2LinkedListsPrbm160 solver = new IntrSctnOf2LinkedListsPrbm160();

        // Test 1: intersection at node with val 8
        // List1: 4 → 1 → 8 → 4 → 5
        // List2: 5 → 6 → 1 → 8 → 4 → 5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = common;

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next = common;

        ListNode result1 = solver.intersectionOf2LinkedList(head1, head2);
        System.out.println("Test 1: " + (result1 != null ? result1.val : "null")); // 8

        // Test 2: no intersection
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);

        ListNode h2 = new ListNode(3);
        h2.next = new ListNode(4);

        ListNode result2 = solver.intersectionOf2LinkedList(h1, h2);
        System.out.println("Test 2: " + (result2 != null ? result2.val : "null")); // null

        // Test 3: one list is null
        ListNode result3 = solver.intersectionOf2LinkedList(null, head2);
        System.out.println("Test 3: " + (result3 != null ? result3.val : "null")); // null
    }

}
