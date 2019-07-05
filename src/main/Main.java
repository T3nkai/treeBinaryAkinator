package main;

import model.BinaryTree;
import model.NodeBinary;
import persistencia.MapeamentoBinaryTree;

import java.util.Scanner;


public class Main {

    /**
     * algumas vezes  a persistencia nao funciona
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boolean exit = true;
        String resposta = "";
        BinaryTree root = null;
        MapeamentoBinaryTree mapTree = new MapeamentoBinaryTree();
        if (mapTree.get() == null) {
            root = new BinaryTree();
        } else {
            root = mapTree.get();
        }
        //-1 para sair do sistema inteiro
//        int exit = 0;
        NodeBinary node = root.getRoot();
        NodeBinary nodeRoot = root.getRoot();
//        System.out.println("Pense em um animal?");
        do {
            System.out.println("Pense em um animal?");

            do {
                System.out.println("O animal que voce pensou " + node.getQuestion());
                do {
                    System.out.println("Digite Sim, Nao ou Sair como resposta  ");
                    scan.hasNextLine();
                    resposta = scan.nextLine();

                } while (
                        !(resposta.equalsIgnoreCase("sim")
                                || resposta.equalsIgnoreCase("nao")
                                || resposta.equalsIgnoreCase("não")
                                || resposta.equalsIgnoreCase("sair")
                        )
                );

                if (!resposta.equalsIgnoreCase("sair")) {
                    if (resposta.equalsIgnoreCase("sim")) {
                        if (node.getLeaveRight().RightIsEmpty()) {
                            do {
                                System.out.println("O animal que você pensou é " + node.getLeaveRight().getAnswer());
                                System.out.println("Digite Sim ou Nao como resposta ");
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
                            if (node.getLeaveRight().RightIsEmpty()) {
                                System.out.println("Acertei de novo!");
                                node = nodeRoot;
                                exit = false;
                                resposta = "";


                            } else {
                                node = node.getLeaveRight();
                            }
                        } else {
                            if (node.getLeaveLeft().LeftIsEmpty()) {
                                scan = null;
                                scan = new Scanner(System.in);
                                System.out.println("Qual o animal que você pensou? ");
                                String objetoString = scan.nextLine();
                                System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getLeaveRight().getAnswer() + " não faz?");
                                String questionString = scan.nextLine();

                                node.insertNew(node.getLeaveRight(), objetoString, node.getLeaveRight().getAnswer(), questionString);
                                exit = false;
                                resposta = "";
                                node = nodeRoot;

                            } else {
                                node = node.getLeaveLeft();
                            }
                        }
                    } else {
                        if (node.getLeaveLeft().LeftIsEmpty()) {
                            do {
                                System.out.println("O animal que você pensou é " + node.getLeaveLeft().getAnswer());
                                System.out.println("Digite Sim ou Nao como resposta ");
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
                            if (node.getLeaveLeft().RightIsEmpty()) {
                                System.out.println("Acertei de novo!");
                                node = nodeRoot;
                                resposta = "";
                                exit = false;


                            } else {
                                node = node.getLeaveRight();
                            }
                        } else {
                            if (node.getLeaveLeft().LeftIsEmpty()) {
                                scan = null;
                                scan = new Scanner(System.in);
                                System.out.println("Qual o animal que você pensou?");
                                String objetoString = scan.nextLine();
                                System.out.println("Um(a) " + objetoString + " faz que o(a)" + node.getLeaveRight().getAnswer() + " não faz?");
                                String questionString = scan.nextLine();

                                node.insertNew(node.getLeaveRight(), objetoString, node.getLeaveRight().getAnswer(), questionString);
                                resposta = "";
                                exit = false;
                                node = nodeRoot;
                            } else {
                                node = node.getLeaveLeft();

                            }
                        }
                    }
                }
                if (resposta.equalsIgnoreCase("sair")) {
                    resposta = "sim";
                    exit = false;
                }

            } while (exit);
            if (!resposta.equalsIgnoreCase("sim")) {

                System.out.println("Digite Sim para Sair");
                scan.hasNextLine();
                resposta = scan.nextLine();
                if (!(resposta.equalsIgnoreCase("sim"))) {
                    exit = true;
                }
            }

        } while (!(resposta.equalsIgnoreCase("sim")));
        mapTree.put(root);

    }

}
