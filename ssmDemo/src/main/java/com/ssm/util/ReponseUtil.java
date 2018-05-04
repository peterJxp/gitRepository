package com.ssm.util;

/*
Created by IntelliJ IDEA.
        User:jxp
        Date:2018/5/3/003
        Time:11:11
        To change this template use File|Settings|File Templates.
 */

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ReponseUtil {

    private static final String contentType = "text/html;charset=utf-8";

    //回写到游览器
    public static void out(HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setContentType(contentType);
        PrintWriter out = httpServletResponse.getWriter();
        out.print(o);
        out.flush();
        out.close();
    }
}
