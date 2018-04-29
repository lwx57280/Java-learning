package com;

import java.math.BigInteger;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Retirement {
    public static void main(String[] args) {
       Locale.setDefault(Locale.ENGLISH);

//        retirement();
//        retirement2();
//        demoFor();

//        lotteryOdds();

//        example();

//        example2();
//        example3();
//        arrayDemo();
//        arrayDemo2();
//        drawing();

//        compoundInterest();

//        lotteryArray();
//        demo();

        demoCalender();

        calendarDemo();
    }


    private static void retirement() {
        Scanner in = new Scanner(System.in);
        // 你需要多少钱才能退休？
        System.out.println("How much money do you nedd to retire?");
        double goal = in.nextDouble();
        // 你每年需要多少钱
        System.out.println("How much money will you need contribute every year?");
        double payment = in.nextDouble();
        // 利率(%)
        System.out.println("Interest rate in%");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            // 加上今年的付款和利息
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("You can retire in " + years + " years。");
    }


    private static void retirement2() {
        Scanner in = new Scanner(System.in);
        // 你每年需要多少钱
        System.out.println("How much money will you need contribute every year?");
        double payment = in.nextDouble();

        // 利率(%)
        System.out.println("Interest rate in%");
        double interestRate = in.nextDouble();

        // 你需要多少钱才能退休？
        System.out.println("How much money do you nedd to retire?");
        double goal = in.nextDouble();

        double balance = 0;
        int year = 0;
        String input = null;
        do {
            // 加上今年的付款和利息
            balance += payment;
            // 利息 = 余额 * 利率(%) /100
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
            System.out.printf("After year %d,your balance is %,.2f%n", year, balance);
            System.out.println("Ready to retire?(Y/N)");
            input = in.next();
        } while (input.equals("N"));
    }

    private static void demoFor() {
        int i;
        for (i = 1; i <= 10; i++) {
            System.out.println("i=:" + i);
        }
        System.out.println();
//        for(int k=10;k>0;k--){
//            System.out.println("k=:"+k);
//        }

        int k = 10;
        while (k > 0) {
            System.out.println("k=:" + k);
            k--;
        }
    }


    private static void lotteryOdds() {
        Scanner in = new Scanner(System.in);
        // 你需要画多少个数字？
        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();
        // 你能画的最高数字是多少？
        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        System.out.println("Your odds are 1 in " + lotteryOdds + " .Good luck!");
    }

    /**
     * 多重选择：Switch语句
     */
    private static void example() {
        Scanner in = new Scanner(System.in);
        System.out.println("Select an option(1,2,3,4)");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                // ....
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                break;
            default:

                break;
        }

    }

    /**
     * 中断控制流语句
     */
    private static void example2() {
        Scanner in = new Scanner(System.in);
        int count;
        int n;
        int sum = 0;
        for (count = 1; count <= 100; count++) {
            System.out.println("Enter a number,-1 to quit:");
            n = in.nextInt();
            if (n < 0)
                continue;
            sum += n;
        }
    }

    /**
     * 大数值演示
     */
    private static void example3() {
        Scanner in = new Scanner(System.in);
        // 你需要画多少个数字？
        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();
        // 你能画的最高数是多少？
        System.out.println("What is the highest number yuo can draw?");
        int n = in.nextInt();

        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");

    }

    /**
     * 数组演示
     */
    private static void arrayDemo() {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            int temp = a[i] = i;
            System.out.println("temp=:" + temp);
        }
    }

    /**
     * 数组初始化以及匿名数组
     */
    private static void arrayDemo2() {
        // 定义数组方式
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
//
//       new int[]{17,19,23,29,31,37};
//
        int[] anonymous = {17, 19, 23, 29, 31, 37};

        smallPrimes = anonymous;
        int[] luckyNumbers = smallPrimes;
        int[] copideLuckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
        for (int i = 0; i < copideLuckyNumbers.length; i++)
            System.out.println("copideLuckyNumbers=:" + copideLuckyNumbers[i]);

    }

    /**
     * 数组排序
     */
    private static void drawing() {
        Scanner in = new Scanner(System.in);
        System.out.println("你要画多少个数字？");
        int k = in.nextInt();
        System.out.println("你能画的最高数字是多少？");
        int n = in.nextInt();
        // 用数字填充数组
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 1;

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // 在0和n-1之间建立一个随机指数。
            int r = (int) (Math.random() * n);
            // 在随机的位置选择元素
            result[i] = numbers[r];
//            将最后一个元素移动到随机位置
            numbers[r] = numbers[n - 1];
            n--;
        }

        // 打印排序数组
        Arrays.sort(result);
        System.out.println("打赌下面的组合会让你发财的！");
        String leftSign = "[";
        String rightSign = "]";
        String temp = leftSign;
        for (int r : result) {
            temp += r + ",";
        }
        temp = temp.substring(0, temp.length() - 1);
        System.out.print(temp + rightSign);
    }


    /**
     * 多维数组
     */
    private static void compoundInterest() {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;
//        将利率定在10...15%
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++)
            interestRate[j] = (STARTRATE + j) / 100.0;
        double[][] balances = new double[NYEARS][NRATES];
