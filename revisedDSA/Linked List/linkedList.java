
class linkedList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ////// intersection
    // public static int findIntersection(LinkedList one, LinkedList two) {
    // int s1 = one.size;
    // int s2 = two.size;
    // Node onePo = one.head;
    // Node twoPo = two.head;

    // if (s1 < s2) {
    // while (s1 != s2) {
    // twoPo = twoPo.next;
    // s1++;
    // }
    // } else if (s1 > s2) {
    // while (s1 != s2) {
    // onePo = onePo.next;
    // s1--;
    // }
    // }

    // while (onePo != null) {
    // if (onePo == twoPo) {
    // return onePo.data;
    // }
    // onePo = onePo.next;
    // twoPo = twoPo.next;
    // }
    // return -1;
    // }

    ///////////////////// display reverse
    // private void displayReverseHelper(Node node){
    // if(node == null) return;

    // displayReverseHelper(node.next);
    // System.out.print(node.data+" ");
    // }

    // public void displayReverse(){
    // displayReverseHelper(head);
    // System.out.println();
    // }

    //// add two linked List
    // static ListNode ans = null;

    // public static class ListNode {
    // int val = 0;
    // ListNode next = null;

    // ListNode(int val) {
    // this.val = val;
    // }
    // }

    // private static void addFirst( int data){
    // ListNode newnode = new ListNode(data);
    // newnode.next = ans;
    // ans = newnode;
    // }

    // public static int size_01(ListNode node){
    // int count = 0;
    // while(node != null){
    // count++;
    // node = node.next;
    // }
    // return count;
    // }

    // private static int addTwoNumbers(ListNode l1,int s1, ListNode l2,int s2){
    // if(s1 == 0 && s2 ==0) return 0;

    // int data = 0;
    // if(s1 > s2){
    // int oc = addTwoNumbers(l1.next,s1-1,l2,s2);
    // data = l1.val + oc;
    // }else if(s1 < s2){
    // int oc = addTwoNumbers(l1,s1,l2.next,s2-1);
    // data = l2.val + oc;
    // }else{
    // int oc = addTwoNumbers(l1.next,s1-1,l2.next,s2-1);
    // data = l1.val + l2.val + oc;
    // }

    // int newData = data % 10;
    // int nc = data / 10;

    // addFirst(newData);

    // return nc;
    // }

    // public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // int l1_size = size_01(l1);
    // int l2_size = size_01(l2);

    // int oc = addTwoNumbers(l1,l1_size,l2,l2_size);

    // if(oc > 0){
    // addFirst(oc);
    // }

    // return ans;
    // }

    public static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode nxt = head;

        while (curr != null) {
            nxt = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nxt;
        }

        return pre;
    }

    public static void fold(ListNode head) {
        ListNode l1 = head;
        ListNode mid = midNode(head);
        ListNode nNode = mid.next;
        mid.next = null;
        ListNode l2 = reverse(nNode);
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
            c1.next = c2;
            c2.next = l1;
            c1 = l1;
            c2 = l2;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode st = head;
        ListNode mid = midNode(head);
        ListNode newNode = mid.next;
        ListNode rev = reverse(newNode);
        ListNode last = rev;
        boolean flag = true;
        while (st != null && last != null) {
            if (st.val != last.val) {
                flag = false;
                break;
            }
        }

        rev = reverse(rev);
        mid.next = rev;
        return flag;
    }

    public static void unfold(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode firstPo = head, secondHead = head.next, secondPo = head.next, curr = head.next.next;
        firstPo.next = secondPo.next = null;
        boolean flag = true;
        while (curr != null) {
            if (flag) {
                firstPo.next = curr;
                firstPo = curr;
                curr = curr.next;
                firstPo.next = null;
                flag = false;
            } else {
                secondPo.next = curr;
                secondPo = curr;
                curr = curr.next;
                secondPo.next = null;
                flag = true;
            }
        }
        ListNode rev = reverse(secondHead);
        firstPo.next = rev;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dp.next = p1;
                p1 = p1.next;
                dp = dp.next;
            } else {
                dp.next = p2;
                p2 = p2.next;
                dp = dp.next;
            }
        }
        if (p1 != null) {
            dp.next = p1;
        } else {
            dp.next = p2;
        }
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0)
            return head;
        ListNode slow = head, fast = head, curr = head;
        while (n > 0) {
            fast = fast.next;
            curr = curr.next;
            n--;
        }
        while (curr != null && curr.next != null) {
            slow = slow.next;
            fast = fast.next;
            curr = curr.next;
        }
        if (slow == head) {
            ListNode nNode = head;
            ListNode temp = nNode.next;
            nNode.next = null;
            return temp;
        }
        if (slow.next != null)
            slow.next = slow.next.next;
        return head;
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode evenPo = even, oddPo = odd, curr = head, node = null;
        while (curr != null) {
            if (curr.val % 2 == 0) {
                evenPo.next = curr;
                evenPo = evenPo.next;
            } else {
                oddPo.next = curr;
                oddPo = oddPo.next;
            }
            curr = curr.next;
        }
        oddPo.next = null;
        if (odd.next != null) {
            evenPo.next = odd.next;
        }
        return even.next;
    }

    public static ListNode segregate01(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode zeroPo = zero, onePo = one, curr = head, node = null;

        while (curr != null) {
            if (curr.val == 0) {
                zeroPo.next = curr;
                zeroPo = zeroPo.next;
            } else {
                onePo.next = curr;
                onePo = onePo.next;
            }
            curr = curr.next;
        }
        onePo.next = null;
        if (one.next != null) {
            zeroPo.next = one.next;
        }
        return zero.next;
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);
        ListNode zeroPo = zero, onePo = one, twoPo = two, curr = head, node = null;
        while (curr != null) {
            if (curr.val == 0) {
                zeroPo.next = curr;
                zeroPo = zeroPo.next;
            } else if (curr.val == 1) {
                onePo.next = curr;
                onePo = onePo.next;
            } else {
                twoPo.next = curr;
                twoPo = twoPo.next;
            }
            curr = curr.next;
        }

        twoPo.next = null;

        if (one.next != null) {
            zeroPo.next = one.next;
        } else {
            if (two.next != null) {
                zeroPo.next = two.next;
            }
        }

        if (two.next != null) {
            onePo.next = two.next;
        }
        return zero.next;
    }

    /////// merge sort

    public static ListNode midNode_MS(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeSort(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode node1 = node;
        ListNode mid = midNode_MS(node);
        ListNode node2 = mid.next;
        mid.next = null;
        ListNode recAns1 = mergeSort(node1);
        ListNode recAns2 = mergeSort(node2);

        return mergeTwoLists(recAns1, recAns2);
    }

    ////////////////// mergeKlist
    public static ListNode mergeKLists_01(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode first = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode second = mergeTwoLists(first, lists[i]);
            first = second;
        }
        return first;
    }

    public static ListNode mergeKLists_helper(ListNode[] lists, int strI, int endI) {
        if (strI == endI)
            return lists[strI];

        int mid = (strI + endI) / 2;
        ListNode leftArr = mergeKLists_helper(lists, strI, mid);
        ListNode rightArr = mergeKLists_helper(lists, mid + 1, endI);

        return mergeTwoLists(leftArr, rightArr);
    }

    public static ListNode mergeKLists_02(ListNode[] lists) {
        return mergeKLists_helper(lists, 0, lists.length - 1);
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (k <= 0 || head == null)
            return head;
        ListNode pre = null, curr = head, revTail = head, forw = head.next;
        ListNode nHead = null;
        boolean flag = true;

        while (curr != null) {

            int n = k;
            while (n > 0 && flag && curr != null) {
                curr.next = pre;
                pre = curr;
                curr = forw;
                n--;
            }

            if (curr == null && n > 0) {
                revTail.next = nHead;
                flag = false;
            } else if (n == 0) {
                revTail.next = pre;
                revTail = curr;
            }
        }
        return curr;
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (pre.val != curr.val) {
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next;
        }
        pre.next = null;
        return head;
    }

    public static ListNode removeAllDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = new ListNode(-101), curr = head;
        ListNode nhead = pre;

        while (curr != null) {
            int count = 0;
            ListNode npre = curr;
            if (curr != null && pre.val != curr.val) {
                while (curr != null && npre.val == curr.val) {
                    count++;
                    curr = curr.next;
                }
            }
            if (count <= 1) {
                pre.next = npre;
                pre = pre.next;
            }
        }
        pre.next = null;
        return nhead.next;

    }

    //// leetcode 61 rotate number

    public static int size_01(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null)
            return head;
        int size = size_01(head);
        if (k < 0)
            k = size + k;
        k = k % size;
        if (size == 1 || k == 0)
            return head;
        ListNode slow = head, fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = head;
        return temp;
    }

    /// leetcode 86  partition

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode evenPo = even, oddPo = odd, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                evenPo.next = curr;
                evenPo = evenPo.next;
            } else {
                oddPo.next = curr;
                oddPo = oddPo.next;
            }
            curr = curr.next;
        }
        oddPo.next = null;
        if (odd.next != null) {
            evenPo.next = odd.next;
        }
        return even.next;
    }
}