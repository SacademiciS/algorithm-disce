package behavioral.medium.design.mediator;

import java.util.List;

//这里定义了对数据库操作的查询接口，分为查询一个结果和查询多个结果，同时包括有参数和没有参数的方法
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