//        将利率设定为1000
        for (int j = 0; j < balances[0].length; j++)
            balances[0][j] = 1000;
//        计算未来年份的利息
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
//                从上一排中获得去年的余额
                double oldBalance = balances[i - 1][j];
//                计算利息  余额 * 利率
                double interest = oldBalance * interestRate[j];
                //计算今年的余额
                balances[i][j] = oldBalance + interest;

            }
        }
        //            打印一行利率
        for (int j = 0; j < interestRate.length; j++)
            System.out.printf("%9.0f%%", 100 * interestRate[j]);
        System.out.println();
//        打印表格行
        for (double[] row : balances) {
            for (double b : row)
                System.out.printf("%10.2f", b);
            System.out.println();
        }
    }

    /**
     * 不规则数组
     */
    private static void lotteryArray() {
        final int NMAX = 10;

        // 分配三角阵列
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++)
            odds[n] = new int[n + 1];

        // 填充三角形阵列
        for (int n = 0; n < odds.length; n++)
            for (int k = 0; k < odds[n].length; k++) {
//              计算二项式系数
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                odds[n][k] = lotteryOdds;
            }

        //打印三角形阵列
        for (int[] row : odds) {
            for (int odd : row)
                System.out.printf("%4d", odd);
            System.out.println();
        }
    }

    private static void demo() {
        Date currentDate = new Date();
        String dbStartDate = "2018-04-27 09:10:00";
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date db_date=null;

        try {
            db_date= sDateFormat.parse(dbStartDate);
            System.out.println("db_date=:"+db_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("currentDate=:" + currentDate);
        System.out.println("startDate表示页面参数和db_date表示数据库比较的结果:" + currentDate.after(db_date));
        System.out.println("currentDate.compareTo()=:"+currentDate.compareTo(db_date));
        System.out.println("db_date.compareTo()=:"+db_date.compareTo(currentDate));
    }

    /**
     * 显示当前月的日历
     */
    private static void demoCalender(){
        GregorianCalendar now = new GregorianCalendar();
        int month = now.get(Calendar.MONTH);

        int today = now.get(Calendar.DAY_OF_MONTH);
        // 将now设置为这个月的第一天，并得到这一天为星期几
        now.set(Calendar.DAY_OF_MONTH,1);

        int weekday = now.get(Calendar.DAY_OF_WEEK);
        int firstDayOfweek = now.getFirstDayOfWeek();
        int indent =0;

        while (weekday!=firstDayOfweek){
            indent++;
            now.add(Calendar.DAY_OF_MONTH,-1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
        }
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();

        // 下面的循环将打印星期几的缩写字符串
        do {
            System.out.printf("%4s",weekdayNames[weekday]);
            now.add(Calendar.DAY_OF_MONTH,1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
        }while (weekday!=firstDayOfweek);
            System.out.println();
        for (int i = 1; i <=indent ; i++)
            System.out.print("  ");

        now.set(Calendar.DAY_OF_MONTH,1);
        do {
            // 打印天
            int day = now.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);
            // 标记当前的一天
            if(day==today)
                System.out.print("*");
            else
                System.out.print(" ");

            now.add(Calendar.DAY_OF_MONTH,1);
            weekday = now.get(Calendar.DAY_OF_WEEK);

            // 在本周初开始一个新的路线。
            if(weekday==firstDayOfweek)
                System.out.println();
        }
        while (now.get(Calendar.MONTH)==month);
        //  当d是下个月的第1天时，循环退出。

        if(weekday!=firstDayOfweek)
            System.out.println();

//        Date time = now.getTime();
//        System.out.println("time=:"+time);
//        System.out.println("MONTH=:"+month);
//        System.out.println("weekday=:"+weekday);
    }

    /**
     * Calendar对象日历演示
     */
    private static void calendarDemo(){
        Date currentTime = new Date();

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(currentTime);

        int year = currentDate.get(Calendar.YEAR);
        System.out.println("year=:"+year);
        int month = currentDate.get(Calendar.MONTH)+1;
        System.out.println("month=:"+month);
        int day = currentDate.get(Calendar.DATE);
        System.out.println("day=:"+day+"\n");


        String beginDate ="2018-04-30 09:10:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= null;
        try {
            date = simpleDateFormat.parse(beginDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(date);

        int yearInt = beginCalendar.get(Calendar.YEAR);
        System.out.println("yearInt=:"+yearInt);
        int monthInt = beginCalendar.get(Calendar.MONTH);
        System.out.println("monthInt=:"+monthInt);
        int dayInt = beginCalendar.get(Calendar.DATE);
        System.out.println("dayInt=:"+dayInt);
        //当前时间
        Date oldDate =currentDate.getTime();
        //替换日期
        currentDate.set(yearInt,monthInt,dayInt);
        // 替换新的日期包括时间
//        currentDate.setTime(date);
        Date dateTime = currentDate.getTime();
        String strTime = simpleDateFormat.format(dateTime);

        String oldTime =simpleDateFormat.format(oldDate);
        System.out.println("修改之前currentDate=:"+oldTime);
        System.out.println("修改后strTime=:"+strTime);
    }

}

