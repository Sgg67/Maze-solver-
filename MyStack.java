package ass2;

import java.util.NoSuchElementException;


import ass2.MiniList;

public class MyStack<E> implements StackInterface<E> {
  private MiniList<E> list = new MiniList<E>();

    public MyStack(){
        list = new MiniList<>();
    }  

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.addFirst(element);
    }

    public E pop(){
         if(isEmpty()){
        throw new NoSuchElementException();
    }
    else{
       return list.removeFirst();
    }
    }

    public E peek(){
        
	if(isEmpty()) {
		throw new  NoSuchElementException();
	}
	else {
		return list.getFirst();
	}
    }


}
