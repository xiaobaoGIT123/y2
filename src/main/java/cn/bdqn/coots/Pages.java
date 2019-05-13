package cn.bdqn.coots;

import java.util.List;

public class Pages {
    //当前页
    private Integer currentPage;
    //总页
    private Integer countPage;
    //总条数
    private Integer totalCount;
    //每页显示条数
    private Integer size;
    //每页的内容
    private List<Object> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCountPage() {
        return countPage;
    }


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        if(totalCount>0){
            this.countPage= totalCount%this.size==0?totalCount/this.size:(totalCount/this.size)+1;
        }
        this.totalCount = totalCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}