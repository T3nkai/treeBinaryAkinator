package main;

import model.BinaryTree;
import persistencia.MapeamentoBinaryTree;

import java.util.Scanner;


public class Main {

    /**
     * algumas vezes  a persistencia nao funciona
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boolean exit = true;
        String resposta = "";
        BinaryTree root = null;
        MapeamentoBinaryTree mapTree =  new MapeamentoBinaryTree();
        if(mapTree.get() == null) {
           root = new BinaryTree();
        }else{
            root = mapTree.get();
        }

        do{
            root.Question();
            System.out.println("Digite Sim para Sair");
            scan.hasNextLine();
            resposta = scan.nextLine();

        }while(!(resposta.equalsIgnoreCase("sim")));
        mapTree.put(root);

    }

}
