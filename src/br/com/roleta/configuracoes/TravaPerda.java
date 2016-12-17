


package br.com.roleta.configuracoes;

import javax.swing.JOptionPane;


public class TravaPerda {
    
    
    int Perda; // perda atual
    int PerdaConfg; // perda configurada em config.
    
    
    void PerdMax(int p, int pc){
        Perda = p;
        PerdaConfg = pc;
        
        if( Perda == PerdaConfg) {
            JOptionPane.showMessageDialog(null, "Você atingil o Maximo de Perda Configurado!\nPor Favor Pare de Jogar neste casino durante um periodo de no minimo 6 horas!");
        }
    }
    
    // teste com retorno
    int PerdMaxR(int p, int pc){
        Perda = p;
        PerdaConfg = pc;
        
        if( Perda == PerdaConfg) {
            JOptionPane.showMessageDialog(null, "Você atingil o Maximo de Perda Configurado!\nPor Favor Pare de Jogar neste casino durante um periodo de no minimo 6 horas!");
            return 1;
        }
        return 0;
    }
    
}
