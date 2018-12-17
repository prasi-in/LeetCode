//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//        Example:
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

//  Time complexity is  O(max(m,n))  where m and n is length of the linkedlist 1 and 2 respectively
//  Space complexity is  O(max(m,n))  where m and n is length of the linkedlist 1 and 2 respectively
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListAddition {
    public static void main(String args [])
    {
        LinkedList<Integer> linkedList1 = new LinkedList<>() ;
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList1.add(2);
        linkedList1.add(4);
        linkedList1.add(3);

        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(4);

        LinkedList<Integer> resultList = addLinkedLists(linkedList1, linkedList2);

        Iterator resultListIterator = resultList.iterator();
        while(resultListIterator.hasNext())
            System.out.println("LinkedListAddition.main " + resultListIterator.next() );
    }

    private static LinkedList<Integer> addLinkedLists(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        LinkedList<Integer> resultList =  new LinkedList<>();

        Iterator linkedList1Iterator = linkedList1.iterator();
        Iterator linkedList2Iterator = linkedList2.iterator();
        int carry = 0;
        while (linkedList1Iterator.hasNext() || linkedList2Iterator.hasNext())
        {
            int num1 = (int) linkedList1Iterator.next();
            int num2 = (int) linkedList2Iterator.next();
            int sum = num1+ num2 + carry;
            carry = sum/ 10;
//            System.out.println("LinkedListAddition.addLinkedLists"  + num1 + "+" + num2 + "=" + sum
//            + "  carry :" + carry);
            if(carry > 0)
                resultList.add(0);
            else
                resultList.add(sum);
        }
        return resultList;
    }
}
