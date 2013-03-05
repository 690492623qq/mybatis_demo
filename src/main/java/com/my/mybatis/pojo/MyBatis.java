package com.my.mybatis.pojo;

/**
 * Created by User
 * Location Path : com.my.mybatis.pojo
 * User: jianyuan.yang
 * Date: 13-2-23
 * Time: 下午7:49
 */
public class MyBatis {
    
    private int id ;
    private String name ;
    private String age ;
    private String sex ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
       
    public String toString(){
       return String.format("name : %s,age :%s ,sex :%s",name,age,sex);
    }
}
