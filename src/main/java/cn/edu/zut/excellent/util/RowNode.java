package cn.edu.zut.excellent.util;

import java.util.LinkedList;
import java.util.List;

public class RowNode {
    private List<Node> list=new LinkedList<>();
    public boolean add(Node node){
        return list.add(node);
    }
    public boolean remove(Node node){
        return list.remove(node);
    }

    public Node get(int i){
        return list.get(i);
    }

}
