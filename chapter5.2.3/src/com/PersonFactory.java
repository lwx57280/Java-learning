package com;

/**
 * 创建Person对象的对象工厂接口：
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName,String lastName);
}
