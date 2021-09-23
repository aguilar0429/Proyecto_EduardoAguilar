package proyecto_eduardoaguilar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class LayOut implements LayoutManager2{

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        @Override
        public void invalidateLayout(Container target) {
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            int maxX = 0;
            int maxY = 0;
            for (Component comp : parent.getComponents()) {
                Dimension size = comp.getPreferredSize();
                maxX = Math.max(comp.getX() + size.width, maxX);
                maxY = Math.max(comp.getY() + size.height, maxY);
            }

            return new Dimension(maxX, maxY);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            for (Component comp : parent.getComponents()) {
                Dimension size = comp.getPreferredSize();
                comp.setSize(size);
            }
        }

    }




