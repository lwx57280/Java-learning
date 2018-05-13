package math.oper;

/**
 * @Description: 算术运算符
 * @Author: yc
 * @CreateDate: 2018/5/13 17:36
 * @UpdateUser: yc
 * @UpdateDate: 2018/5/13 17:36
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SuppressWarnings("CheckStyle")
public class Operator {
    /*
*   +	加法 - 相加运算符两侧的值	A + B 等于 30
*   -	减法 - 左操作数减去右操作数	A – B 等于 -10
*   *	乘法 - 相乘操作符两侧的值	A * B等于200
*   /	除法 - 左操作数除以右操作数	B / A等于2
*   ％	取模 - 左操作数除以右操作数的余数	B%A等于0
*   ++	自增: 操作数的值增加1	B++ 或 ++B 等于 21（区别详见下文）
*   --	自减: 操作数的值减少1	B-- 或 --B 等于 19（区别详见下文）
*/
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));
        System.out.println("b % a = " + (b % a));
        System.out.println("c % a = " + (c % a));

        System.out.println("a++ = " + (a++));
//        System.out.println("++a = " + (++a));
        System.out.println("a-- = " + (a--));
        // 查看 d++ 与 ++d 的不同
        System.out.println("d++ = " + (d++));
        System.out.println("++d = " + (++d));
        System.out.println("===========================");
        selfAddMinus();
    }
    /**
    * 自增（++）自减（--）运算符是一种特殊的算术运算符，
     * 在算术运算符中需要两个操作数来进行运算，而自增自减运算符是一个操作数。
    * @author      作者姓名 No such property: code for class: Script1
    * @return
    * @exception   
    * @date        2018/5/13 17:57
    */
    public  static void selfAddMinus(){
        int a =3;   //定义一个变量
        int b=++a;  // 自增运算
        int c=3;
        int d=--c;  //自减运算

        System.out.println("进行自增运算后b的值等于"+b);
        System.out.println("进行自减运算后d的值等于"+d);
        System.out.println("===========================");
        selftAddMinus2();
    }
    /**
    * 2、前缀自增自减法(++a,--a): 先进行自增或者自减运算，再进行表达式运算。
     * 3、后缀自增自减法(a++,a--): 先进行表达式运算，再进行自增或者自减运算 实例：
    * @author      作者姓名 No such property: code for class: Script1
    * @return      
    * @exception   
    * @date        2018/5/13 18:00
    */
    public static void selftAddMinus2(){
        int a = 5;//定义一个变量；
        int b = 5;
        int x = 2*++a;
        int y = 2*b++;
        System.out.println("自增运算符前缀运算后a="+a+",x="+x);
        System.out.println("自增运算符后缀运算后b="+b+",y="+y);
        System.out.println("===========================");
        relationArithmetic();
    }
    /**
    * 关系运算符
    * @author      作者姓名 No such property: code for class: Script1
    * @return      
    * @exception   
    * @date        2018/5/13 18:04
    */
    public static void relationArithmetic(){

//  运算符	描述	                                                            例子
//  ==	检查如果两个操作数的值是否相等，如果相等则条件为真。	            （A == B）为假(非真)。
//  !=	检查如果两个操作数的值是否相等，如果值不相等则条件为真。	         (A != B) 为真。
//  > 	检查左操作数的值是否大于右操作数的值，如果是那么条件为真。	        （A> B）非真。
//  < 	检查左操作数的值是否小于右操作数的值，如果是那么条件为真。	        （A <B）为真。
//  >=	检查左操作数的值是否大于或等于右操作数的值，如果是那么条件为真。	（A> = B）为假。
//  <=	检查左操作数的值是否小于或等于右操作数的值，如果是那么条件为真。	（A <= B）为真。

        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );
        System.out.println("===========================");
        bitwiseArithmetic();
    }
    /**
    * 位运算符
    * @author      作者姓名 No such property: code for class: Script1
    * @return      
    * @exception   
    * @date        2018/5/13 18:09
    */
    public static void bitwiseArithmetic(){
        int a = 60;         /* 60 = 0011 1100 */
        int b = 13;         /* 13 = 0000 1101 */
        int c = 0;
        c = a & b;          /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );
        c = a | b;          /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );
        c = a ^ b;          /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );
        c = ~a;             /*-61 = 1100 0011 */
        System.out.println("~a = " + c );
        c = a << 2;         /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );
        c = a >> 2;         /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );
        System.out.println("===========================");

        logic();
    }
    /**
    * 逻辑运算符
    * @author      作者姓名 No such property: code for class: Script1
    * @return      
    * @exception   
    * @date        2018/5/13 18:16
    */
    public static void logic(){
        boolean a = true;
        boolean b = false;
        System.out.println("a && b = " + (a&&b));
        System.out.println("a || b = " + (a||b) );
        System.out.println("!(a && b) = " + !(a && b));
    }
}
