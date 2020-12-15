package com.btc.connect.demo;

import com.alibaba.fastjson.JSONObject;

public class JSONDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
        Student student = new Student();
        student.setName("Arry");
        student.setAge(19);
        student.setSex("female");

        System.out.println("学生姓名："+student.name);
        System.out.println("学生年龄："+student.age);
        System.out.println("学生性别："+student.sex);

        //序列化操作
        JSONObject object = (JSONObject) JSONObject.toJSON(student);
        String objStr = object.toJSONString();
        System.out.println(object.toString());

        //反序列化操作
        Student Arry = JSONObject.parseObject(objStr, Student.class);
        System.out.println(Arry.name);

        //第二章序列化的方式
        //例如：实例化一个程序员实例json格式
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Ander");
        jsonObject.put("sex","female");
        jsonObject.put("favour","reading");
        jsonObject.put("languages","java,go,nodejs,js,py");
        String coderJson = jsonObject.toJSONString();
        System.out.println(coderJson);

    }
    static class Student {
        private String name;
        private int age;
        private String sex;

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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
