package cn.edu.zut.excellent.interceptor;

import org.apache.ibatis.executor.resultset.FastResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;


/**
 * 结果处理：
 */


@Intercepts({@Signature(type=ResultSetHandler.class, method="handleResultSets", args={Statement.class})})
public class ResultSetHandlerInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        FastResultSetHandler resultSet = (FastResultSetHandler)invocation.getTarget();
        RowBounds rowBounds = (RowBounds)ReflectUtil.getFieldValue(resultSet, "rowBounds");
        if(rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
            ReflectUtil.setFieldValue(resultSet, "rowBounds", new RowBounds());
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }

}
