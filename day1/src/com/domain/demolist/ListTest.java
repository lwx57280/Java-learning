package demolist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java List 遍历性能效率比较
 * @Author
 * @Date 2019-03-21
 * @Version v1.0
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long t1,t2;
        for (int j=0;j<10000000;j++){
            list.add("aaaaa" + j);
        }

        System.out.println("列出第一次访问方法");
        t1=System.currentTimeMillis();
        for(String tmp:list){
            //System.out.println(tmp);
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:"+(t2-t1)+"(ms)");

        System.out.println("列出第二次访问方法");
        t1=System.currentTimeMillis();
        for (int i=0;i<list.size();i++){
            list.get(i);
        }
        t2 =System.currentTimeMillis();
        System.out.println("Run Time:"+(t2-t1)+"(ms)");


        System.out.println("列出第三次访问方法");
        Iterator<String> iter = list.iterator();
        t1=System.currentTimeMillis();
        while (iter.hasNext()){
            iter.next();
        }
        t2 =System.currentTimeMillis();
        System.out.println("Run Time:"+(t2-t1)+"(ms)");

        System.out.println("完!!!!!");

    }

}
