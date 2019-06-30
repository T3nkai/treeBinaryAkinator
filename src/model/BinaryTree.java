package model;

import java.io.Serializable;

public class BinaryTree implements Serializable {

    private NodeBinary node;
    private final int cod = 1;

    public BinaryTree() {
        node = new NodeBinary("vive na agua", true);
        node.setLeaveRight("Baleia");
        node.setLeaveLeft("Cahorro");
    }


    public void Question(){

       this.node.Question(node);

    }

    public int getCod() {
        return this.cod;
    }
}