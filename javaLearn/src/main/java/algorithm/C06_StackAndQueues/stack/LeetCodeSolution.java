package algorithm.C06_StackAndQueues.stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodeSolution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {   // 一开头总得以'('、'['、'{'开始才能往下走，否则这个字符串从一开始就可判定FALSE
                    return false;
                }

                // stack 不为空，那说明左括号还是有进去的
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if(c=='}'&&topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 后面若多出来一个括号那也是FALSE
    }

    public static void main(String[] args) {
        System.out.println((new LeetCodeSolution()).isValid("([{}])"));
        System.out.println((new LeetCodeSolution()).isValid("()[]{}}"));
        System.out.println((new LeetCodeSolution()).isValid("()[]{"));


    }
}
