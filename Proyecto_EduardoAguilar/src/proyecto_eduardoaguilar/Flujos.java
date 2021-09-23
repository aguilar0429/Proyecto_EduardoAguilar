package proyecto_eduardoaguilar;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;


public class Flujos implements Serializable{
    private String content;
    private Color c;
    ArrayList<String> variables = new ArrayList();
    ArrayList<String> variables2 = new ArrayList();
    private int v;
    private static final long SerialVersionUID = 777L;
    public Flujos(String content, Color c,ArrayList<String> variables, int v,ArrayList<String> variables2) {
        this.content = content;
        this.c = c;
        this.variables = variables;
        this.v = v;
        this.variables2 = variables2;
    }

    public ArrayList<String> getVariables2() {
        return variables2;
    }

    public void setVariables2(ArrayList<String> variables2) {
        this.variables2 = variables2;
    }
    

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
    
    

    public ArrayList<String> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }
    public void setList(String variables) {
        this.variables .add(variables);
    }
    public void setList2(String variables) {
        this.variables2 .add(variables);
    }
    
    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
    
    
    
}
