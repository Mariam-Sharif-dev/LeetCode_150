package LinkList;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode ptr = l1;
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;

        }
    }

    /**
     * traverse link list
     * @param head
     */

    public void trvrsLnkList(ListNode head) {

        ListNode temp = head;

        // Run a loop until you reach null
        while (temp != null) {

            // Print the first value
            System.out.println(temp.val);

            // Move to the next node
            temp = temp.next;
        }
    }
    /**
     * inserting at beginning
     * @param head
     */

    public ListNode insrtAtbeg(ListNode head,int val)
    {

        ListNode newNode = new ListNode(val);
        //pointing to head
        newNode.next = head;
        head = newNode;

        return head;


    }

    /**
     * 
     * @param head
     * @param val
     * @return
     */

    public ListNode insrtAtEnd(ListNode head,int val)
    {
        //setting new values as listNode
        ListNode newNode = new ListNode(val);

        //pointing to head
        ListNode ptr = head;
        while(ptr.next!=null)
        {
            ptr = ptr.next;
        }
        ptr.next = newNode;

        return head;
    }

}
