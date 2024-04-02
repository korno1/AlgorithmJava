package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.xml.crypto.NodeSetData;

public class CompleteBinaryTree<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size + 1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if(isEmpty()) return ;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(nodes[current]);
			
			if(current * 2 <= lastIndex) {
				queue.add(current * 2);
			}
			if(current * 2 + 1 <= lastIndex) {
				queue.add(current * 2 + 1);
			}
			
		}
	}
	
	public void dfsByPreorder() {
		if(isEmpty()) return ;
		System.out.println("===preorder===");
		dfsByPreorder(1);
		System.out.println();
	}
	
	private void dfsByPreorder(int current) { // 전위 순회

		System.out.print(nodes[current] + " ");
		// 왼쪽 자식노드
		if(current * 2 <= lastIndex) {
			dfsByPreorder(current * 2);
		}
		// 오른쪽 자식노드
		if(current * 2 + 1 <= lastIndex) {
			dfsByPreorder(current * 2 + 1);
		}
	}
	public void dfsByInorder() {
		if(isEmpty()) return ;
		System.out.println("===inorder===");
		dfsByInorder(1);
		System.out.println();
	}
	
	private void dfsByInorder(int current) { // 중위 순회
		
		// 왼쪽 자식노드
		if(current * 2 <= lastIndex) {
			dfsByInorder(current * 2);
		}
		System.out.print(nodes[current] + " ");
		// 오른쪽 자식노드
		if(current * 2 + 1 <= lastIndex) {
			dfsByInorder(current * 2 + 1);
		}
	}
	public void dfsByPostorder() {
		if(isEmpty()) return ;
		System.out.println("===Postorder===");
		dfsByPostorder(1);
		System.out.println();
	}
	
	private void dfsByPostorder(int current) { // 후위 순회
		if (current > lastIndex) return ;
		// 왼쪽 자식노드
		if(current * 2 <= lastIndex) {
			dfsByPostorder(current * 2);
		}
		System.out.print(nodes[current] + " ");
		// 오른쪽 자식노드
		if(current * 2 + 1 <= lastIndex) {
			dfsByPostorder(current * 2 + 1);
		}
	}
}
