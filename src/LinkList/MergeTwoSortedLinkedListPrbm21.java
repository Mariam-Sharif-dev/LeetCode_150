package LinkList;

public class MergeTwoSortedLinkedListPrbm21 {

    // merge 2 sorted link list
    private ListNode mrg2srtdLst(ListNode list1, ListNode list2) {

        // first initialize with minimum value
        ListNode mergeListNode = new ListNode(Integer.MIN_VALUE);
        // head indicating mergeListNode
        ListNode head = mergeListNode;

        // loop through both list until one of them is null
        while (list1 != null && list2 != null) {
            // if one list value is another mrglst will process first less value
            if (list1.val <= list2.val) {
                mergeListNode.next = list1;
                list1 = list1.next;
            } else {
                mergeListNode.next = list2;
                list2 = list2.next;
            }
            mergeListNode = mergeListNode.next;

        }
//add remaining list
        if (list1 == null) {
            mergeListNode.next = list2;
        } else if (list2 == null) {
            mergeListNode.next = list1;
        }
    }

  

}
