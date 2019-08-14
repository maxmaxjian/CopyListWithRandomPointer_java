public class Solution1 implements Solution {
    @Override
    public RandomListNode copyRandomListNode(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head, pn;
        while (curr != null) {
            pn = new RandomListNode(curr.label);
            pn.next = curr.next;
            curr.next = pn;
            curr = pn.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                } else {
                    curr.next.random = null;
                }
                curr = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        RandomListNode newhead = head.next, newcurr = newhead;
        curr = head;
        while (curr != null) {
            curr.next = newcurr.next;
            if (newcurr.next != null) {
                newcurr.next = newcurr.next.next;
            }
            curr = curr.next;
            newcurr = newcurr.next;
        }

        return newhead;
    }
}
