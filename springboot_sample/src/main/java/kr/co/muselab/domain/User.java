package kr.co.muselab.domain;

/**
 * Created by 1002428 on 15. 6. 23..
 */
public class User {
    private String  id;
    private String  name;
    private int     age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
