package LinkList;

public class RemoveDuplicates {

    private ListNode remvDup(ListNode head)
    {
        ListNode prevNode = head;
        ListNode  currntNode = prevNode.next;

        while(currntNode!=null)
        {
            if(currntNode.val==prevNode.val)
            {
                currntNode = currntNode.next;
                continue;
            }

            prevNode.next = currntNode;
            prevNode = currntNode;
            currntNode = currntNode.next;

        }

        prevNode.next = null;
        return head;
    }

}
