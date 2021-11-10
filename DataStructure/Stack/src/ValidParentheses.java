/**
 * 使用栈完成括号的匹配
 */

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //栈的特点是后进先出  {[()]}
            //如果是要匹配的话，应该是左边的先进去
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tempChar = stack.pop(); //把最顶端的拿出来
                if ((c == ')' && tempChar != '(') || (c == '}' && tempChar != '{') || (c == ']' && tempChar != '[')) {
                    return false;
                }

            }
        }
        //循环走完后，还没有return FALSE的话，这时候要看stack是否全部匹配上（即是否为空）
        return stack.isEmpty();
    }
}
