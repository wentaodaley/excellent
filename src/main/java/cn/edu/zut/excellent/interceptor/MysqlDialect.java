package cn.edu.zut.excellent.interceptor;

public class MysqlDialect {

    public String getLimitString(String queryString, int offset, int pageSize) {
        StringBuffer buffer = new StringBuffer(queryString);
        buffer.append(" limit ");
        buffer.append(offset);
        buffer.append(",");
        buffer.append(pageSize);
//        System.out.println(buffer.toString());
        return buffer.toString();
    }

}
