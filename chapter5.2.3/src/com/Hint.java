package com;

import java.lang.annotation.*;

/**
 *  Java 8新特性：允许我们把同一个类型的注解使用多次，
 *  只需要给该注解标注一下@Repeatable即可。
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
