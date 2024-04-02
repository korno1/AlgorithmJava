package BinaryTree;

public class Test {

	public static void main(String[] args) {
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(10);
		for(int i=0; i<10; i++) {
			tree.add((char)(65+i));
		}
//		
//		tree.add('K');
//		tree.bfs();
		tree.dfsByPreorder();
		tree.dfsByInorder();
		tree.dfsByPostorder();
	}

}
