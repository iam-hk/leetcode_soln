/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode fnReverse(ListNode l1)
    {
        if(l1==null||l1.next==null)
            return l1;
        ListNode tmp=fnReverse(l1.next);
        l1.next.next=l1;
        l1.next=null;
        return tmp;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=fnReverse(l1);
        l2=fnReverse(l2);
        ListNode tmp1=l1;
        ListNode tmp2=l2;
        ListNode ans=new ListNode();
        ListNode tmp=ans;
        int carry=0;
        while(tmp1!=null&&tmp2!=null)
        {
            int dig=tmp1.val+tmp2.val+carry;
            carry=dig/10;
            dig%=10;
            ListNode nnode=new ListNode();
            nnode.val=dig;
            tmp.next=nnode;
            tmp=tmp.next;
            tmp1=tmp1.next;
            tmp2=tmp2.next;
            
            
        }
        while(tmp1!=null)
        {
            int dig=tmp1.val+carry;
            carry=dig/10;
            dig%=10;
            ListNode nnode=new ListNode();
            nnode.val=dig;
            tmp.next=nnode;
            tmp=tmp.next;
             tmp1=tmp1.next;
            
        }
        while(tmp2!=null)
        {
             int dig=tmp2.val+carry;
            carry=dig/10;
            dig%=10;
            ListNode nnode=new ListNode();
            nnode.val=dig;
            tmp.next=nnode;
            tmp=tmp.next;
            tmp2=tmp2.next;
        }
        if(carry==1)
        {
           ListNode nnode=new ListNode();
            nnode.val=1;
            tmp.next=nnode;
            tmp=tmp.next;  
        }
        return fnReverse(ans.next);
        
    }
}

// ans=new node
// head=ans;
// n new node;
// ans.next=n;
// ans=ans.next;
// return head.next;