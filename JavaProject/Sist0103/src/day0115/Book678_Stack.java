package day0115;

import java.util.Stack;

public class Book678_Stack {

	public static void main(String[] args) {
		Stack<Coin> cb = new Stack<Coin>();
		
		cb.push(new Coin(100));
		cb.push(new Coin(50));
		cb.push(new Coin(500));
		cb.push(new Coin(10));

		while(!cb.isEmpty()) {
			Coin coin = cb.pop();
			System.out.println("꺼내온 동전: " + coin.getValue() +"원");
		}
	}

}
