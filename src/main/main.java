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
        BinaryTree root = null;
        MapeamentoBinaryTree mapTree =  new MapeamentoBinaryTree();
        if(mapTree.get() == null) {
           root = new BinaryTree();
        }else{
            root = mapTree.get();
        }
        root.Question();
        mapTree.put(root);

    }

}
