import java.util.*;
public class IteratorApp {

	public static void main(String[] args) {
		MyList<Integer> lst = new MyList<Integer>();
		lst.add(20);
		lst.add(3);
		lst.add(10);
		lst.add(34);
		System.out.println(lst);
		Iterator<Integer> it = lst.getIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}


class MyList<T> extends ArrayList<T> implements Iterator<T>{
	T currentItem;
	int currentIndex;
	
	public MyList() {
		 super();
	}
	 
	public Iterator<T> getIterator(){
		currentIndex = size()-1;
		if(currentIndex >=0){
			currentItem = super.get(currentIndex);
		}
		return this;		
	}
	 
	@Override
	public boolean hasNext() {
		return currentIndex >= 0;
	}

	@Override
	public T next() {
		T hold = null;
		if(currentIndex >= 0){
			hold = get(currentIndex);
			currentIndex--;
		}
		return hold;
	}
	
}