package proyecto_eduardoaguilar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


public class NodesTree extends JPanel {
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Clase", true),
      node1 = new DefaultMutableTreeNode("Nodo", true), node2 = new DefaultMutableTreeNode(
          "Nodo", true), node3 = new DefaultMutableTreeNode("Nodo", true);

  MyJTree tree = new MyJTree(root);

  public NodesTree() {
    //this.tree = (MyJTree) j;
    root.add(node1);
    node1.add(node2);
    root.add(node3);
    setLayout(new BorderLayout());
    add(new JScrollPane((JTree) tree), "Center");
  }
}
class MyJTree extends JTree implements ActionListener {
  JPopupMenu popup = new JPopupMenu();
  JMenuItem mi = new JMenuItem("Agregar nodo");

  MyJTree(DefaultMutableTreeNode dmtn) {
    super(dmtn);    
    mi.addActionListener(this);
    mi.setActionCommand("Agregar");
    popup.add(mi);
    mi = new JMenuItem("Eliminar Nodo");
    mi.addActionListener(this);
    mi.setActionCommand("Eliminar");
    popup.add(mi);
    addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
          popup.show((JComponent) e.getSource(), e.getX(), e.getY());
        }
      }
    });

  }

  public void actionPerformed(ActionEvent ae) {
    DefaultMutableTreeNode dmtn, node;

    TreePath path = this.getSelectionPath();
    dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();
    if (ae.getActionCommand().equals("Agregar")) {
      node = new DefaultMutableTreeNode("Nodo");
      dmtn.add(node);
      ((DefaultTreeModel) this.getModel()).nodeStructureChanged((TreeNode) dmtn);
    }
    if (ae.getActionCommand().equals("Eliminar")) {
      node = (DefaultMutableTreeNode) dmtn.getParent();
      int nodeIndex = node.getIndex(dmtn);
      dmtn.removeAllChildren();
      node.remove(nodeIndex);
      ((DefaultTreeModel) this.getModel()).nodeStructureChanged((TreeNode) dmtn);
    }
  }
}
