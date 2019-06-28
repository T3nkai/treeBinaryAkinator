package model;

public class Nodebinary implements Serializable {

    private final Boolean YES = true;
    private final Boolean NOT = false;
    private String answer;
    private boolean isLeave;
    private Leave leaveLeft;
    private Leave leaveRight;



    private Nodebinary(){
    }

    /**
     *Por padrao cria uma Node 
     *  
     * @param answer
     */
    public createNode( String answer){
        Nodebinary node = new Nodebinary();
        node.answer = answer;
        node.isLeave = this.NOT;
    }

    public createNode( String answer){
        Nodebinary node = new Nodebinary();
        node.answer = answer;
        node.isLeave = this.NOT;
    }


    private boolean isLeave(){
        return this.YES == this.isLeave;
    }
}