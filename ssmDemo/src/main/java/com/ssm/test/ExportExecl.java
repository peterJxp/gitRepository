package com.ssm.test;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/8/008
  Time:10:09
  To change this template use File | Settings | File Templates.
*/
import com.ssm.model.Person;
import org.apache.poi.hssf.usermodel.*;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExportExecl extends HttpServlet {
    private static  final   String SQLdriver="com.mysql.jdbc.Driver";
    private  static  final   String Url="jdbc:mysql://127.0.0.1:3306/test_database";
    private  static  final  String username="root";
    private  static  final String password="root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList=new ArrayList<Person>();
        try {
            Class.forName (SQLdriver);
            Connection connection=DriverManager.getConnection(Url,username,password);
            PreparedStatement statement=connection.prepareStatement("SELECT  * FROM person");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Person person=new Person();
                person.setId(resultSet.getString(1));
                person.setName(resultSet.getString(2));
                person.setAge(resultSet.getInt(3));
                personList.add(person);
            }
            exportExecl(personList,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static   void exportExecl(List<Person> list,HttpServletResponse response){

        HSSFCell hssfCell1=null;
        JSONObject jsonObject=null;

        //第一步  创建一个webbook，对应一个execl
        HSSFWorkbook wb=new HSSFWorkbook();
        //第二步 在webbook添加一个sheets，对应execl中得sheets
        HSSFSheet hssfSheet=wb.createSheet(String.valueOf(System.currentTimeMillis()));
        // 第三步 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = hssfSheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle wbCellStyle=wb.createCellStyle();
        wbCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中格式

        String[] m =retModelLeg(list.get(0));//model数组
        HSSFCell hssfCell=null;
        int k=0;
        for(String column:m){
            hssfCell=row.createCell((short)k++);
            hssfCell.setCellValue(column.substring(0,column.indexOf('=')).trim());
            hssfCell.setCellStyle(wbCellStyle);
        }
        //第五步 从数据库拿到数据
        for (int i = 0; i < list.size(); i++)
        {
            row = hssfSheet.createRow((int) i + 1);
            Person per = (Person) list.get(i);
            // 第四步，创建单元格，并设置值
            String[] m1=retModelLeg(per);
            int k1=0;
            System.out.println(m1);
             jsonObject= new JSONObject(per);
            for(String column:m1){
                String value=jsonObject.get(column.substring(0,column.indexOf('=')).trim())+"";
                row.createCell((short)k1++).setCellValue(value);
            }
        }
        // 第六步，将文件存到指定位置
//        try
//        {
//            FileOutputStream fout = new FileOutputStream("D:/person.xls");
//            wb.write(fout);
//            fout.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        // 第六步，下载excel
        OutputStream out = null;
        try {
            out =response.getOutputStream();
            String fileName = String.valueOf(System.currentTimeMillis())+".xls";// 文件名
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static  String[] retModelLeg(Object o){
       String m= o.toString();
        System.out.println(m);
       String  newStr=m.substring(m.indexOf('{')+1,m.indexOf('}'));
       String[] strArray=newStr.split(",");
       return strArray;
    }
}
