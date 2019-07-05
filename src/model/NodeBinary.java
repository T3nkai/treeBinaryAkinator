package model;

import java.io.Serializable;
import java.util.Scanner;

public class NodeBinary implements Serializable {
    private final Boolean YES = true;
    private final Boolean NOT = false;
    private final String DEFAULT_QUESTION = "Qual o animal que você pensou?";
    private String answer_question;
    private boolean isRoot;
    private String resposta;

    //caminho false
    private NodeBinary leaveLeft;
    //caminho true
    private NodeBinary leaveRight;


    public NodeBinary() {
    }

    public NodeBinary(String value, boolean root) {
        answer_question = value;
        isRoot = root;

    }

    public void setLeaveLeft(String value) {

        this.leaveLeft = new NodeBinary(value, false);
    }

    public void setLeaveRight(String value) {
        this.leaveRight = new NodeBinary(value, false);
    }

    public String getQuestion() {
        return this.answer_question;
    }

    public String getAnswer() {
        return this.answer_question;
    }

    public NodeBinary getLeaveRight() {
        return this.leaveRight;
    }

    public NodeBinary getLeaveLeft() {
        return this.leaveLeft;
    }


//    public void insertNew(NodeBinary node) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Qual o animal que você pensou?");
//        String objetoString = scan.nextLine();
//        System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getLeaveRight().getAnswer() + " não faz?");
//        String questionString = scan.nextLine();
//
//        NodeBinary nodeRight = node.getLeaveLeft();
//        String aux = nodeRight.getAnswer();
//        nodeRight.setQuestion(questionString);
//        nodeRight.setLeaveRight(objetoString);
//        nodeRight.setLeaveLeft(aux);
//    }
//
//    public void insertNewLeft(NodeBinary node) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Qual o animal que você pensou?");
//        String objetoString = scan.nextLine();
//        System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getLeaveLeft().getAnswer() + " não faz?");
//        String questionString = scan.nextLine();
//
//        NodeBinary nodeLeft = node.getLeaveLeft();
//        String aux = nodeLeft.getAnswer();
//        nodeLeft.setQuestion(questionString);
//        nodeLeft.setLeaveRight(objetoString);
//        nodeLeft.setLeaveLeft(aux);
//    }

    public void insertNew(NodeBinary node, String animais, String animalPai, String questao) {

        NodeBinary newNodeLeft = new NodeBinary();
        NodeBinary newNodeRight = new NodeBinary();
        NodeBinary nodePai = node;
        nodePai.setQuestion(questao);
        newNodeRight.setAnswer(animais);
        newNodeLeft.setAnswer(animalPai);
        nodePai.setLeaves(newNodeLeft,newNodeRight);
        System.out.println("");
    }


    public void setQuestion(String value) {
        this.answer_question = value;
    }


    public void setAnswer(String value) {
        this.answer_question = value;
    }
    public String getQuestionDefault() {
        return this.DEFAULT_QUESTION;
    }

    public boolean isEmpty() {
        return this.getLeaveLeft() == null
                || this.getLeaveRight() == null;
    }

    public boolean LeftIsEmpty() {
        return this.getLeaveRight() == null;
    }

    public boolean RightIsEmpty() {
        return this.getLeaveRight() == null;
    }

    public void  setLeaves(NodeBinary leaveLeft,NodeBinary leaveRight){
        this.leaveLeft = leaveLeft;
        this.leaveRight = leaveRight;
    }
}
