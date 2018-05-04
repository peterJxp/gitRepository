package com.ssm.util;
/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/3/003
  Time:11:30
  To change this template use File | Settings | File Templates.
*/

public class Paging {

    private int startPage; //起始页
    private int pageCount; //每页记录数
    private int page; //当前页数

    public Paging( int page, int pageCount) {
        this.pageCount = pageCount;
        this.page = page;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "startPage=" + startPage +
                ", pageCount=" + pageCount +
                ", page=" + page +
                '}';
    }
}
