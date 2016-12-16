/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.configuracoes;

import javax.swing.JOptionPane;

public class TravarGanhos {
   
    int Ganho; // perda atual
    int GanhoConfg; // perda configurada em config.
    
    
    void PerdMax(int p, int pc){
        Ganho = p;
        GanhoConfg = pc;
        
        if( Ganho == GanhoConfg) {
            JOptionPane.showMessageDialog(null, "Você atingil o Maximo de Ganhos para este Casino!\nPor Favor Pare de Jogar neste casino durante um periodo de no minimo 24 horas!");
        }
    }
    
    // teste com retorno
    int PerdMaxR(int p, int pc){
        Ganho = p;
        GanhoConfg = pc;
        
        if( Ganho == GanhoConfg) {
            JOptionPane.showMessageDialog(null, "Você atingil o Maximo de Ganhos para este Casino!\nPor Favor Pare de Jogar neste casino durante um periodo de no minimo 24 horas!");
            return 1;
        }
        return 0;
    }
    
}
