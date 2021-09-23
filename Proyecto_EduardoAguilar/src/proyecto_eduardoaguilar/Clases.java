
package proyecto_eduardoaguilar;

import java.io.Serializable;
import java.util.ArrayList;


public class Clases implements Serializable {
    private String name;
    private ArrayList<String> x = new ArrayList();
    private ArrayList<String> y = new ArrayList();
    private ArrayList<String> z = new ArrayList();
    private String extend;
    private static final long SerialVersionUID = 777L;
    public Clases(String name,  ArrayList<String> y, String extend) {
        this.name = name;
        this.extend = extend;
        this.x = x ;
        this.y =y ;
    }

    public Clases(String name) {
        this.name = name;
    }
    
    

    public Clases(String name, ArrayList<String> x,  ArrayList<String> y) {
        this.name = name;
        this.x = x;
        this.y = y ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getX() {
        return x;
    }

    public void setX(String x) {
        this.x.add(x);
    }
    public void setZ(String x) {
        this.z.add(x);
    }

    public ArrayList<String> getZ() {
        return z;
    }
    

    public ArrayList<String> getY() {
        return y;
    }

    public void setY(String y) {
        this.y.add(y);
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "Clases{" + "name=" + name + ", x=" + x + ", y=" + y + ", extend=" + extend + '}';
    }
    
    
    
    
    
    
    
}
