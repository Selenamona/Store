package com.yixin.come;

import java.sql.*;
import com.yixin.db.Main;
import com.yixin.model.Goddess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoddessCome {
    /*
    * 新增女神
    */
    public void addGodess (Goddess g) throws Exception {

        Connection conn = Main.getConnection();

        String sql = ""+
                     "insert into imooc_goddess" +
                     "(user_name,sex,age,birthday,email,mobile," +
                     "create_user,create_date,update_user,update_date,isdel)" +
                     "values(" +
                     "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";


        //prepareStatement 将sql语句加载到驱动执行程序中，但不直接执行；当调用execute时真正执行；
        // sql语句中参数用？表示，当执行时将sql语句补充完整，这样减少了对数据库的操作
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreate_user());
        ptmt.setString(8,g.getUpdate_user());
        ptmt.setInt(9,g.getIsdel());


        //excute用来执行更改数据的操作，新增、修改、删除
        ptmt.execute();

    }

    /*
    * 修改女神信息
    * */
    public void updateGodess (Goddess g) throws SQLException {

        Connection conn = Main.getConnection();

        //sql语句拼接注意空格！！！

        String sql = ""+
                " update imooc_goddess " +
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                " update_user=?,update_date=current_date(),isdel=? " +
                " where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getUpdate_user());
        ptmt.setInt(8,g.getIsdel());
        ptmt.setInt(9,g.getId());


        //excute用来执行更改数据的操作，新增、修改、删除
        ptmt.execute();

    }

    /*
    * 删除女神
    */
    public void delGodess (Integer id) throws SQLException {

        Connection conn = Main.getConnection();

        String sql = ""+
                " delete from imooc_goddess " +
                " where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,id);

        //excute用来执行更改数据的操作，新增、修改、删除
        ptmt.execute();

    }

    /*
    * 查询多个女神
    * */
    public List<Goddess> query () throws Exception {

        Connection conn = Main.getConnection();
        Statement stmt = conn.createStatement();    //创建statement对象
        ResultSet rs = stmt.executeQuery("select id,user_name,age from imooc_goddess");
        List<Goddess> gs = new ArrayList<Goddess>();
        Goddess g = null;

        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }

        return gs;
    }

    /*
     * 查询多个女神===传参==改装1
     * */
    public List<Goddess> query (String name) throws Exception {

        Connection conn = Main.getConnection();

//        like 模糊查询；；；  "%" + name + "%"
        StringBuilder sb = new StringBuilder();
        sb.append("select * from imooc_goddess ");
        sb.append("where user_name like ? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ptmt.setString(1,"%"+name+"%");

        ResultSet rs  = ptmt.executeQuery();

        Goddess g = null;

        List<Goddess> result = new ArrayList<Goddess>();
        
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setSex(rs.getInt("sex"));
            g.setAge(rs.getInt("age"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_user(rs.getString("create_user"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }

        return result;
    }

    /*
     * 查询多个女神===传参List==改装2
     * */
    public List<Goddess> query (List<Map<String,Object>> params) throws Exception {

        Connection conn = Main.getConnection();

        StringBuilder sb = new StringBuilder();

//        小技巧：1=1永远成立，解决sql循环拼接问题
        sb.append(" select * from imooc_goddess where 1=1 ");

        if (params != null && params.size()>0){
            for (int i = 0; i < params.size(); i++) {
                Map<String,Object> map = params.get(i);
                sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
            }
        }

        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        System.out.println(sb.toString());

        ResultSet rs  = ptmt.executeQuery();

        Goddess g = null;

        List<Goddess> result = new ArrayList<Goddess>();

        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setSex(rs.getInt("sex"));
            g.setAge(rs.getInt("age"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_user(rs.getString("create_user"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }

        return result;
    }

    /*
    * 查询单个女神
    * */
    public Goddess get (Integer id) throws SQLException {

        Goddess g = null;
        Connection conn = Main.getConnection();
        String sql = ""+
                " select * from imooc_goddess " +
                " where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,id);

        //excute用来执行更改数据的操作，新增、修改、删除
        ResultSet rs =  ptmt.executeQuery();

        while (rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setSex(rs.getInt("sex"));
            g.setAge(rs.getInt("age"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_user(rs.getString("create_user"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setIsdel(rs.getInt("isdel"));

        }

        return g;
    }

}
