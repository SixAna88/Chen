package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Path;

import java.util.List;
import java.util.Vector;

public interface PathService {

    //查询操作

    /*查询所有路线信息*/
    Vector<Path> queryAllPath();

    /*根据路线编号查询一条指定的路线记录*/
    Path selectPathByPid(String pathId);

    //删除操作

    /*根据路线编号删除一条指定的路线记录*/
    boolean deletePathByPid(String pathId);

    //更新操作
    /*修改路线信息*/
    int updatePath(Path path);

    //新增操作
    /*添加一条新的路线信息*/
    int insertPath(Path path);

}
