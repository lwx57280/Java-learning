package com;

public class Milk {

    public static final String name="纯牛奶";

    private static int num =16;

    public Milk() {
        System.out.println(name + "：16/每箱");
    }
    /**
     * 闭包
     * 接口是不可以被new的，但是有一种写法是 new Active(){}，
     * 似乎是接口被new了，其实不然，注意后面的{}，这其实是匿名内部类。
     * @return 返回一个喝牛奶的动作
     */
    public Active haveMeals(){
        return new Active() {
            @Override
            public void drink() {
                if(num==0){
                    System.out.println("木有了，都被你丫喝完了.");
                    return;
                }
                num--;
                System.out.println("喝掉一瓶牛奶");
            }
        };
    }

    /**
     * 获取剩余数量
     */
    public void currentNum() {
        System.out.println(name + "剩余：" + num);
    }
}
