package cn.edu.zut.excellent.util;

import java.util.LinkedList;
import java.util.List;

public class Excel {
    private String sheet;

    private String[] header;

    private Object[][] count;

    private List<RowNode> rowNodes;

    public List<RowNode> getRowNodes() {
        return rowNodes;
    }

    public void setRowNodes(List<RowNode> rowNodes) {
        this.rowNodes = rowNodes;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Object[][] getCount() {
        return count;
    }

    public void setCount(Object[][] count) {
        this.count = count;
    }
}
