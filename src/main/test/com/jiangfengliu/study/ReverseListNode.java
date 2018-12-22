package com.jiangfengliu.study;

public class ReverseListNode {
  public static void main(String[] args) {
     ListNode head=new ListNode(3);
    head.next=new ListNode(5);
//    head.next.next=new ListNode(7);
//    head.next.next.next=new ListNode(8);
//    head.next.next.next.next=new ListNode(9);
    print(head);
    ListNode node=new ReverseListNode().reverseBetween(head,1,2);
    print(node);
  }
  public static void print(ListNode head){
    while (head!=null){
      System.out.println(head.val);
      head=head.next;
    }
  }
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(m==n){
      return head;
    }
    ListNode pre=null;
    ListNode mNodePre=null;
    ListNode nNode=null;
    ListNode nNodeNext=null;
    ListNode p=head;
    int count=0;
    while(p!=null){
      count++;
      if(count==m-1){
        mNodePre=p;
      }
      if(count==n+1){
        nNodeNext=p;
      }
      if(count>m&&count<=n){
        ListNode next=p.next;
        p.next=pre;
        pre=p;
        if(count==n){
          nNode= pre;
        }
        p=next;
      }else{
        pre=p;
        p=p.next;
      }

    }
    if(mNodePre==null){
      head.next=nNodeNext;
      return nNode;
    }
    if(nNodeNext==null){
      //  ListNode tmp=mNodePre.next;
      mNodePre.next=nNode;
      return head;
    }

    ListNode tmp=mNodePre.next;
    mNodePre.next=nNode;
    tmp.next=nNodeNext;
    return head;
  }
}
