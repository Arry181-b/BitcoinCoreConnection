package com.btc.connect.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        //Map: key --> value
        //向map中存数据
        Map<String,String> map = new HashMap();
        map.put("name","Arry");
        map.put("age","19");
        map.put("sex","female");

        //从map中取数据， 如何取出全部
//        String name = map.get("name");
//        System.out.println(name);
        Set<String> keys = map.keySet();  //把全部key取出来
        for(String key: keys){
            System.out.println(key);
            String value = map.get(key);//根据key取值
            System.out.println(value);
        }

    }
}
