package Stack;

public class StackTest {

	public static void main(String[] args) {
		IStack<String> stk = new SsafyStack<>();
		
		stk.push("123");
		stk.push("124");
		stk.push("125");
		stk.push("126");
		stk.push("127");
		stk.push("128");
		stk.push("129");
		stk.push("130");
		stk.push("131");
		stk.push("132");
//		System.out.println(stk.peek());
		System.out.println(stk.size());
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
		stk.pop();
		System.out.println(stk.size());
	}

}
