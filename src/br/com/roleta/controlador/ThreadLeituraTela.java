package br.com.roleta.controlador;

import br.com.roleta.LeituraImagem.LerImagem;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;

public class ThreadLeituraTela extends Thread {

    Estrategias Estra = new Estrategias();

    public TransparentFrame windowRefence;
    public String Local = "";
    public String nomeRoleta = "";
    private String casino;

    public String getNomeRoleta() {
        return nomeRoleta;
    }

    public String getCasino() {
        return casino;
    }

    public void setCasino(String casino) {
        this.casino = casino;
    }

    public void setNomeRoleta(String nomeRoleta) {
        this.nomeRoleta = nomeRoleta;
    }

    public Estrategias getEstra() {
        return Estra;
    }

    public void setEstra(Estrategias Estra) {
        this.Estra = Estra;
    }

    public void run() {

        LerImagem obj1 = new LerImagem();
        obj1.importarNumeros();
        int L1 = 99, L2 = 99, L3 = 99;

        try {
            while (true) {

                if (this.windowRefence.isShowing()) {

                    Robot robot;
                    try {
                        robot = new Robot();

                        // criando a imagem
                        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(windowRefence.getLocationOnScreen().x, windowRefence.getLocationOnScreen().y, windowRefence.getSize().width, windowRefence.getSize().height));
                        
                        // caminho a ser salvo a imagem
                        // (retirei) ImageIO.write(screenShot, "png", new File("c:\\Leitor\\" + Local + "\\Img.png"));
                        ImageIO.write(screenShot, "png", new File("Img.png"));
                        obj1.converterImagem("Img.png");
                   

                        Estra.ConverterInt(obj1.contarPixels());
                        // System.out.println(nome);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ThreadLeituraTela.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String f) {
        String everything = "";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(f));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            sb.append(line);
            // sb.append(System.lineSeparator());
            //while (line != null) {

            //line = br.readLine();
            //  }
            everything = sb.toString();

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return everything;

    }
}
