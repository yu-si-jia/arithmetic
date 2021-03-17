package arithstudy;

import java.util.Stack;

/**
 * @author andor
 * @date 2021/3/10
 * @desc 224. 基本计算器
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> sign = new Stack<>();
        sign.push(1);
        int ans=0,num = 0, op=1;
        for (char a :s.toCharArray()){
            if (a ==' ') continue;
            if ('0'<=a &&a<='9'){
                num = num*10 + (a-'0');
                continue;
            }
            ans += op*num;
            num=0;
            if (a=='+'){
                op = sign.peek();
            }else if (a=='-'){
                op = -sign.peek();
            }else if (a=='('){
                sign.push(op);
            }else if (a==')'){
                sign.pop();
            }
        }
        ans += op*num;
        return ans;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.calculate("1 + 1");
    }
}

