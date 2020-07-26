package com.epam.CustomCollectionList;

class CustomList<T>
{
     static class Node<T>
     {
    	 T value;
    	 Node<T> prev=null;
    	 Node<T> next=null;
    	 Node(T value)
    	 {
    		 this.value=value;
    	 }
     }
 
     Node<T> root=null;
     Node<T> tail=null;
     
     public void addFront(T element)
     {
    	 Node<T> n=new Node<T>(element);
    	 if(this.root==null)
    	 {
    		 this.root=n;
    		 this.tail=n;
    	 }
    	 else
    	 {
    		 this.root.prev=n;
    		 n.next=this.root;
    		 this.root=this.root.prev;
    	 }
     }
     public void addBack(T element)
     {
    	 Node<T> n=new Node<T>(element);
    	 if(this.tail==null)
    	 {
    		 this.root=n;
    		 this.tail=n;
    	 }
    	 else
    	 {
    		 this.tail.next=n;
    		 n.prev=this.tail;
    		 this.tail=this.tail.next;
    	 }
     }
     private void condition()
     {
    	 if(this.root==null)
    	 {
    		 System.out.println("EMPTY! (cannot delete)");
    		 return;
    	 }
    	 if(this.root.equals(this.tail))
    	 {
    		 System.out.println("REMOVED : "+this.root.value);
    		 this.root=null;
    		 this.tail=null;
    		 return;
    	 }
     }
     public void delFront()
     {
    	 condition();
		 Node<T> temp=this.root;
		 this.root=this.root.next;
		 temp.next=null;
		 this.root.prev=null;
		 System.out.println("REMOVED : "+temp.value);
     }
     public void delBack()
     {
    	 condition();
    	 Node<T> temp=this.tail;
    	 this.tail=this.tail.prev;
    	 temp.prev=null;
    	 this.tail.next=null;
    	 System.out.println("REMOVED : "+temp.value);
     }
     public void delElement(T element)
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! (cannot delete)");
    	 else if(this.root == this.tail)
    	 {
    		 if(this.root.value.equals(element))
    		 {
    			 System.out.println("REMOVED : "+this.root.value);
    			 this.root=null;
    			 this.tail=null;
    		 }
    		 else
    		 {
    			 System.out.println(element+" cannot be deleted (not present in list)");
    		 }
    	 }
    	 else
    	 {
    		 Node<T> temp=this.root,pr=this.root;
    		 while(temp!=null)
    		 {
    			 pr=temp;
    			 if(temp.value.equals(element))
    				 break;
    			 else
    				 temp=temp.next;
    		 }
    		 if(temp==null)
    			 System.out.println(element+" cannot be deleted (not present in list)");
    		 else
    		 {
    			 temp.prev.next=temp.next;
    			 temp.next.prev=temp.prev;
    			 temp.next=null;
    			 temp.prev=null;
    			 System.out.println("REMOVED  : "+element);
    		 }
    	 }
     }
     public void search(T element)
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! (cannot search)");
    	 else
    	 {
    		 Node<T> temp=this.root;
    		 while(temp!=null)
    		 {
    			 if(temp.value.equals(element))
    			 {
    				 System.out.print(element+" is present");
    				 return;
    			 }
    		 }
    		 System.out.print(element+" is not present"); 
    	 }
     }
     public void printElements_ASC()
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! (no elements)");
    	 else
    	 {
    		 Node<T> temp=this.root;
    		 System.out.println("Ascending order : ");
    		 while(temp!=null)
    		 {
    			 System.out.print(temp.value+",");
    			 temp=temp.next;
    		 }
    		 System.out.println();
    	 }
     }
     public void printElements_DESC()
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! (no elements)");
    	 else
    	 {
    		 Node<T> temp=this.tail;
    		 System.out.println("Descending order : ");
    		 while(temp!=null)
    		 {
    			 System.out.print(temp.value+",");
    			 temp=temp.prev;
    		 }
    		 System.out.println();
    	 }
     }
     public void clear()
     {
    	 System.out.println("All elements cleared!");
    	 this.root=null;
    	 this.tail=null;
     }
}

public class CustomListImplementation
{
	public static void main(String args[])
	{
		System.out.println("Custom List Implementaiton . type : Integer\n");
		CustomList<Integer> list1=new CustomList<Integer>();
		for(int i=1;i<=10;i++)
			list1.addBack(i);
		list1.addFront(1024);
		list1.addBack(1024);
		list1.printElements_ASC();
		list1.printElements_DESC();
		list1.delBack();
		list1.delFront();
		list1.delElement(11);
		list1.delElement(5);
		list1.printElements_ASC();
		list1.clear();
		list1.printElements_ASC();
		System.out.println("\n\nCustom List Implementaiton . type : String\n");
		CustomList<String> list2=new CustomList<String>();
		String s[]= {"this","is","the","initialization","of","the","custom","list","of","strings"};
		for(int i=0;i<s.length;i++)
			list2.addBack(s[i]);
		list2.printElements_ASC();
		list2.addFront("HELLO");
		list2.addBack("GOODBYE");
		list2.printElements_ASC();
		list2.printElements_DESC();
		list2.delBack();
		list2.delFront();
		list2.delElement("initialization");
		list2.delElement("custom");
		list2.printElements_ASC();
		list2.clear();
		list2.printElements_ASC();
	}
}