package IntLinkedList;

public class List {
	
	Node front;
	int size;
	
	public List(Node first) {
		this.front = first;
		size = 1;
	}
	
	public int size() {
		return this.size;
	}
	
	public int add(Node node) {
		node.next = front;
		front = node;
		size ++;
		
		return node.data;
	}
	
	public void traverse() {
		Node temp = front;
		
		System.out.print("\n");
		
		while(true) {
			System.out.print(temp.toString()+", ");		
			if(temp.next==null)break;
			temp = temp.next;
		}
	}
	
	public int find(int target) {
		Node temp = front;
		int index = 1;
		
		while(true) {
			if(temp.data==target) {
				return index;
			}
			else {
				if(temp.next!=null) {
					temp = temp.next;
					index++;
				}
				else break;
			}
		}
		return -1;
	}

	public String remove(int data) {
		//Can call the find method to quick check if the data is in our list
		if(find(data)==-1) {
			return "Value not found in list";
		}
		
		Node temp = front;
		Node prev = null;
		
		while(true) {
			//if we are removing the head
			if(prev==null&&temp.data==data) {
				front = front.next;
				size--;
				break;
			}
			//if we are removing the tail
			if(temp.next==null&&temp.data==data) {
				prev.next = null;
				size--;
				break;
			}
			//if we are removing any node in between head and tail
			if(temp.data==data) {
				prev.next = temp.next;
				size--;
				break;
			}
			//cycle on
			prev = temp;
			temp = temp.next;
		}
		return "First ocuurance of '"+data+"' has been deleted!";
	}

	public String removeAll(int data) {
		if(find(data)==-1) {
			return "Value not found in list";
		}
		
		//Keep calling remove(data) until none Node with value == data remain
		while(true) {
			remove(data);
			if(find(data)==-1)break;
		}
		
		return "All occurances of '"+data+"' have been deleted!";
	}

	public String replace(int target, int data) {
		if(find(target)==-1) {
			return "Value not found in list";
		}
		
		Node temp = front;
		
		while(true) {
			if(temp.data == target) {
				temp.data = data;
				break;
			}
			if(temp.next == null)break;
			temp = temp.next;
		}
		
		return "First occurance of '"+target+"' has been replaced with '"+data+"'";
	}

	public String replaceAll(int target, int data) {
		if(find(target)==-1) {
			return "Value not found in list";
		}
		
		while(true) {
			replace(target,data);
			if(find(target)==-1)break;
		}
		
		return "All occurances of '"+target+"' have been replaced with '"+data+"'";
	}
}
