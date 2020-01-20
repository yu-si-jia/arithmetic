package arithstudy;

import java.util.Scanner;

public class ExeOne {
    /**
     *
     * 阶乘算法应用递归，因为n!= 1*2*3*....*(n-1)*n
     * 如果要算n 的阶乘就要算n-1的阶乘，并依次类推，算出的结果用于在此计�?
     *
     * @param n
     * @return
     */
    //求N个数的阶�?
    //算法�?：�?�归算法
    private static long Fac1(long n)
    {
        if (n == 0)
        {
            return 1;
        }
        else
        {
            return n * Fac1(n - 1);
        }
    }

    //算法二：递归算法
    private static long Fac2(long n)
    {
        int result = 1;

        for (int i = 1; i <= n; i++)
        {
            result = result * i;
        }

        return result;
    }




    /**
     * 古典问题：有�?对兔子，从出生后�?3个月起每个月都生�?对兔子，
     * 小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子�?�数为多少？  
     * 1.程序分析�?   兔子的规律为数列1,1,2,3,5,8,13,21....  
     * @param m
     * @return
     */
    public static int fun_1(int m){
        if(m==1||m==2){
            return 1;
        }else{
            return fun_1(m-1)+fun_1(m-2);
        }
    }
    //这个和循环在�?起我认为作用相当于�?�归，让它作为月份加，可以算出第I个月应该有的兔子
    public static void fun_2(int m){//如果是前两个月直接就是输出兔子数，并且让I自加和要算的月数相比
        int s1 = 1;
        int s2 = 1;
        int i = 1;
        while(true){
            if(i==1||i==2){
                System.out.println(i+"个月兔子数为�?" + s1);
                i++;
            }else if(i<=m){
                s1 = s1 + s2;
                s2 = s1 + s2;
                System.out.println(i+"个月兔子数为�?" + s1);
                i++;
                System.out.println(i+"个月兔子数为�?" + s2);
                i++;
            }else break;
        }
    }

    public static int fun_3(int m){
        int s1 = 1;
        int s2 = 1;
        for(int i = 3;i<=m;i++){
            int t = s1;
            s1 = s2;
            s2 = s2+t;//s2=现有的小兔兔+新出生的小兔�?
        }
        return s2;
    }

