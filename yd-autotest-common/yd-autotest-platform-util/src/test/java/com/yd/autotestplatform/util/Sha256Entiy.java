package com.yd.autotestplatform.util;

/**
 * <p>
 *  用于签名的测试类
 * </p>
 * 性别
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 14:39
 * @Email: 664720125@qq.com
 */
public class Sha256Entiy {
    public String name;
    public int age;
    public String gender;
    public String sign;

    public String getName() {
        return name;
    }

    public Sha256Entiy setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Sha256Entiy setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Sha256Entiy setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public Sha256Entiy setSign(String sign) {
        this.sign = sign;
        return this;
    }

    @Override
    public String toString() {
        return "Sha256Entiy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
