/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import java.applet.Applet;
import java.applet.AudioClip;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo Fonseca
 */
public class AlertaThead {

    

    public void Alerta(boolean n) {

        if (n) {
            URL url = AlertaThead.class.getResource("Alerta.wav");
            AudioClip audio = Applet.newAudioClip(url);
            audio.play();           
            try {
            sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AlertaThead.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } 
    }   

}
