package Ctrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santiago.sanmartin
 */
public class Archivo {
    private File doc;
    private BufferedWriter bw;
    private BufferedReader br;

    public Archivo(File doc) {
        this.doc = doc;
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }
    
    private String getTextInsideDoc(){
        String textInsideDoc= "";
        try {
            String aux = "";
            br = new BufferedReader(new FileReader(doc));
            while((aux=br.readLine())!=null){
                textInsideDoc= textInsideDoc + aux +'\n';
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return textInsideDoc;
    }
    
    public String edit(String text){
        String bfText=getTextInsideDoc();
        try {
            bw = new BufferedWriter(new FileWriter(doc));
            bw.write(bfText);
            bw.write('\n');
            bw.write(text);
            bw.write('\n');
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getTextInsideDoc();
    }    
}
