package Stack;

import java.util.EmptyStackException;

public class SsafyStack<E> implements IStack<E> {
	
	private Node<E> top;

	@Override
	public void push(E e) { // top으로 넣기
		top = new Node<E> (e, top);
	}

	@Override
	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		
		return top == null;
	}

	@Override
	public int size() {
		int count = 0;
		
		for(Node<E> temp = top; temp != null; temp = temp.link) ++count;
		
		return count;
	}

}
