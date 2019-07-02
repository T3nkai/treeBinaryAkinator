package persistencia;

import model.BinaryTree;

import java.io.*;

public class MapeamentoBinaryTree {


    private BinaryTree cacheTree = new BinaryTree();
//    private HashMap<Integer, BinaryTree> cacheTree = new HashMap<>();
    private final String filename = "binaryTree.delucca";

    public MapeamentoBinaryTree(){
        load();
    }

    public BinaryTree get(){

        return cacheTree;
    }

    public void put(BinaryTree tree){
        cacheTree = tree;
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheTree);
            oo.flush();
            fout.flush();

            oo.close();
            fout.close();

        }catch (FileNotFoundException ex){
            System.out.println("arquivo nao encontrado");
        }catch (IOException exx){
            System.out.println(exx);
        }
    }
    public  void load(){
        try{
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);
            this.cacheTree = (BinaryTree) oi.readObject();
//            this.cacheTree = (HashMap<Integer, BinaryTree>) oi.readObject();

            oi.close();
            fin.close();

        }catch (ClassNotFoundException x){
            System.out.println("arquivo invalido");
            persist();
        }catch (FileNotFoundException ex){
            System.out.println("arquivo nao encontrado");
        }catch (IOException e){
            System.out.println(e);

        }
    }
}
