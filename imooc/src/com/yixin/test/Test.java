package com.yixin.test;

import java.util.*;

import com.yixin.action.Action;
import com.yixin.model.Goddess;



public class Test {

    public static void main(String[] args) throws Exception {

        Action action = new Action();

        /* 查询
        List<Goddess> result = action.query();

        for (int i = 0; i < result.size() ; i++) {
            System.out.println(result.get(i).getId() + "," + result.get(i).getUser_name());
        }
        */


        Goddess g = new Goddess();

        g.setUser_name("王福");
        g.setSex(0);
        g.setEmail("ooooo@ss.com");
        g.setMobile("44444444444");
        g.setBirthday(new Date());
        g.setAge(20);
        g.setIsdel(1);
        g.setId(10);


//        新增
//        action.add(g);

//        修改
//        action.edit(g);

//        删除
//        action.del(7);

//        GET
//        System.out.println(action.get(1).toString());

        List<Map<String,Object>> params = new ArrayList<Map<String, Object>>();
        Map<String ,Object> map = new HashMap<String, Object>();

        map.put("name","user_name");
        map.put("rela","=");
        map.put("value","'王福'");
        params.add(map);

        List<Goddess> res = action.query(params);

        for (Goddess goddess : res) {
            System.out.println(goddess.getUser_name() + " , " + goddess.getAge());
        }

        System.out.println( );







    }
}
