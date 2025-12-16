
package main;

import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {
    	/*
        int[] arr = {5, 3, 7, 8, 2};
        Node<Integer> list = ex1_builtList(arr);
        ex2_print(list);
        System.out.println();

        ex2_print_rec(list);
        System.out.println();

        ex3_print_flip(list);
        System.out.println();

        ex4_print_even(list);
        System.out.println();

        System.out.println(ex5_num_in_list(list, 8));
        System.out.println(ex5_num_in_list(list, 100));
        System.out.println();

        System.out.println(ex5_rec(list, 3));
        System.out.println(ex5_rec(list, 50));
        System.out.println();

        Node<Integer> afterNum = ex6_deleteByValue(list, 7);
        ex2_print(afterNum);
        System.out.println();

        Node<Integer> afterIndex = ex7_deleteByIndex(afterNum, 2);
        ex2_print(afterIndex);
        System.out.println();

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 5};
        Node<Integer> L1 = ex1_builtList(a1);
        Node<Integer> L2 = ex1_builtList(a2);
        
        System.out.println(ex8_list1_in_list2(L2,L1));
        System.out.println();
        
        ex9_print_list1_in_int_list2(L2,L1);
        System.out.println();
        
        Node<Integer> head = ex10_buildList_l1_in_l2(L1,L2);
        ex2_print(head);
        System.out.println();

        Node<Integer> res11 = ex11_delete_l1_in_l2(L1, L2);
        ex2_print(res11);
        System.out.println();
        */
     // ---------------------------------רמה 2------------------------------------------
        
        int[] a2_1 = {3, 5, 6, 6, 8};
        int[] a2_2 = {1, 5,7,9,7,9};
        Node<Integer> L2_1 = ex1_builtList(a2_1);
        Node<Integer> L2_2 = ex1_builtList(a2_2);
        Node<Integer> head1 = ex_2_1(L2_1,L2_2);
        ex2_print(head1);
        //--------------2------------------
        int[] a2_11 = {3,5,6,1,7,4,9,2};
        Node<Integer> p12 = ex1_builtList(a2_1);
        Node<Integer> head2 = ex_2_2(p12);
        System.out.println();
        ex2_print(head2);
        //-----------------3----------------------
        System.out.println(ex2_3(L2_2,7));
        //----------------4------------------
        System.out.println(ex2_4(p12));
        //-------------------5------------------
        Node<Integer> head10 = ex2_5(L2_1);
        ex2_print(head10);
        
        
    }


    // ex1 – מקבל מערך ומחזיר רשימה
    public static Node<Integer> ex1_builtList(int[] arr) 
    {
        if (arr.length == 0)
            return null;
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> curr = head;
        for (int i = 1; i < arr.length; i++)
        {
            curr.setNext(new Node<>(arr[i]));
            curr = curr.getNext();
        }
        return head;
    }

    // ex2 – הדפסה רגילה
    public static void ex2_print(Node<Integer> head)
    {
        Node<Integer> curr = head;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }

    // ex2 – הדפסה רקורסיבית
    public static void ex2_print_rec(Node<Integer> head) 
    {
        if (head == null)
            return;
        System.out.println(head.getValue());
        ex2_print_rec(head.getNext());
    }

    // ex3 – הדפסה מהסוף להתחלה
    public static void ex3_print_flip(Node<Integer> head) 
    {
        if (head == null)
            return;
        ex3_print_flip(head.getNext());
        System.out.println(head.getValue());
    }

    // ex4 – הדפסת מספרים זוגיים
    public static void ex4_print_even(Node<Integer> head) 
    {
        Node<Integer> curr = head;
        while (curr != null) {
            if (curr.getValue() % 2 == 0)
                System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }

    // ex5 – האם מספר מופיע ברשימה
    public static boolean ex5_num_in_list(Node<Integer> head, int x)
    {
        Node<Integer> curr = head;
        while (curr != null) {
            if (curr.getValue() == x)
                return true;
            curr = curr.getNext();
        }
        return false;
    }

    // ex6 – האם מספר מופיע ברשימה (רקורסיבי)
    public static boolean ex5_rec(Node<Integer> head, int x)
    {
        if (head == null)
            return false;
        if (head.getValue() == x)
            return true;
        return ex5_rec(head.getNext(), x);
    }

    // ex6 – מחיקה לפי ערך
    public static Node<Integer> ex6_deleteByValue(Node<Integer> p, int x) 
    {
        if (p == null)
            return null;
        Node<Integer> head = p;
        if (p.getValue() == x)
            return p.getNext();
        while (p.getNext() != null)
        {
            if (p.getNext().getValue() == x) 
            {
                p.setNext(p.getNext().getNext());
                return head;
            }
            p = p.getNext();
        }
        return head;
    }

    // ex7 – מחיקה לפי אינדקס (1 זו הראשונה)
    public static Node<Integer> ex7_deleteByIndex(Node<Integer> p, int x) {
        if (p == null)
            return null;
        Node<Integer> head = p;
        if (x == 1)
            return p.getNext();
        for (int i = 1; i < x - 1 && p != null; i++)
            p = p.getNext();
        if (p == null || p.getNext() == null)
            return head;
        p.setNext(p.getNext().getNext());
        return head;
    }

    // helper – בדיקה האם ערך קיים ב-L2
    public static <T> boolean helper(T v, Node<T> l2) 
    {
        while (l2 != null)
        {
            if (v.equals(l2.getValue()))
                return true;
            l2 = l2.getNext();
        }
        return false;
    }
    // ex8 - האם כל אברי אל 1 נמצאים באל2 
    public static boolean ex8_list1_in_list2(Node<Integer> l1, Node<Integer> l2)
    {
    	if(l1 == null)
    		return true;
    	if(!helper(l1.getValue(),l2))
    		return false;
    	return ex8_list1_in_list2(l1.getNext(),l2);
    }
    // מדפיס כל איברי אל 1 הנמצאים באל2
    public static void ex9_print_list1_in_int_list2(Node<Integer> l1, Node<Integer> l2)
    {
    	if(l1 == null)
    		return;
    	if(helper(l1.getValue(),l2))
    		System.out.println(l1.getValue());
    	ex9_print_list1_in_int_list2(l1.getNext(),l2);
    }
    // מחזיר רשימה של כל האברים המשותפים בין אל1 ואל2
    public static  Node<Integer> ex10_buildList_l1_in_l2(Node<Integer> l1, Node<Integer> l2)
    {
    	if (l1 == null)
            return null;
    	Node<Integer> head = new Node<>(0);
    	Node<Integer> p = head;
    	while(l1 != null)
    	{
    		if(helper(l1.getValue(),l2))
    		{
    			p.setNext(new Node<>(l1.getValue()));
    			p = p.getNext();
    		}
    		l1 = l1.getNext();
    	}
    	return head.getNext();
    }

    // ex11 – מוחק מ-L1 ערכים שמופיעים ב-L2
    public static Node<Integer> ex11_delete_l1_in_l2(Node<Integer> l1, Node<Integer> l2)
    {
        if (l1 == null)
            return null;
        Node<Integer> dummy = new Node<>(0, l1);
        Node<Integer> p = dummy;
        while (p.getNext() != null)
        {
            if (helper(p.getNext().getValue(), l2))
                p.setNext(p.getNext().getNext());
            else
                p = p.getNext();
        }
        return dummy.getNext();
    }
    
    // ---------------------------------רמה 2------------------------------------------
    // מוסיף מספר באינדקס שביקשנו(1 זה מיקום 0) ברשימה
    
    //ממיין 2 רשימות ממויינות
    public static Node<Integer> ex_2_1(Node<Integer> l1, Node<Integer> l2)
    {
        Node<Integer> head = new Node<>(0);
        Node<Integer> p = head;

        while (l1 != null && l2 != null)
        {
            if (l1.getValue() <= l2.getValue())
            {
                p.setNext(new Node<>(l1.getValue()));
                l1 = l1.getNext();
            }
            else
            {
                p.setNext(new Node<>(l2.getValue()));
                l2 = l2.getNext();
            }
            p = p.getNext();
        }

        while (l1 != null)
        {
            p.setNext(new Node<>(l1.getValue()));
            p = p.getNext();
            l1 = l1.getNext();
        }

        while (l2 != null)
        {
            p.setNext(new Node<>(l2.getValue()));
            p = p.getNext();
            l2 = l2.getNext();
        }

        return head.getNext();
    }
    public static Node<Integer> ex_2_helper(int num, int index, Node<Integer> p)
    {
    	Node<Integer> head = p;
    	for(int i = 1; i<index;i++)
    	{
    		p = p.getNext();
    	}
    	Node<Integer> curr = p.getNext();
    	p.setNext(new Node<>(num));
    	p.setNext(curr);
    	return head;
    }
    //  הכי קטן מוצא את האינדקס של המספר במערך
    public static int ex_2_helper2( Node<Integer> p)
    {
    	int index = 0;
    	int index_min = 0;
    	int num = p.getValue();
    	while(p != null)
    	{
    		index++;
    		if(p.getValue() < num)
    			index_min = index;
    	}
    	return index;
    	
    }
    public static int ex_2_helper3( Node<Integer> p)
    {
    	int min_num = 0;
    	int num = p.getValue();
    	while(p != null)
    	{
    		if(p.getValue() < num)
    			min_num = p.getValue();
    	}
    	return min_num;
    	
    }
    public static Node<Integer> ex_2_2(Node<Integer> head) 
    {
        if (head == null)
            return null;

        Node<Integer> sortedHead = null;
        Node<Integer> sortedTail = null;

        while (head != null)
        {
            Node<Integer> minNode = head;
            Node<Integer> minPrev = null;

            Node<Integer> prev = head;
            Node<Integer> curr = head.getNext();

            while (curr != null)
            {
                if (curr.getValue() < minNode.getValue())
                {
                    minNode = curr;
                    minPrev = prev;
                }
                prev = curr;
                curr = curr.getNext();
            }

            if (minPrev == null)
                head = head.getNext();
            else
                minPrev.setNext(minNode.getNext());

            minNode.setNext(null);

            if (sortedHead == null) {
                sortedHead = minNode;
                sortedTail = minNode;
            } else {
                sortedTail.setNext(minNode);
                sortedTail = minNode;
            }
        }

        return sortedHead;
    } 
    public static int ex2_3(Node<Integer> head, int x) 
    {
        int index = 0;
        int firstX = -1;
        int lastX = -1;

        Node<Integer> curr = head;
        while (curr != null)
        {
            if (curr.getValue() == x)
            {
                if (firstX == -1)
                    firstX = index;
                lastX = index;
            }
            index++;
            curr = curr.getNext();
        }

        if (firstX == -1)
        	return 0; 

        int length = index;
        return firstX + (length - lastX - 1);
    }
    public static boolean ex2_4(Node<Integer> head)
    {
        while (head != null) 
        {
            Node<Integer> curr = head.getNext();
            int x = head.getValue();

            while (curr != null) 
            {
                if (curr.getValue() == x) 
                {
                    return false;
                }
                curr = curr.getNext();
            }
            head = head.getNext();
        }
        return true;
    }
    public static <T> int helper3(T v, Node<T> l2) 
    {
    	int count = 0;
        while (l2 != null)
        {
            if (v.equals(l2.getValue()))
                count++;
            l2 = l2.getNext();
        }
        return count;
    }
    public static Node<Integer> build(Node<Integer> head)
    {
    	Node<Integer> curr = head;
    	 int count = 0;
    	 
    	 while(curr!= null)
    	 {
    		 count++;
    	 }
    	 int []a = new int[count];
    	 int index = 0;
    	 while(head != null)
    	 {
    		 a[index] = head.getValue();
    		 head.getNext();
    		 index++;
    	 }
    	 return ex1_builtList(a);
    }

    public static Node<Integer> ex2_5(Node<Integer> head)
    {
    	Node<Integer> curr = head;
    	Node<Integer> dummy = new Node<>(0);
    	Node<Integer> nade = dummy;
    	while(curr != null)
    	{
    		if(!ex5_num_in_list(nade,curr.getValue()))
    		{
    			dummy.setNext(new Node<>(curr.getValue()));
    			dummy = dummy.getNext();
    		}
    		curr = curr.getNext();
    	}
    	return nade.getNext();
    }

}
