package com.gain.spring.springstart.dto;

public class UserDto {
    private String name;
    private String email;
    private String password;
    private int age;

    public UserDto (String name, String password,  String email, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public UserDto() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return "UserDto(" + "name: " + name +
                ", email: " + email + ", age:" + age + ")";
    }

}
