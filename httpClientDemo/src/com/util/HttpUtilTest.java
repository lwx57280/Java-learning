package com.util;

import java.util.regex.Pattern;

public class HttpUtilTest {

    public static void main(String[] args) {

        final String URL_REGEX = "\t^\\\\{2}[\\w-]+\\\\(([\\w-][\\w-\\s]*[\\w-]+[$$]?$)|([\\w-][$$]?$))";

        final String REGEX = "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";

        final String reg = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

        String url = "http://www.youku.com/";

        String url1 = "https://www.baidu.com/";

        String url3 = "http://w.xx.com";
        String url4 = "ssss";
        //String response = HttpUtil.doGet(url);

        boolean validateUrl = Pattern.matches(REGEX, url1);

        System.out.println("validateUrl=:" + validateUrl);
        String response = HttpUtilTool.doGet(url1, null);
        System.out.println("response=:" + response);
    }
}
