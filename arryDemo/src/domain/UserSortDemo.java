package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserSortDemo {
    public static void main(String[] args) {

//        List<User> list = new ArrayList<>(Arrays.asList(new User(1, "用户-1"),
//                new User(2, "用户-2"),
//                new User(3, "用户-3"),
//                new User(4, "用户-4")));

        List<User> list = new ArrayList<User>() {{
            add(new User(6, "用户-6"));
            add(new User(1, "用户-1"));
            add(new User(4, "用户-4"));
            add(new User(5, "用户-5"));
            add(new User(2, "用户-2"));
            add(new User(3, "用户-3"));
        }};
        //按id从小到大
        List<User> userList = list.stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());
        userList.forEach(user -> System.out.println(user));
        System.out.println("============userList================");
        //按id从大到小
        List<User> sortUser = list.stream().sorted((u1, u2) -> u2.getId().compareTo(u1.getId())).collect(Collectors.toList());
        sortUser.forEach(user -> System.out.println(user));
    }
}
