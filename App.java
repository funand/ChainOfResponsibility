
public class App {

	public static void main(String[] args) {
		Node ceo = new CEONode();
		Node manager = new ManagerNode();
		Node associate =new AssociateNode();
		ceo.setLink(manager);
		manager.setLink(associate);
		
		Secretary s = new Secretary(ceo, 3);
		s.completeTask();
		System.out.println(s.getTask().survey);
	}

}


class Secretary {
	Node head;
	int size;
	Task task;
	
	public Secretary(Node h, int numNodes){
		head = h;
		size = numNodes;
		task = new Task();
	}
	
	public void add(Node node, int pos){
		if(head == null){
			head = node;
		}
		else{
			//to be done
		}
		size++;	
	}
	
	public void completeTask(){
		Node cursor = head;
		while (cursor != null){
			task = cursor.doSomethingAboutIt(task);
			cursor = cursor.getLink();
		}
	}
	
	public Task getTask(){return task;}

}

class CEONode extends Node{
	@Override
	Task doSomethingAboutIt(Task t) {
		Task task = t;
		task.setResponse(" I am XXX, I  have a lot to say about it....\n");
		return task;
	}
	
}


class ManagerNode extends Node{
	@Override
	Task doSomethingAboutIt(Task t) {
		Task task = t;
		task.setResponse(" I am YYY, I  have a lot to say about it....\n");
		return task;
	}
	
}


class AssociateNode extends Node{
	@Override
	Task doSomethingAboutIt(Task t) {
		Task task = t;
		task.setResponse(" I am ZZZ, I  have a lot to say about it....\n");
		return task;
	}
	
}

abstract class Node{	
	private Node link;

	public Node(){
		link = null;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}	
	
	abstract Task doSomethingAboutIt(Task t);
}

class Task{
	String survey = "";
	public void setResponse(String resp){
		survey += resp;
	}
}

