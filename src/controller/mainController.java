package controller;

import model.BinaryTree;

public class MainController{
    private static MainController uniqueCtrMain;
    private BinaryTree root;

    public static synchronized MainController getInstance() {
        if (uniqueCtrlPessoa == null)
            uniqueCtrlPessoa = new MainController();
        return uniqueCtrlPessoa;
    }


    public BinaryTree MainController(){
      BinaryTree  root = TreeController.initTreeBinary();
      return  root;
    }
}
