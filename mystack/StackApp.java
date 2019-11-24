package Practice.mystack;

import java.util.Scanner;

public class StackApp {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 스택 저장 공간의 크기 입력 >>");
        int size = sc.nextInt();

        MyStack myStack = new MyStack(size);
        while(true) {
            System.out.print("문자열 입력 >> ");
            String commend = sc.next();
            if(commend.equals("그만")) {
                break;
            } else {
                myStack.push(commend);
            }
        }

        while(myStack.isNotEmpty()) {
            System.out.println(myStack.pop());
        }

        System.out.println("end");
    }
}