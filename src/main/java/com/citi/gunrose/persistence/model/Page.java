package com.citi.gunrose.persistence.model;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */

public class Page<E> {

    private List<E> list;

    private int totalRecords;

    private int pageSize;

    private int pageNo;

    public int getTotalPages(){
        return (totalRecords+pageSize-1)/pageSize;
    }

    public int countOffset(int currentPage,int pageSize){
        int offset = pageSize*(currentPage-1);
        return offset;
    }

    public int getTopPageNo(){
        return 1;
    }

    public int getPreviousPageNo(){
        if(pageNo<=1){
            return 1;
        }
        return pageNo-1;
    }

    public int getNextPageNo(){
        if(pageNo>=getBottomPageNo()){
            return getBottomPageNo();
        }
        return pageNo+1;
    }

    public int getBottomPageNo(){
        return getTotalPages();
    }


    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}