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

    public void insertNew(NodeBinary node, String animais, String animalPai, String questao) {

        NodeBinary newNodeLeft = new NodeBinary();
        NodeBinary newNodeRight = new NodeBinary();
        NodeBinary nodePai = node;
        nodePai.setQuestion(questao);
        newNodeRight.setAnswer(animais);
        newNodeLeft.setAnswer(animalPai);
        nodePai.setLeaves(newNodeLeft,newNodeRight);
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
