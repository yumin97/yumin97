package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_1918_후위표기식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        // Stack<Character> Alphabet = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        // boolean flag = false;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            switch (c){
                case '*':
                case '+':
                case '-':
                case '/':
                    while (!symbol.isEmpty() && priority(c) <= priority(symbol.peek()) ){
                        sb.append(symbol.pop());
                    }
                    symbol.push(c);
                    break;
                case '(':
                    symbol.push(c);
                    break;
                case ')':
                    while (!symbol.isEmpty() && symbol.peek() != '('){
                        sb.append(symbol.pop());
                    }
                    if(!symbol.isEmpty()){
                        symbol.pop();
                    }

                    break;
                default:
                    sb.append(c);
                    break;
            }
        }

        while(!symbol.isEmpty()){
            sb.append(symbol.pop());
        }

        System.out.println(sb);
    }

    public static int priority(char now){

        if(now == '*' || now == '/'){
            return 2;
        }
        else if(now == '+' || now == '-'){
            return 1;
        }
        else {
            return 0;
        }
    }
}
