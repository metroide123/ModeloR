/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

/**
 *
 * @author Rodolfo Fonseca
 */
public class DadosChamadaRoleta {

    private int Col;
    private int Duz;
    private int MM;
    private int VP;
    private int PI;
    private int ColunaUnicaMax;
    private int DuziaUnicaMax;
    private int AlternaColunaMax;
    private int AlternaDuziaMax;
    private int AlternaVPMax;

    public int getAlternaVPMax() {
        return AlternaVPMax;
    }

    public void setAlternaVPMax(int AlternaVPMax) {
        this.AlternaVPMax = AlternaVPMax;
    }
    
    

    public int getAlternaColunaMax() {
        return AlternaColunaMax;
    }

    public void setAlternaColunaMax(int AlternaColunaMax) {
        this.AlternaColunaMax = AlternaColunaMax;
    }

    public int getAlternaDuziaMax() {
        return AlternaDuziaMax;
    }

    public void setAlternaDuziaMax(int AlternaDuziaMax) {
        this.AlternaDuziaMax = AlternaDuziaMax;
    }
    

    public int getColunaUnicaMax() {
        return ColunaUnicaMax;
    }

    public void setColunaUnicaMax(int ColunaUnicaMax) {
        this.ColunaUnicaMax = ColunaUnicaMax;
    }

    public int getDuziaUnicaMax() {
        return DuziaUnicaMax;
    }

    public void setDuziaUnicaMax(int DuziaUnicaMax) {
        this.DuziaUnicaMax = DuziaUnicaMax;
    }
    private int MaxGanho;
    private int MaxPerda;
    private int ApMin;
    private boolean FrameZeroAt;

    public DadosChamadaRoleta() {
        this.FrameZeroAt = false;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int Col) {
        this.Col = Col;
    }

    public int getDuz() {
        return Duz;
    }

    public void setDuz(int Duz) {
        this.Duz = Duz;
    }

    public int getMM() {
        return MM;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }

    public int getVP() {
        return VP;
    }

    public void setVP(int VP) {
        this.VP = VP;
    }

    public int getPI() {
        return PI;
    }

    public void setPI(int PI) {
        this.PI = PI;
    }

    public int getMaxGanho() {
        return MaxGanho;
    }

    public void setMaxGanho(int MaxGanho) {
        this.MaxGanho = MaxGanho;
    }

    public int getMaxPerda() {
        return MaxPerda;
    }

    public void setMaxPerda(int MaxPerda) {
        this.MaxPerda = MaxPerda;
    }

    public int getApMin() {
        return ApMin;
    }

    public void setApMin(int ApMin) {
        this.ApMin = ApMin;
    }

    public boolean isFrameZeroAt() {
        return FrameZeroAt;
    }

    public void setFrameZeroAt(boolean FrameZeroAt) {
        this.FrameZeroAt = FrameZeroAt;
    }


    

}
