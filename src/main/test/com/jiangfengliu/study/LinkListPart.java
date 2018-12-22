package com.jiangfengliu.study;

public class LinkListPart {
  public static void main(String[] args) {
    ListNode head=new ListNode(1);
    head.next=new ListNode(4);
    head.next.next=new ListNode(3);
    head.next.next.next=new ListNode(2);
    head.next.next.next.next=new ListNode(5);
    print(head);
    ListNode node=new LinkListPart().partition(head,3);
    print(node);
  }

  public static void print(ListNode head){
    while (head!=null){
      System.out.println(head.val);
      head=head.next;
    }
  }

  public ListNode partition(ListNode head, int x) {
    ListNode tail=head;
    ListNode mark=null;
    while(tail!=null&&tail.next!=null){
      tail=tail.next;
    }
    ListNode p=head;
    ListNode pre=null;
    while(p!=null){
      if(p.val>=x){
        if(p==mark){
          break;
        }
        if(mark==null){
          mark=p;
        }

        tail.next=p;
        tail=tail.next;
        if(pre==null){
          ListNode tmp=p.next;
          p.next=null;
          head=tmp;
          p=tmp;
        }else{
          pre.next=p.next;
          p.next=null;
          p=pre.next;
        }
        continue;
      }
      pre=p;
      p=p.next;
    }
    return head;
  }
}
