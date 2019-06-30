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


    public boolean Question(NodeBinary node) {
        Scanner scan = new Scanner(System.in);

        int exit = 0;
        do {

            System.out.println("Pense em um animal?");
            System.out.println("O animal que voce pensou " + node.getQuestion());
            do {
                System.out.println("Digite Sim, Nao ou Sair como resposta");
                scan.hasNextLine();
                resposta = scan.nextLine();
                exit = (resposta.equalsIgnoreCase("sair")) ? -1 : 1;

            } while (
                    !(resposta.equalsIgnoreCase("sim")
                            || resposta.equalsIgnoreCase("nao")
                            || resposta.equalsIgnoreCase("não")
                            || resposta.equalsIgnoreCase("sair")
                    )
            );

            if (exit == 1) {

                if (resposta.equalsIgnoreCase("sim")) {
                    if (node.getLeaveRight().isEmpty()) {
                        do {
                            System.out.println("O animal que você pensou é " + node.getLeaveRight().getAnswer());
                            System.out.println("Digite Sim ou Nao como resposta");
                            scan.hasNextLine();
                            resposta = scan.nextLine();
                        } while (
                                !(resposta.equalsIgnoreCase("sim")
                                        || resposta.equalsIgnoreCase("nao")
                                        || resposta.equalsIgnoreCase("não")
                                )
                        );
                    }
                    if (resposta.equalsIgnoreCase("sim")) {
                        if (node.getLeaveRight().isEmpty()) {
                            System.out.println("Acertei de novo!");
                        } else {
                            node.Question(node.getLeaveRight());
                        }
                    } else {
                        if (node.getLeaveLeft().isEmpty()) {
                            node.insertNew(node.getLeaveRight());
                        } else {
                            node.Question(node.getLeaveRight());
                        }
                    }
                } else {
                    if (node.getLeaveLeft().isEmpty()) {
                        do {
                            System.out.println("O animal que você pensou é " + node.getLeaveLeft().getAnswer());
                            System.out.println("Digite Sim ou Nao como resposta");
                            scan.hasNextLine();
                            resposta = scan.nextLine();
                        } while (
                                !(resposta.equalsIgnoreCase("sim")
                                        || resposta.equalsIgnoreCase("nao")
                                        || resposta.equalsIgnoreCase("não")
                                        || resposta.equalsIgnoreCase("sair")
                                )
                        );
                    }
                    if (resposta.equalsIgnoreCase("sim")) {
                        if (node.getLeaveLeft().isEmpty()) {
                            System.out.println("Acertei de novo!");
                        } else {
                            node.Question(node.getLeaveLeft());
                        }
                    } else {
                        if (node.getLeaveLeft().isEmpty()) {
                            node.insertNewLeft(node.getLeaveLeft());
                        } else {
                            node.Question(node.getLeaveLeft());
                        }
                    }
                }
            }

            if(!isRoot){break;}
        } while (exit == 1);
        return true;
    }


    public void insertNew(NodeBinary node) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o animal que você pensou?");
        String objetoString = scan.nextLine();
        System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getAnswer() + " não faz?");
        String questionString = scan.nextLine();
        String aux = node.getAnswer();
        node.setQuestion(questionString);
        //seria uma visão alem do alcance
        node.setLeaveRight(objetoString);
        node.setLeaveLeft(aux);
    }


    public void insertNewLeft(NodeBinary node) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o animal que você pensou?");
        String objetoString = scan.nextLine();
        System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getAnswer() + " não faz?");
        String questionString = scan.nextLine();
        String aux = node.getAnswer();
        node.setQuestion(questionString);
        node.setLeaveRight(objetoString);
        node.setLeaveLeft(aux);
    }

    public void setQuestion(String value) {
        this.answer_question = value;
    }

    public String getQuestionDefault() {
        return this.DEFAULT_QUESTION;
    }

    public boolean isEmpty() {
        return this.getLeaveLeft() == null
                || this.getLeaveRight() == null;
    }
}
