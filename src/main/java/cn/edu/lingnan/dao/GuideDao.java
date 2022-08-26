package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Guide;

import java.util.List;
import java.util.Vector;

public interface GuideDao {

    //查询操作
    /*查询所有的导游记录*/
    Vector<Guide> findAllGuide();

    /*根据姓名+ 密码查询一条导游记录*/
    Guide findGuideByNameAndPassword(String guideName, String guidePassword);

    /*根据姓名 模糊查询，返回多个结果，多条导游记录，用Vector容器装载*/
    Vector<Guide> findGuideByName(String guideName);

    /*根据导游编号，查询唯一的导游记录  返回值类型：导游实体类*/
    Guide findGuideById(String guideId);

    //新增操作
    /*添加导游信息 参数：单个导游实体*/
    int insertGuide(Guide guide);

    //删除操作
    /*根据导游编号删除一条导游记录*/
    boolean deleteGuideByGid(String guideId);

    //修改操作
    /*修改导游信息 参数：单个导游实体*/
    int updateGuide(Guide guide);

    //修改密码
    /*修改导游密码，参数：导游id + 新密码*/
    boolean updateGuidePassword(String guideId, String newPassword);
}
