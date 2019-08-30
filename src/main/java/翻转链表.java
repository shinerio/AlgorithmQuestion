import java.util.ArrayList;

public class 翻转链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(listNode == null) {
            return ret;
        }
        ListNode pre = listNode;
        ListNode next = pre.next;
        pre.next = null;
        ListNode nnext;
        while (next != null) {
            nnext = next.next;
            next.next = pre;
            pre = next;
            next = nnext;
        }
        while (pre != null) {
            ret.add(pre.val);
            pre = pre.next;
        }
        return ret;
    }
}
