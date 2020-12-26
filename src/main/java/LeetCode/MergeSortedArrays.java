package LeetCode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {

    public static void main(String args[]){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,3,4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2,6));
        List<ListNode> metaset = new ArrayList<>();
        metaset.add(listToListNode(list1));
        metaset.add(listToListNode(list2));
        metaset.add(listToListNode(list3));
        ListNode head = mergeListsUtil(metaset.get(0),metaset.get(1));
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }



    }

    public static ListNode listToListNode(List<Integer> input){
        ListNode head  = new ListNode(input.get(0));
        ListNode temp = head;
        for(int i=1;i<input.size();i++){
            temp.next = new ListNode(input.get(i));
            temp=temp.next;
        }
        return  head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if(lists!=null && lists.length >0){
            result = lists[0];
            for(int i=1;i<lists.length;i++){
                result = mergeListsUtil(result,lists[i]);
            }
        }
        return result;
    }


    public static ListNode mergeListsUtil(ListNode node1,ListNode node2){
        if(node1 == null && node2 == null)
            return null;
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        ListNode result = new ListNode();
        ListNode head = result;
        if(node1.val<=node2.val){
            result.val = node1.val;
            node1=node1.next;
        }else{
            result.val = node2.val;
            node2=node2.next;
        }



        while(node1 != null && node2 !=null){
            ListNode next = new ListNode();
            if(node1.val <= node2.val){
                next.val = node1.val;
                node1 = node1.next;
            }else{
                next.val = node2.val;
                node2 = node2.next;
            }
            result.next = next;
            result = result.next;
        }
        if(node1 != null){
            result.next = node1;
        }
        if(node2!=null){
            result.next = node2;
        }
        return head;
    }
}
