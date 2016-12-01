/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD_Resultados.bean;

/**
 *
 * @author Rodolfo Fonseca
 */
public class NumColetado {
   
    private int id;
    private int numcoletado;
    private String TipoRoleta;
    private String dataColeta;
    private String HoraColeta;

    public NumColetado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumcoletado() {
        return numcoletado;
    }

    public void setNumcoletado(int numcoletado) {
        this.numcoletado = numcoletado;
    }

    public String getTipoRoleta() {
        return TipoRoleta;
    }

    public void setTipoRoleta(String TipoRoleta) {
        this.TipoRoleta = TipoRoleta;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getHoraColeta() {
        return HoraColeta;
    }

    public void setHoraColeta(String HoraColeta) {
        this.HoraColeta = HoraColeta;
    }
  
    
    
}