    /**
     *
     * 判断101-200之间有多少个素数，并输出�?有素数�??  
     * 判断素数的方法：用一个数分别去除2到sqrt(这个�?)，如果能被整除，  
     * 则表明此数不是素数，反之是素数�??  
     */
    public static boolean prime(int i){
        for(int j=2;j<Math.sqrt(i);j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 打印出所有的 "水仙花数 "，所�? "水仙花数 "是指�?个三位数，其各位数字立方和等于该数本身�??
     * 例如�?153是一�? "水仙花数 "，因�?153=1的三次方�?5的三次方�?3的三次方�?  
     * 程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位�??
     */
    public static boolean narcissistic(int x){
        int a = x/100;
        int b = (x%100)/10;
        int c = x%10;
        if(a*a*a+b*b*b+c*c*c==x){
            return true;
        }
        return false;
    }

    /**
     * 编写�?个Java程序，用if-else语句判断某年份是否为闰年�?
     *
     */
    public static void leapYear(){
        System.out.println("请输入一个年份：");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        if(year%4==0&&year%100!=0){
            System.out.println(year+"是闰�?");
        }else{
            System.out.println(year+"不是闰年");
        }
    }
    /**
     * 编写�?个Java程序在屏幕上输出1�?+2�?+3�?+…�??+10！的和�??
     */

    public static void add(){
        int i,j,sum,result=0;
        for(i=1 ; i<11 ;i++){
            sum = 1;
            for(j=1 ;j<i ;j++){
                sum*=j;
            }
            result+=sum;
        }
        System.out.println(result);
    }

    /**
     *题目：将�?个正整数分解质因数�?�例如：输入90,打印�?90=2*3*3*5�?
     *程序分析：对n进行分解质因数，应先找到�?个最小的质数k，然后按下述步骤完成�?
     *(1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可�?
     *(2)如果n<>k，但n能被k整除，则应打印出k的�?�，并用n除以k的商,作为新的正整数n,重复执行第一步�??
     *(3)如果n不能被k整除，则用k+1作为k的�??,重复执行第一步�??
     */
    public static int yinshu(int n){
        int k=2;
        while(k<n+1){
            if(n%k==0){
                System.out.print(k+"*");
                return yinshu(n/k);
            }
            if(n%k!=0){
                k=k+1;
            }
        }
        return 0;
    }



    /**
     * 输入两个正整数m和n，求其最大公约数和最小公倍数�?
     * 辗转相除�?
     */
    public static void getNumber(int a,int b){

        int x = a>b?a:b;
        int y = a<b?a:b;
        int yueshu = 1;
        int beishu = x*y;
        int c = 1;
        while(x!=0){
            c=x%y;
            y=x;
            x=c;
        }
        yueshu = y;
        beishu /=y;
        System.out.println("约数"+yueshu);
        System.out.println("倍数"+beishu);
    }



    /**
     * 输入�?行字符，分别统计出其中英文字母�?�空格�?�数字和其它字符的个数�??
     */

    public static void sumString(String str){
        int snum = 0;
        int a_ = 0;
        int b = 0;
        int so = 0;
        char[] st = str.toCharArray();
        for(int i = 0;i<st.length;i++){
            if('A'<=st[i]&&st[i]<='Z'||'a'<=st[i]&&st[i]<='z'){
                b++;
            }else if('1'<=st[i]&&st[i]<'9'){
                snum++;
            }else if(st[i]==' '){
                a_++;
            }else
                so++;
        }
        System.out.println("英文字母" + b+"空格" +a_+"数字"+snum+"其他"+so);
    }

    /**
     * 打印等腰三角�?
     */

    public static void Triangle(int x){
        for(int i = 0;i<x-1;i++){
            for(int j = 0;j<=x+i-1;j++){
                if(j==x+i-1||j==x-i-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=0;i<x;i++){
            System.out.print("* ");
        }
    }


    /**
     * 题目：求s=a+aa+aaa+aaaa+aa...a的�?�，其中a是一个数字�??
     * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制�?�  �?
     */
    public static void addNumber(String input){
        int s=0;
        String output="";
        for(int i =1;i<=Integer.parseInt(input);i++)
        {
            output+=input;
            int a=Integer.parseInt(output);
            s+=a;
        }
        System.out.println(s);
    }

    /**
     * 题目：一个数如果恰好等于它的因子之和，这个数就称�? "完数 "�?
     * 例如6=1�?2�?3.编程     找出1000以内的所有完数�?�  �?
     */
    public static void wanshu(){
        int sum ;
        int i;
        for(i = 1;i<1000 ; i++){
            sum = 0;
            for(int n = 1;n<=i/2;n++){
                if(i%n==0){
                    sum += n;
                }
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
    /**
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的�?半；
     * 再落下，求它在   �? �?10次落地时，共经过多少米？�?10次反弹多高？
     */
    public static void freeFall(int height,int times){
        float sum=100;
        for(int i=0;i<times;i++){
            sum+=height;
            height=height/2;
        }
        System.out.println(times+"走过的路�?"+sum);
    }
    /**
     * �?1�?2�?3�?4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？  �?
     */


    /**
     * 题目：一个整数，它加�?100后是�?个完全平方数，再加上168又是�?个完全平方数，请问该数是多少？  �?
     */
    public static void num(){
        int i,j,k;
        for(i=0;i<1000;i++){
            for(j=10;j<100;j++){
                for(k=13;k<100;k++){
                    if(i+100==j*j&&j+168==k*k){
                        System.out.println(i);
                    }
                }
            }
        }
    }


    /**
     * 题目：打印出杨辉三角形（要求打印�?10行如下图）     �?
                 1   
               1    1   
             1    2    1   
           1    3    3    1   
         1    4    6    4    1   
     1    5    10    10    5    1  
     * @return
     */
    public static void pascalTriangle(int h){
        int arr[][] = new int[h][];
        for(int i = 0;i<arr.length;i++){
            arr[i] = new int[i+1];
            for(int j = 0;j<=i;j++){
                if(j==0||j==i||i==0){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }



    /**
     * 统计字符串中出现�?多的字母，并且打印位�?
     */
    public static void stringCount(String s){
        char maxc = 0;
        int t;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            t = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    t++;
                }
                if (t > max) {
                    maxc = s.charAt(i);
                    max = t;
                }
            }
        }
        for (int i = 0; i < s.length();i++) {
            if(s.charAt(i)==maxc){
                System.out.print(i + "  ");
            }
        }
        System.out.println(maxc);
    }

    public static boolean isPrime(int N){
        if(N<2) return false;
        for(int i = 2 ; i*i<N ; i++){
            if(N%i==0) return false;
        }
        return true;
    }
}
