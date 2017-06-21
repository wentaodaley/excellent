package cn.edu.zut.excellent.util;

public class Node {
    private int code;//所占长度,多少列
    private int hig;//所占高度
    private String str;//名称
    private short ali;//放置规则

    public Node( int code, String str) {
        this.code = code;
        this.str = str;
    }

    public short getAli() {
        return ali;
    }

    public void setAli(short ali) {
        this.ali = ali;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
