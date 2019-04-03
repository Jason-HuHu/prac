package com.huxl.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {

	final static String salutation = "hello";

	public static void main(String [] args) {
		//方法引用 ：：

		List<String> nameList = new ArrayList<String>();
		nameList.add("name1");
		nameList.add("name2");
		nameList.add("name3");

		nameList.forEach(System.out :: println);
	Main ma = new Main();

	//带有类型声明的表达式（括号中的参数直接给出了类型）
	MathOperation addOperation = (int a, int b) -> a + b;

	//没有类型声明的表达式
	MathOperation subtraction = (a , b) -> a - b;

	//带有大括号，带有返回语句的表达式
	MathOperation multiplication = (int a, int b) -> { return a * b; };

	//没有大括号和return语句的表达式
	MathOperation division = (a ,b) ->  a / b;

	System.out.print("10 + 5 = " );

	ma.operation(10, 5, addOperation);


	//没有括号的表达式
	GreetingService sayMessage = message ->
			System.out.print(salutation + message);

	sayMessage.sendMessage("nihao lambda");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sendMessage(String message);
	}

	private void operation(int arg1, int arg2, MathOperation mathOperation) {
		System.out.println(mathOperation.operation(arg1,arg2));
	}
}
