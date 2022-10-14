package com.springbook.biz;


public class test {

	public static void main(String[] args) {
		
		String answer = "";
		
		String my_string = "I love you";
		int num1 = 3;
		int num2 = 6;

		String[] arr = my_string.split("");
		
		String tmp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = tmp;
		
		for(int i=0;i<arr.length;i++) {
			answer += arr[i];
		}
		
		
		System.out.println(answer);
	}

}
