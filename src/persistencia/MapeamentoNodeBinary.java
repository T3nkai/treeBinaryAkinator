package persistencia;

import model.NodeBinary;

import java.io.*;
import java.util.HashMap;

public class MapeamentoNodeBinary {

    private HashMap<String, NodeBinary> cacheNode = new HashMap<>();
    private final String filename = "NodeBinary.delucca";

    public MapeamentoNodeBinary(){
        load();
    }

    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheNode);
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
            this.cacheNode = (HashMap<String, NodeBinary>) oi.readObject();

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
