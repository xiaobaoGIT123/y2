package cn.bdqn.dao;

import cn.bdqn.pojo.Report;

import java.util.List;

public interface ReportMapper {
    //(添加举报)
    List<Report> addReport(Report report);
}
