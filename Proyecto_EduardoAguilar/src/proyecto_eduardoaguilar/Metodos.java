/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eduardoaguilar;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.*;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Graphics2D;
/**
 *
 * @author eagui
 */
public class Metodos {
    private Point currentLocation;
    public void setDraggable(JTree t) {
        t.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentLocation = e.getPoint();
            }
        });

        t.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentScreenLocation = e.getLocationOnScreen();
                t.setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y);
               //t.setLocation(currentScreenLocation.x , currentScreenLocation.y );
            }
        });
    }
    public MyJTree creart(String s, ArrayList<String> x, ArrayList<String> y){
        DefaultMutableTreeNode dmtn, node;
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(s, true);
        MyJTree j = new MyJTree(root);
                for(int i = 0; i < x.size();i++){
                    String variable = x.get(i);
                    node = new DefaultMutableTreeNode(variable);
                    root.add(node);
                    ((DefaultTreeModel) j.getModel()).nodeStructureChanged((TreeNode) root);
                }
                for(int i = 0 ; i < y.size(); i ++){
                    String variable = y.get(i);
                    node = new DefaultMutableTreeNode(variable);
                    root.add(node);
                    ((DefaultTreeModel) j.getModel()).nodeStructureChanged((TreeNode) root);
                }
        j.repaint();
        JTextField textField = new JTextField();
        TreeCellEditor editor = new DefaultCellEditor(textField);
        //j.setBackground(Color.black);
        j.setForeground(Color.white);
        j.setEditable(true);
        j.setCellEditor(editor);
        setDraggable(j);
        float m = j.getAlignmentX();
        float n = j.getAlignmentY();
        
        return j;
    }
    
    
  
    
    public JTextArea crearA(String s, Color m){
        JTextArea j = new JTextArea();
        j.setText(s);
        j.setBackground(m);
        if(m.equals(Color.BLACK)){
            j.setForeground(Color.white);
        }else{
            j.setForeground(Color.black);
        }
        
        j.setSize(200,200);
        setDraggable2(j);
        
        
        
        
        return j;
    }
    
    public void setDraggable2(JTextArea t) {
        t.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentLocation = e.getPoint();
            }
        });

        t.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentScreenLocation = e.getLocationOnScreen();
                t.setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y);
               //t.setLocation(currentScreenLocation.x , currentScreenLocation.y );
            }
        });
    }
    
    public void saveImage(JPanel panel,String s) {
        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("./"+s+".png"));
            System.out.println("panel saved as image");

        } catch (Exception e) {
            System.out.println("panel not saved" + e.getMessage());
        }
    }
    
    public String GenCode(JTextArea a, ArrayList<Clases> x){
        String content = "";
        for(int i = 0 ; i <x.size();i++){
            String s = ((Clases)x.get(i)).getName();
            if(x.get(i).getExtend()!= null){
                content+= "class "+s+": public "+x.get(i).getExtend()+" {\n";
                
                for (int j = 0; j < ((Clases) x.get(i)).getX().size(); j++) {
                    content += "  " + (((Clases) x.get(i)).getX()).get(j) + "{\n  }\n";
                }
                
                for (int j = 0; j < ((Clases) x.get(i)).getY().size(); j++) {
                    content += "  " + (((Clases) x.get(i)).getY()).get(j) + ";\n";
                }
                content += "};\n";
            }else{
                content+= "class "+s+" {\n";
                for (int j = 0; j < ((Clases) x.get(i)).getX().size(); j++) {
                    content += "  " + (((Clases) x.get(i)).getX()).get(j) + "{\n  }\n";
                }
                for (int j = 0; j < ((Clases) x.get(i)).getY().size(); j++) {
                    content += "  " + (((Clases) x.get(i)).getY()).get(j) + ";\n";
                }
                content += "};\n";
            }
        }
        return content;
    }
    public String GenCode2(JTextArea a, ArrayList<Flujos> x){
        boolean flag1 = false;
        String content = "";
        for(int i = 0 ; i < x.size() ; i++){
            int flag = x.get(i).getV();
            int flag2 = 10;
            if(i<x.size()-1){
                flag2=x.get(i).getV();
            }
            
            
            if(flag == 1){
                content = content;
            }else if (flag == 2){
                flag1 = true;
                content+= "if( "+x.get(i).getContent()+") {\n";
            }else if (flag == 3){
                flag1 = true;
                content+= "else if( "+x.get(i).getContent()+") {\n";
            }else if (flag == 4){
                flag1 = true;
                content+= "while( "+x.get(i).getContent()+") {\n";
            }else if (flag == 5){
                String nuevo="";
                if(x.get(i).getContent().contains("Imprimir")){
                    for(int j = 9 ;j<x.get(i).getContent().length();j++){
                        nuevo+=x.get(i).getContent().charAt(j);
                    }
                    content+= "   cout<<"+nuevo+";\n";
                }else if(x.get(i).getContent().contains("=")){
                    //content += "   cin>>" + variable + ";\n";
                    content += "  "+x.get(i).getContent() + ";\n";
                    
                }else if(x.get(i).getContent().contains("+")){
                    content+="  "+x.get(i).getContent()+";\n";
                }else {
                    String tempo = "";
                    for (int j = 0; j < x.get(i).getVariables2().size(); j++) {
                        tempo = x.get(i).getVariables2().get(j);
                        content+="   cin>> "+tempo+";\n";
                        
                    }
                }
                if(flag2!= 5 && flag1 == true){
                    content+="}\n";
                }else{
                    flag1=false;
                }
            }else if (flag == 6){
                for(int j = 0 ;j<x.get(i).getVariables().size();j++){
                    content+=x.get(i).getVariables().get(j)+";\n";
                }
            }
        }
        return content;
    }
    
    public void guardar3(JPanel panel,String s){
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./"+s+".pdf"));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D g2 = template.createGraphics(500, 500);
            panel.print(g2);
            g2.dispose();
            contentByte.addTemplate(template, 30, 300);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(document.isOpen()){
                document.close();
            }
        }
    }
    
   
}
