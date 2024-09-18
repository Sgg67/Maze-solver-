package ass2;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueInterface<E> {
  private MiniList<E> list = new MiniList<E>();

    public MyQueue(){
        list = new MiniList<>();
	
    }  
public boolean isEmpty(){
     return list.isEmpty();
}
 

public void enqueue(E element){
	if(isEmpty()) {
		list.addFirst(element);
	}
	else {
		list.addLast(element);
	}
}



public E dequeue(){
    if(isEmpty()){
        throw new NoSuchElementException();
    }
    else{
       return list.removeFirst();
    }
}

public E front() {
	
	if(isEmpty()) {
		throw new  NoSuchElementException();
	}
	else {
		return list.getFirst();
	}
}

}


