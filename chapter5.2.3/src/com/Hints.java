package com;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 定义一个包装类Hints注解用来放置一组具体的Hint注解
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface  Hints {
    Hint[] value();
}
