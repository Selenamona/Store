package com.yixin.action;

import com.yixin.come.GoddessCome;
import com.yixin.model.Goddess;

import java.util.*;

public class Action {

    public void add (Goddess goddess) throws Exception {
        GoddessCome come = new GoddessCome();
        come.addGodess(goddess);
    }

    public void del (Integer id) throws Exception {
        GoddessCome come = new GoddessCome();
        come.delGodess(id);

    }

    public void edit (Goddess goddess) throws Exception {
        GoddessCome come = new GoddessCome();
        come.updateGodess(goddess);
    }

    public Goddess get (Integer id) throws Exception {
        GoddessCome come = new GoddessCome();
        return come.get(id);
    }

    public List<Goddess> query() throws Exception {
        GoddessCome come = new GoddessCome();
        return come.query();

    }

    public List<Goddess> query (List<Map<String,Object>> params) throws Exception {

        GoddessCome come = new GoddessCome();
        return come.query(params);
    }



    /*
    public static void main(String[] args) throws Exception {

        GoddessCome g = new GoddessCome();

//        查询多个， List
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();

        Map<String,Object> param = new HashMap<String, Object>();

        param.put("name","user_name");
        param.put("rela","=");
        param.put("value","'小美'");
        params.add(param);

        List<Goddess> gs = g.query(params);
        for (int i = 0; i < gs.size() ; i++) {
            System.out.println(gs.get(i).toString());
        }



//        查询多个，参数
//        List<Goddess> gs = g.query("哈");
//        for (int i = 0; i < gs.size() ; i++) {
//            System.out.println(gs.get(i).toString());
//        }

//

//        查询多个
//        List<Goddess> gs = g.query();
//        for (Goddess goddess : gs) {
//            System.out.println(goddess.getUser_name()+","+goddess.getAge());
//        }


//        查询单个
//        System.out.println(g.get(5).toString());

//        新增
//        Goddess g1 = new Goddess();
//        g1.setUser_name("哈哈");
//        g1.setSex(1);
//        g1.setAge(15);
//        g1.setBirthday(new Date());
//        g1.setEmail("21321@qq.com");
//        g1.setMobile("1272178382");
//        g1.setCreate_user("ADMIN");
//        g1.setUpdate_user("ADMIN");
//        g1.setIsdel(1);
//        g.addGodess(g1);


//        修改

//        Goddess g1 = new Goddess();
//        g1.setUser_name("小梅");
//        g1.setSex(1);
//        g1.setAge(15);
//        g1.setBirthday(new Date());
//        g1.setEmail("21321@qq.com");
//        g1.setMobile("1272178382");
//        g1.setCreate_user("ADMIN");
//        g1.setUpdate_user("ADMIN");
//        g1.setIsdel(1);
//        g1.setId(4);
//        g.updateGodess(g1);

//        删除
//          g.delGodess(3);

    }

    */
}
