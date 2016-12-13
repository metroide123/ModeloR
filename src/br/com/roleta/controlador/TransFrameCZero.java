/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rodolfo Fonseca
 */
public class TransFrameCZero extends JFrame implements MouseMotionListener, ActionListener {

    private JLabel label;

    public TransFrameCZero() {
        addMouseMotionListener(this);

        setUndecorated(true);

        // setLayout(new GridBagLayout());
        setSize(10, 30);
        //setLocation(912, 303);// zoom de 300 roleta de 2 reais
        setLocation(1193, 401); // roleta de 0,2 zoom 250
        //setSize(21, 80); Para zoon 500 deixar proximo a caixa vermelha

        //setSize(42, 33); // largura , altura    zoom 400  (70, 50); (68, 47)
        label = new JLabel("0");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, 18));
        // label.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, 38)); zoom de 500

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(label);

    }
    
    public TransFrameCZero(int lar1 , int alt1,int loca1, int loca2, int tamfont) {
        this.addMouseMotionListener(this);
        this.getContentPane().setBackground(Color.RED);
        this.setUndecorated(true);
        this.setSize(lar1, alt1);
        this.setLocation(loca1, loca2); 
        
        label = new JLabel("0");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, tamfont));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(label);
        this.setAlwaysOnTop(true);
    }
    
     @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

        this.setLocation(e.getLocationOnScreen().x - this.getSize().width / 2, e.getLocationOnScreen().y - this.getSize().height / 2);

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
