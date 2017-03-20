package br.com.roleta.controlador;

import br.com.roleta.LeituraImagem.LerImagem;
import br.com.roleta.LeituraImagem.Pixel;
import java.awt.Graphics2D;
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

    public String getNomeRoleta() {
        return nomeRoleta;
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
        Estra.nomeRoleta = getNomeRoleta();
        LerImagem obj1;
        Pixel obj2;

        try {
            while (true) {

                if (this.windowRefence.isShowing()) {

                    Robot robot;
                    try {
                        robot = new Robot();

                        // criando a imagem
                        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(windowRefence.getLocationOnScreen().x, windowRefence.getLocationOnScreen().y, windowRefence.getSize().width, windowRefence.getSize().height));
                        Graphics2D graphics = screenShot.createGraphics();

                        // caminho a ser salvo a imagem
                        // (retirei) ImageIO.write(screenShot, "png", new File("c:\\Leitor\\" + Local + "\\Img.png"));
                        ImageIO.write(screenShot, "png", new File("Img.png"));
                        obj1 = new LerImagem("Img.png", "Img_saida.png");
                        obj2 = new Pixel("Img_saida.png");

                        //Captura do tesseract.exe Leitura da imagem
                        //Process process = new ProcessBuilder("C:\\Leitor\\" + Local + "\\Tesseract-OCR\\tesseract.exe", "C:\\Leitor\\" + Local + "\\Img.png", "C:\\Leitor\\" + Local + "\\Out").start();
                        //Process process = new ProcessBuilder("C:\\ProgramFiles(x86)\\Tesseract-OCRtesseract.exe", "C:\\Leitor\\Img.png", "C:\\Leitor\\Out").start();
                        // (retirei) String everything = this.readFile("C:\\Leitor\\" + Local + "\\Out.txt");
                        //System.out.println(everything);
                        // (retirei) String nome = everything;
                        // (retirei)   nome = nome.replace(" ", "");
                        // (retirei)   nome = nome.trim();
                        Estra.ConverterInt(obj2.contarPixels());
                        // System.out.println(nome);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ThreadLeituraTela.sleep(5000);
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
