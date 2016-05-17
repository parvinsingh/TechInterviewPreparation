
public class LinkedListNode {

	static int data;
	static LinkedListNode prev;
	static LinkedListNode next;
	
	public LinkedListNode(int value){
		data = value;
		next = null;
		prev = null;
	}
	
	//find kth to the last element to the linkedList
	private static LinkedListNode kthToLastNode(LinkedListNode node, int k) throws Exception{
		if(node == null){
			return node;
		}
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		for(int i=0; i<k-1; i++){
			//move the fast node K nodes ahead
			if(fast.next!=null){
				fast= fast.next;
			}else if(fast.next==null){
				throw new Exception("index of the expected node is more than the size of linkedList");
			}
		}
		while(fast.next!=null){
			slow= slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	//Partition a linkedList around a node X, values less than X are to left
	//values more than or equal to X to the right.
//	private static LinkedListNode partitionList(LinkedListNode node, int k){
//		if(node==null){
//			return node;
//		}
//		
//	}
	
	//Given a circular LinkedList, 
	//implement an algorithm that returns the node at the beginning of the loop.
	private static LinkedListNode startNodeOfLoop(LinkedListNode head){
		/*
		 * 1. Detect loop, by using fast/slow approach
		 * 2. Move the slow node to the begining of the list
		 * 3. Move both nodes one step at a time. 
		 */
		if(head==null){
			return null;
		}
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				break;//loop found
			}
		}
		if(fast==null || fast.next==null){
			return head;
			//error condition, no loop detected
		}
		slow = head;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;//either slow or fast node
	}
	
	//Helper method to add two nodes in the list
	private static PartialSum addListsHelper(LinkedListNode list1, LinkedListNode list2){
		if(list1==null && list2==null){
			LinkedListNode sum = new LinkedListNode(0);
			LinkedListNode.PartialSum partial = sum.new PartialSum();
			return partial;
		}
		PartialSum sum = addListsHelper(list1.next, list2.next);
		
		int value = sum.carry + list1.data + list2.data;
		
		LinkedListNode fullResult = insertBefore(sum.sum, value%10);
		
		sum.sum = fullResult;
		sum.carry = value/10;
		
		return sum;
	}
	
	private static LinkedListNode insertBefore(LinkedListNode sum, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if(sum!=null){
			sum.prev = node;
			node.next = sum;
		}
		return node;
	}

	//Add two lists
	private static LinkedListNode addLists(LinkedListNode inputNode1, LinkedListNode inputNode2){
		int len1 = lengthOfList(inputNode1);
		int len2 = lengthOfList(inputNode2);
		
		//pad lists if needed
		if(len1 > len2){
			padList(inputNode1, len1-len2);
		}
		if(len2 > len1){
			padList(inputNode2, len2-len1);
		}
		
		PartialSum sum = addListsHelper(inputNode1, inputNode2);
		
		if(sum.carry==0){
			return sum.sum;
		}else{
			return insertBefore(sum.sum, sum.carry);
		}
	}

	private static LinkedListNode padList(LinkedListNode node, int sizeDiff) {
		LinkedListNode head = node;
		for(int i=0; i<sizeDiff; i++){
			LinkedListNode tempNode = new LinkedListNode(0);
			head.prev = tempNode;
			tempNode.next = head;
			head = tempNode;
		}
		return head;
	}

	private static int lengthOfList(LinkedListNode list) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class PartialSum {
		LinkedListNode sum = null;
		int carry = 0;
	}
}
