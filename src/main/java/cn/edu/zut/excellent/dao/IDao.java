package cn.edu.zut.excellent.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by hb on 16/9/29.
 */
public interface IDao<T,PK extends Serializable> {
    /**
     * 添加数据,要求所有的数据一一对应，不能存在字段丢失现象
     * @param t 需要添加的对象
     * @return  主键值
     */
    void insert(T t);

    /**
     * 添加数据，允许数据字段不一一对应。
     * @param t 需要添加的对象
     * @return  主键值
     */
    void insertSelective(T t);

    /**
     * 根据主键更新数据，完成数据的更新，
     * 数据必须 对应
     * @param t 更新的对象
     * @return  主键值
     */
    Integer updateByKey(T t);

    /**
     * 根据主键更新数据，完成数据对应，
     * 不更新的数据 为空。
     * @param t 更新的对象
     * @return  主键值
     */
    Integer updateByKeySelective(T t);

    /**
     * 根据主键删除数据
     * @param id 主键值
     * @return  主键值
     */
    Integer deleteByKey(PK id);

    /**
     * 根据主键查询出对象
     * @param id
     * @return
     */
    T selectByKey(PK id);

    /**
     * 获取所有的总数
     * @return
     */
    Long getCount();

    /**
     * 查询出所有的对象
     * @return
     */
    List<T> findAll(RowBounds rowBounds);

    /**
     * 根据对象查询出所有分组对象
     * @param parameters
     * @param rowBounds
     * @return
     */
    List<T> getPage(Map<String, String> parameters, RowBounds rowBounds);
}

