package model;

import java.io.Serializable;

public class User implements Serializable {
    private static long serialUID = 123456789;
    public static int INDEX = 0;
    private int id;
    private String name;
    private String gmail;
    private int age;
    private String address;
    private int phoneNumber;
    private int status;

    public User(String name, String gmail, int age, String address, int phoneNumber) {
        this.id = ++INDEX;
        this.name = name;
        this.gmail = gmail;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = 1;
    }

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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
