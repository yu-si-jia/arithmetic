package arit;

import java.text.DecimalFormat;
import java.util.*;

public class Some {

    /**
     * 将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
     * 然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
     * 然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
     * 样例输入   @!%12dgsa      010111100
     * 样例输出    66.67%
     *
     * @param his
     * @param see
     */
    void stringTest(String his, String see) {
        String transHis = "";
        for (int i = 0; i < his.length(); i++) {
            char c = his.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                transHis = transHis + "1";
            } else {
                transHis = transHis + "0";
            }
        }

        int same = 0;
        for (int i = 0; i < transHis.length(); i++) {
            if (transHis.charAt(i) == see.charAt(i)) {
                same++;
            }
        }

        float out = (float) same * 100 / (float) transHis.length();
        System.out.printf("%.2f%%", out);
    }




    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * @param base     底数
     * @param exponent 次方
     */
    public double power(double base, int exponent) {
        double result = 1;
        int ex = Math.abs(exponent);
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        if (exponent == 0) return result;
        if (exponent > 0) return result;
        return 1 / result;
    }

    public double power2(double base, int exponent) {
        double result = 1;
        if (exponent == 0) return result;
        if (exponent < 0) return 1 / power2(base, -exponent);
        if (base % 2 == 0) return power2(base * base, exponent / 2);
        return power2(base, exponent - 1) * base;
    }



    /**
     * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,
     * 但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
     * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
     * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
     * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,
     * 小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
     * 输入描述:
     * 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
     * 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
     * 输入例子1:
     * 10
     * 输出例子1:
     * 122
     */
    public void getMoney(int nmoney) {
        int sum = 0;
        StringBuffer str = new StringBuffer();
        while (sum != nmoney) {
            if (nmoney % 2 != 0) {
                str = str.append("1");
                nmoney = (nmoney - 1) / 2;
            } else {
                str = str.append("2");
                nmoney = (nmoney - 2) / 2;
            }
        }
        System.out.println(str.reverse());
    }


    /**
     * 输入数组和size 取得size个数的排列组合
     * 例如：{1,2,3,4,5,6,7} size = 3
     * return[1,2,3],[1,3,4].........
     *
     * @author 余思佳
     */
    int[][] groupSplit(int[] arr, int size) {
        return lastArr(arr, 0, size);
    }

    /**
     * @param arr 源数组
     * @param s   所在下标
     * @return 取值
     */
    private int[][] lastArr(int[] arr, int s, int size) {
        if (size < 1) {
            return null;
        }
        int len = 1;
        for (int i = arr.length - s; i > arr.length - s - size; i--) {
            len *= i;
            //i是从第i个位置取，这里指的是从数组的最后一位开始
            //循环终止条件是i最多取到arr.length - s - size个位置，他的组合最开始的位置
        }
        for (int i = 1; i <= size; i++) {
            len /= i;
        }//len算的是组合数
        int[][] result = new int[len][size];
        //定义的result是存储算出来的数字，一共有len个组合数
        int k;
        if (size == 1) {
            k = 0;
            for (int i = s; i < arr.length; i++) {
                result[k][size - 1] = arr[i];
                k++;
            }
            return result;

            //如果要求的是一位数的组合数，就是输出的是原来的一维数组，k是0，size是长度
        }
        k = 0;
        for (int i = s; i < arr.length; i++) {//遍历数组
            int[][] last = lastArr(arr, i + 1, size - 1);//此处的递归调用算出来的last是每一个数字，即往组合数里加的第一个数组
            System.out.println(Arrays.deepToString(last));
            //如果size 是3 的递归求出来的先是size为1，再size为2，最后的result[k][0]=arr[i]是连接的
            if (last != null) {
                for (int[] aLast : last) {
                    System.arraycopy(aLast, 0, result[k], 1, aLast.length);
                    result[k][0] = arr[i];//result[k]里面也是一个数组，arr[i]是取出来的组合数的第一个数
                    //取出来的arr[i]是第一个数字，加到了【0】这个位置
                    //如果要取的size为3的话，复制数组就复制了两个数，再执行循环，把取出来的rr[i]放到第一个位置上
                    System.out.println(Arrays.deepToString(result));
                    k++;
                }
            }
        }
        return result;
    }






    /**
     * 珐达采下个月要去鸥洲各国考察一趟，采购流通神秘石并从中搞点油水。
     * 珐达采会按顺序依次经过序号分别为1, 2, 3, …, n的鸥洲国家，
     * 在第i个国家神秘石的流通价格为Ai鸥。因为行程紧张，在每个国家的停留时间有限，
     * 所以他只能花费Ai鸥买入一块神秘石，或者卖出一块手中的神秘石获得Ai鸥，
     * 或者什么都不做，而且因为神秘石的保存需要极其先进的高级材料容器，
     * 其材料稀有且制作困难，珐达采只有一份容器，故无论何时珐达采手里最多只能拥有一块神秘石。
     * 珐达采想知道最终能从中获利最大多少鸥。
     * 因为交易需要手续费，所以珐达采还想知道在获利最大收益的同时，
     * 最少需要交易多少次。因为珐达采是大财阀，所以你可以认为他一开始金钱无限。
     *
     * @return
     */
    public void duXiaoMan() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        int count = 0;
        long ans = 0;
        boolean flag = false;//用flag判断状态就可以保证买卖次数最优
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {//下一个地方石头贵
                if (!flag) {
                    count += 2;
                }
                ans += arr[i + 1] - arr[i];//利润
                flag = true;//有石头
            } else if (arr[i] > arr[i + 1]) {//下一个地方石头便宜
                flag = false;//卖掉了没石头
            }
        }
        System.out.println(ans + " " + count);
        sc.close();

    }


    void happyNum(int n, String[] numStr) {

        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(numStr[i]);
            boolean one = false, all = true;
            for (int j = 0; j < numStr[i].length(); j++) {
                int c = numStr[i].charAt(j) - 48;
                if (num % c == 0) {
                    one = true;
                } else {
                    all = false;
                }
            }
            if (one && !all) {
                System.out.println("H");
            } else if (!one) {
                System.out.println("S");
            } else if (all) {
                System.out.println("G");
            }
        }
    }

    /**
     * 将空格替换成%20
     *
     * @param str
     * @return
     */
    static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    /**
     * 将任意一个字符串转换为整数
     */
    public double change(String a) {
        char[] str = a.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        double sum = 0;

        if (str[0] > 57 || str[0] < 48) {
            for (int i = 1; i < str.length; i++) {
                if (48 <= str[i] && str[i] <= 57) {
                    stringBuffer = stringBuffer.append(str[i]);
                }
            }
        } else {
            for (int i = 0; i < str.length && 48 <= str[i] && str[i] <= 57; i++) {
                stringBuffer = stringBuffer.append(str[i]);
            }
        }

        String string = stringBuffer.toString();

        for (int i = 0; i < string.length(); i++) {
            sum = sum + Character.getNumericValue(string.charAt(i)) * Math.pow(10, string.length() - i - 1);
        }
        if (str[0] == "-".charAt(0)) {
            sum = sum * -1;
        } else sum = sum * 1;

        return sum;
    }


    /**
     * 牛客网数星星
     */
    public void countStar() {
        {
            Scanner scanner = new Scanner(System.in);
            String[][] big = new String[10000][10000];
            int startNum = scanner.nextInt();
            for (int i = 0; i < startNum; i++) {
                big[scanner.nextInt()][scanner.nextInt()] = "1";
            }
            int question = scanner.nextInt();
            int[] results = new int[question];
            for (int k = 0; k < question; k++) {
                int countStart = 0;
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                for (int a = i; a <= x; a++) {
                    for (int b = j; b <= y; b++) {
                        if (big[a][b] != null) {
                            countStart++;
                        }
                    }
                }
                results[k] = countStart;
            }
            for (int result : results) {
                System.out.println(result);
            }
        }
    }

    /**
     * 两个人随机抽取四张牌，四张牌的数字和最大的取胜
     * （该扑克牌总张数为52张，没有大小王，A=1，J=11，Q=12，K=13，每种数字有四张牌）
     * 现在两人已经分别亮出了自己的前三张牌，牛牛想要知道自己要赢得游戏的概率有多大。
     * 输入描述:
     * 输入包含两行，第一行输入三个整数a1，b1，c1(1≤a1，b1，c1≤13)，表示牛牛亮出的扑克牌。
     * 第二行输入三个整数a2，b2，c2(1≤a2，b2，c2≤13)，表示妞妞所亮出的扑克牌。
     * 输出x（保留4位小数），表示牛牛获胜的概率
     */

    public void pooker() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 13; i++) {
            map.put(i, 4);
        }
        int sum1 = 0;
        int sum2 = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            Integer key = sc.nextInt();
            if (i < 3)
                sum1 += key;
            else
                sum2 += key;

            map.put(key, map.get(key) - 1);//去除掉已经拿出的牌
        }
        int num = 0;
        //M是牛牛要拿的牌
        for (Map.Entry<Integer, Integer> M : map.entrySet()) {
            if (M.getValue() == 0)
                continue;
            map.put(M.getKey(), M.getValue() - 1);//牛牛拿完牌牌数-1
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                //m是妞妞拿的牌
                if (m.getValue() == 0)
                    continue;
                if (m.getKey() + sum2 < M.getKey() + sum1)
                    //牛牛拿的牌+现有的总和大于妞妞的 牛牛赢
                    num += m.getValue() * (M.getValue() + 1);//牛牛可以拿的牌数，当前牌型剩余的牌数+刚刚拿到的那张
            }
            map.put(M.getKey(), M.getValue() + 1);//牛牛拿得牌不能让他赢 放回牌池
        }
        System.out.printf("%.4f\n", num * 1.0 / (46 * 45));
    }


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return head;

        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        if (count < k) return null;

        ListNode resultNode = head;

        for (int i = 0; i < count - k; i++) {
            resultNode = resultNode.next;
        }

        if (resultNode.next != null) return resultNode.next;

        return resultNode;
    }


    /**
     * 输入头结点，反转链表
     *
     * @param head
     * @return 反转链表的头结点
     */
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 反转链表中相邻的两个结点1-2-3-4  ====》2-1-4-3
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode pre = preHead;
        ListNode cur = head;
        ListNode temp;

        while (cur != null && cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = cur;
            cur = cur.next;
        }

        return preHead.next;
    }

    /**
     * 判断单链表是否有环
     *
     * @param head
     * @return
     */
    //做法一
    public boolean hasCycle1(ListNode head) {
        Set addressSet = new HashSet<>();
        ListNode a = head;
        boolean flag = true;
        while (a != null) {
            flag = addressSet.add(a);
            a = a.next;
            if (flag == false) {
                return true;
            }

        }
        return false;
    }

    //做法二
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        if (fast == slow) {
            return true;
        }
        return false;
    }


    /**
     * 给定链表，一次反转链表k的节点并返回其修改后的列表。
     * 如果节点数不是k的倍数，那么最后的剩余节点应该保持不变。
     * 鉴于此链表：1-> 2-> 3-> 4-> 5
     * 对于k = 2，您应该返回：2-> 1-> 4-> 3-> 5
     * 对于k = 3，您应该返回：3-> 2-> 1-> 4-> 5
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        ListNode temp = null;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        int count = len / k;
        while (count-- > 0) {
            int c = k;
            while (c-- > 1) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return first.next;
    }


    /**
     * 获取第k大的元素
     *
     * @return
     */
    class KthLargest {
        int k;
        PriorityQueue<Integer> p;

        public KthLargest(int[] a, int k) {
            this.k = k;
            p = new PriorityQueue<Integer>(k);
            for (int n : a) {
                add(n);
            }
        }

        private int add(int n) {
            if (p.size() < k) {
                p.offer(n);
            } else if (p.peek() < n) {
                p.poll();
                p.offer(n);
            }
            return p.peek();
        }

    }

    /**
     * 滑动窗口最大值
     * 解题思路：采用双端队列，判断窗口内的最大元素，保证队列里放入的永远是最大的
     * 如果新加入的元素大于之前的元素，则直接把之前的所有元素都弹出
     * 在滑动窗口开始的下标大于0的时候，就可以向双端队列里放入元素
     *
     * @param num  数组
     * @param size 滑动窗口的尺寸
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;//滑动窗口第一个元素在数组的下标
        ArrayDeque<Integer> q = new ArrayDeque<>();//保存的也是下标
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;//放入元素时滑动窗口开始的下标
            if (q.isEmpty())
                q.add(i);//加入元素的下标
            else if (begin > q.peekFirst())//下标一直是增大的。判断滑动一次后是否把最大的元素划走，如果划走就删除
                q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                //队列不为空且队列的第一个元素小于新加入的元素，将队列中第一个删除掉，把新元素加入到队列中
                q.pollLast();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);//向结果集中添加每次一滑动窗口的最大值
        }
        return res;
    }

    /**
     * 两数之和
     * 解题思路：采用map结构，主键放元素，值放位置，先判断map中是否有键，没有再放入
     * 可以避免Map结构键不能重复
     * 相当于从后往前，先把前面的元素添加进Map，后面取出来的x计算target-x在前面的元素里是否存在
     *
     * @param numbers 数组
     * @param target  目标
     * @return 两个数加起来等于目标的俩数的下标
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        if (numbers.length < 1) return result;
        for (int i = 0; i < numbers.length; i++) {
            int y = target - numbers[i];
            if (numberMap.containsKey(y)) {
                result[0] = i > numberMap.get(y) ? numberMap.get(y) + 1 : i + 1;
                result[1] = i > numberMap.get(y) ? i + 1 : numberMap.get(y) + 1;
                return result;
            }
            numberMap.put(numbers[i], i);
        }
        return result;
    }

    /**
     * x+y+z=0，题目意思与上相同
     * 解题思路：先将备选元素排序，假设三个数为x,y,z,记录两个指针一个从已排好序的数组左端开始计数left
     * 一个从已排好序的数组右端开始计数right
     * x+y+z>0 则将指向大端的指针right向后走，减小x+y+z的和
     * x+y+z<0 则将指向小端的指针left 向前走，增大x+y+z的和
     *
     * @param num 备选元素
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int x = 0; x < num.length; x++) {
            //优化方式 x=0保证当前元素大于上一个，避免重复元素的重复放入
            if (x == 0 || num[x] > num[x - 1]) {
                int y = x + 1;
                int z = num.length - 1;
                ArrayList<Integer> list = new ArrayList<>();
                while (y < z) {
                    if (num[x] + num[y] + num[z] == 0) {
                        list.add(x);
                        list.add(y);
                        list.add(z);
                        result.add(list);
                        y++;
                        z--;
                        //此条件排除相同元素
                        while (y < z && num[y] == num[y - 1]) {
                            y++;
                        }
                        while (y < z && num[z] == num[z + 1]) {
                            z--;
                        }
                    } else if (num[x] + num[y] + num[z] < 0) {
                        y++;
                    } else {
                        z--;
                    }
                }

            }
        }
        return result;
    }


    /**
     * 贝壳找房
     */
    /**
     * 找到数组中绝对值最小的两个相邻数,返回他们
     *
     * @param arrays
     */
    void getAbsMin(int[] arrays) {
        int minR = arrays[1];
        int minL = arrays[0];
        int min = Math.abs(minR - minL);
        for (int i = 1; i < arrays.length - 1; i++) {
            int curMin = Math.abs(arrays[i + 1] - arrays[i]);
            if (curMin < min) {
                minR = arrays[i + 1];
                minL = arrays[i];
                min = curMin;
            }
        }
        System.out.printf("%d %d\n", minL, minR);
    }

    /**
     * 举重大赛，要求双方最小体重大于等于最大体重的90%，俩俩比赛，求比赛多少场
     *
     * @param num
     * @param weight
     */
    void getCountMach(int num, int[] weight) {
        int count = 0;
        Arrays.sort(weight);
        final float proportion = 0.9f;
        for (int i = 0; i < num; i++) {
            int j = i + 1;
            while (j < num && weight[j] * proportion <= weight[i]) {
                count++;
                j++;
            }
        }
        System.out.println(count);
    }

    /**
     * 一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。
     * 下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
     * 例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。输出长度
     * 解题思路：
     */
    void getLongestASC(int n, int[] arr) {
        int[] longest = new int[n];
        int k = 0;
        longest[k] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > longest[k]) {
                longest[++k] = arr[i];
            } else {
                for (int j = 0; j <= i; j++) {
                    if (longest[j] >= arr[i]) {
                        longest[j] = arr[i];
                        break;
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {

                if (longest[j] > 0) {
                    count++;
                } else {
                    break;
                }
            }
        }

    }

    // TODO: 19-8-23

    /**
     * @Description 小C在做一种特殊的服务器负载测试，对于一个请求队列中的请求，
     * 每一个请求都有一个负荷值，为了保证服务器稳定，请求队列
     * 中的请求负荷必须按照先递增后递减的规律(仅递增，仅递减也可以)，
     * 比如[ 1，2，8，4，3 ]，[ 1，3，5 ]和[ 10 ]这些是满足规律的，
     * 还有一些不满足的，比如[ 1，2，2，1 ]，[ 2，1，2 ]和[ 10，10 ]。
     * 现在给你一个请求队列，你可以对请求的负荷值进行增加，
     * 要求你调整队列中请求的负荷值，使数组满足条件。最后输出使队列满足条件最小的增加总和。
     * <p>
     * 输入 5 2 5 3 2 4
     * 输出 6
     */
    private int minIncre(int n, int[] mm) {
        int[] m = new int[n];
        int res = Integer.MAX_VALUE, i = 0;
        for (int j = 0; j < n; j++) {//假设j为队列的最大值的下标
            int thre = j, min = 0;//thre为顶峰节点的下标,min表示每次循环的最小值
            for (int p = 0; p < n; p++) {
                m[p] = mm[p];
            }
            for (int k = 1; k <= thre; k++) {//最大值左边必须递增
                int temp = m[k - 1];
                if (m[k] <= temp) {
                    min += temp - m[k] + 1;
                    m[k] = temp + 1;
                }
            }
            for (int k = n - 1; k > thre; k--) {//最大值右边必须递减
                int temp = m[k - 1];
                if (m[k] >= temp) {
                    min += m[k] - temp + 1;
                    m[k - 1] = m[k] + 1;
                }
            }
            if (min < res)
                res = min;
        }

        return res;
    }


    /**
     * 给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，
     * 然后将两个数按位对应相加并分别对m取模， 这样显然可以得到一…1个新的m进制下的n位数(可能存在前导0)，
     * 但是这个结果是不唯一的，问题来了，按照这样的操作，能够得到的最大的m进制下的数字是多少呢
     * <p>
     * 输入第一行包含两个正整数n,m分别表示数字含有n位，和在m进制下。
     * 输入第二行和第三行分别包含n个整数，中间用空格隔开，每个整数都在0到m-1之间。每行第i个数表示的是当前数第i位上的数字。
     * 输出包含n个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，如6在2进制下输出3位的结果是1 1 0。
     * 输入：
     * 5 5
     * 4 4 1 1 1
     * 4 3 0 1 2
     * 输出：
     * 4 4 3 3 2
     */

    public void getNum() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Integer> listA = new ArrayList<>(n);
            List<Integer> listB = new ArrayList<>(n);
            List<Integer> res = new ArrayList<>(n);

            for (int i = 0; i < 2 * n; i++) {
                if (i < n)
                    listA.add(scanner.nextInt());
                else
                    listB.add(scanner.nextInt());
            }
            //贪心法，假设m为5，则尽可能的多构造4，其次是3、2、1，直到集合listA为空   结束循环
            int redu = 1;//表示构造的是4  m-redu表示要构造的最大数
            while (!listA.isEmpty()) {
                Iterator iterator = listA.iterator();
                while (iterator.hasNext()) {
                    int integer = (int) iterator.next();
                    int dif = m - integer - redu;//两数相加小于m的情况
                    int dif2 = m - integer + m - redu;//两数相加大于m的情况
                    if (listB.contains(Integer.valueOf(dif))) {
                        iterator.remove();
                        listB.remove(Integer.valueOf(dif));
                        res.add(m - redu);
                    } else if (listB.contains(Integer.valueOf(dif2))) {
                        iterator.remove();
                        listB.remove(Integer.valueOf(dif2));
                        res.add(m - redu);
                    }
                }
                redu++;//上个最大的数构造完毕，继续构造小一点的数
            }
            System.out.println(res);
        }

    }


    /**
     * 给定括号对数n生成有效括号
     *
     * @param n
     */
    public void getBrackets(int n) {
        List<String> result = new ArrayList<>(2 * n);
        System.out.println(_getBrackets("", result, n, n));
    }

    private List<String> _getBrackets(String subStr, List<String> result, int right, int left) {
        if (right == 0 && left == 0) {
            result.add(subStr);
            return result;
        }
        if (left > 0) {
            _getBrackets(subStr + "(", result, right, left - 1);
        }
        if (right > left) {
            _getBrackets(subStr + ")", result, right - 1, left);
        }
        return result;
    }

    /**
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * 给定一个字符串str和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
     * "(()())",6
     * 返回：true
     *
     * @param str
     * @param n
     * @return
     */
    public boolean chkParenthesis(String str, int n) {
        if (str.length() != n || str == null) return false;
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '(') {
                stack.push(a);
            } else if (a == ')') {
                if (stack.empty()) return false;
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.empty()) return true;
        return false;
    }

    public void getSize(String line) {
        String[] nums = line.split(",");
        Set<Integer> set = new HashSet<>(nums.length);
        for (String num : nums) {
            set.add(Integer.valueOf(num));
        }
        System.out.println(set.size());
    }

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}


