package cn.edu.zut.excellent.interceptor;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.sql.Connection;
import java.util.Properties;


/**
 * 1、生产sql语句：
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class StatementHandlerInterceptor implements Interceptor {

    private static String MYSQL_DIALECT = "cn.edu.zut.internship.interceptor.MysqlDialect";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        RoutingStatementHandler statetment = (RoutingStatementHandler) invocation.getTarget();
        PreparedStatementHandler handler = (PreparedStatementHandler) ReflectUtil.getFieldValue(statetment, "delegate");
        RowBounds rowBounds = (RowBounds) ReflectUtil.getFieldValue(handler, "rowBounds");
        if(rowBounds.getLimit() == RowBounds.NO_ROW_LIMIT) {
            return invocation.proceed();
        }
        BoundSql boundSql = statetment.getBoundSql();
        String sql = boundSql.getSql();
//      HashMap<String, Object> map = (HashMap<String, Object>)boundSql.getParameterObject();
        MysqlDialect dialect = (MysqlDialect)Class.forName(MYSQL_DIALECT).newInstance();
        sql = dialect.getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());
//        log.info(sql);
        ReflectUtil.setFieldValue(boundSql, "sql", sql);
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        SqlSessionFactoryBean c;
    }
}
