package com.yixin.view;

import com.yixin.action.Action;
import com.yixin.model.Goddess;

import java.util.*;

public class View {

    public static final String CONTEXT = "欢迎来到女神区：\n" +
            "[MAIN/M]主菜单\n" +
            "[QUERY/Q]查看全部女神信息\n" +
            "[GET/G]查看某位女神详细信息\n" +
            "[ADD/A]添加女神信息\n" +
            "[UPDATE/U]更新女神信息\n" +
            "[SELETE/D]删除女神信息\n" +
            "[SEARCH/S]查询女神信息（根据姓名，手机号）\n" +
            "[EXIT/E]退出女神区\n" +
            "[BACK/B]退回当前功能，返回主菜单";

    public static final String OPERATION_MAIN = "MAIN";
    public static final String OPERATION_QUERY = "QUERY";
    public static final String OPERATION_GET = "GET";
    public static final String OPERATION_ADD = "ADD";
    public static final String OPERATION_UPDATE = "UPDATE";
    public static final String OPERATION_DELETE = "DELETE";
    public static final String OPERATION_SEARCH = "SEARCH";
    public static final String OPERATION_EXIT = "EXIT";
    public static final String OPERATION_BACK = "BACK";




    public static void main(String[] args) throws Exception {

        Action action = new Action();

        System.out.println(CONTEXT);

        Scanner scan = new Scanner(System.in);
//            System.out.println("您输入的值为：" + in);

        while (scan.hasNext()) {
            String in = scan.next().toString();
            if (OPERATION_EXIT.equals(in.toUpperCase())
                    || OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())) {
                System.out.println("您已成功退出女神区！");
                break;
            } else if (OPERATION_MAIN.equals(in.toUpperCase())
                    || OPERATION_MAIN.substring(0,1).equals(in.toUpperCase())) {
//                回到主菜单
                System.out.println(CONTEXT);
            } else if (OPERATION_QUERY.equals(in.toUpperCase())
                    || OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())) {

                System.out.println("全部女生：");
                List<Goddess> result = action.query();

                for (int i = 0; i < result.size() ; i++) {
                    System.out.println(result.get(i).getId() + "," + result.get(i).getUser_name());
                }
            } else if (OPERATION_GET.equals(in.toUpperCase())
                    || OPERATION_GET.substring(0,1).equals(in.toUpperCase())) {

                System.out.println("请输入女生ID：");

                while (true) {
                    String id = scan.next().toString();
                    System.out.println(action.get(Integer.valueOf(id)).toString());
                }

            } else if (OPERATION_ADD.equals(in.toUpperCase())
                    || OPERATION_ADD.substring(0,1).equals(in.toUpperCase())) {
                Goddess g = new Goddess();

                System.out.println("请输入女生姓名：");

                while (true) {
                    String name = scan.next().toString();
                    g.setUser_name(name);
                    g.setSex(0);
                    g.setEmail("ooooo@ss.com");
                    g.setMobile("44444444444");
                    g.setBirthday(new Date());
                    g.setAge(20);
                    g.setIsdel(1);
                    g.setId(10);
                    action.add(g);
                    System.out.println("添加成功！");
                    break;
                }
            } else if (OPERATION_UPDATE.equals(in.toUpperCase())
                    || OPERATION_UPDATE.substring(0,1).equals(in.toUpperCase())) {


                Goddess g = new Goddess();

                g.setUser_name("王福");
                g.setSex(0);
                g.setEmail("ooooo@ss.com");
                g.setMobile("44444444444");
                g.setBirthday(new Date());
                g.setAge(20);
                g.setIsdel(1);
                g.setId(10);
                action.edit(g);

                System.out.println("更新女生信息未完成！");


            } else if (OPERATION_DELETE.equals(in.toUpperCase())
                    || OPERATION_DELETE.substring(0,1).equals(in.toUpperCase())) {
                System.out.println("请输入删除女生ID：");

                while (true) {
                    String id = scan.next().toString();
                    action.del(Integer.valueOf(id));
                    System.out.println("删除成功！");
                    break;
                }

            } else if (OPERATION_SEARCH.equals(in.toUpperCase())
                    || OPERATION_SEARCH.substring(0,1).equals(in.toUpperCase())) {

                System.out.println("查询女生信息");
            } else if (OPERATION_BACK.equals(in.toUpperCase())
                    || OPERATION_BACK.substring(0,1).equals(in.toUpperCase())) {

//                System.out.println("返回主菜单");
                System.out.println(CONTEXT);
            }





        }

    }


}
