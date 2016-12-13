/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author Rodolfo Fonseca
 */
public class TransparentFrame extends JFrame implements MouseMotionListener, ActionListener {

    public TransparentFrame() {
        addMouseMotionListener(this);

        setUndecorated(true);

        setLayout(new GridBagLayout());

        setSize(45, 30); // largura , altura    zoom 250 400, 300  (70, 50); (68, 47)
        // setSize(80, 47); 500 zoom
        // zoom de 300 
        //setLocation(907, 303);
        setLocation(1187, 401); //zoom de 250
        setOpacity(0.55f);
        ThreadLeituraTela t = new ThreadLeituraTela();
        t.windowRefence = this;
        t.start();

    }

    public TransparentFrame(int lar1, int alt1, int loc1, int loc2) {
       
        addMouseMotionListener(this);
        setUndecorated(true);
        setLayout(new GridBagLayout());
        setSize(lar1, alt1);
        setLocation(loc1, loc2);
        setAlwaysOnTop(true);

       // ThreadLeituraTela t = new ThreadLeituraTela();
        // t.windowRefence = this;
        // t.start();
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
