
public class 链表中环的入口结点
{

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 用快慢指针，先找到环上的点
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead.next;
        while(fast != slow) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                // 不存在环
                return null;
            }
            slow = slow.next;
        }
        // 求出环的长度
        int len = 1;
        fast = fast.next;
        while(fast != slow) {
            fast = fast.next;
            len ++;
        }
        // 两者同速，一者先行环的长度，两者于入口相遇
        fast = pHead;
        slow = pHead;
        while (len != 0) {
            fast = fast.next;
            len --;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        //不存在环
        return fast;
    }
}

