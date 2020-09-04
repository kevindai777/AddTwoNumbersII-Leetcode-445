//Java Solution using reversed linked lists

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversedFirst = reverse(l1);
        ListNode reversedSecond = reverse(l2);
        int carry = 0;
        ListNode newNode = new ListNode(-1);
        ListNode temp = newNode;
        
        while ((reversedFirst != null) || (reversedSecond != null)) {
            int a = (reversedFirst != null) ? reversedFirst.val : 0;
            int b = (reversedSecond != null) ? reversedSecond.val : 0;
            
            int sum = a + b + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            
            if (reversedFirst != null) {
                reversedFirst = reversedFirst.next;
            }
            
            if (reversedSecond != null) {
                reversedSecond = reversedSecond.next;
            }
            
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        
        return reverse(newNode.next);
    }
    
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}