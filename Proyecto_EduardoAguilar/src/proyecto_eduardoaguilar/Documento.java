package proyecto_eduardoaguilar;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class Documento implements Serializable{
    
    private StyledDocument doc;
    private Style estilo;
    private static final long SerialVersionUID = 777L;
    ArrayList<Clases> x = new ArrayList();
    ArrayList<Flujos> y = new ArrayList();
    

    public Documento( StyledDocument doc, Style estilo,ArrayList<Clases> x) {
       
        this.doc = doc;
        this.estilo = estilo;
        this.x =x;
    }
    public Documento( StyledDocument doc,ArrayList<Flujos> y, Style estilo) {
       
        this.doc = doc;
        this.estilo = estilo;
        this.y =y;
    }
    public StyledDocument getDoc() {
        return doc;
    }

    public void setDoc(StyledDocument doc) {
        this.doc = doc;
    }

    public Style getEstilo() {
        return estilo;
    }

    public ArrayList<Clases> getX() {
        return x;
    }

    public void setX(ArrayList<Clases> x) {
        this.x = x;
    }

    public ArrayList<Flujos> getY() {
        return y;
    }

    public void setY(ArrayList<Flujos> y) {
        this.y = y;
    }

    public Documento() {
    }
    
    
    
    

    public void setEstilo(Style estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Documento{" +  ", doc=" + doc + ", estilo=" + estilo + '}';
    }
    
    
    
}
