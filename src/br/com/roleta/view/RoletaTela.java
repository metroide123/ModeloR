package br.com.roleta.view;

import br.com.roleta.controlador.AlertaThead;
import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.controlador.DadosChamadaRoleta;
import br.com.roleta.controlador.ThreadLeituraTela;
import br.com.roleta.controlador.TransFrameCZero;
import br.com.roleta.controlador.TransparentFrame;
import br.com.roleta.modelo.Casino;
import br.com.roleta.modelo.Roleta;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class RoletaTela extends javax.swing.JFrame {

    TransparentFrame FrameTransparente;
    TransFrameCZero FrameZero;
    ThreadLeituraTela ThreadLeitura;
    AtualizaGrafico Atualizatela;
    Temporizador TimeSessao;
    AlertaThead Alerta = new AlertaThead();
    Home jpdHome;
    public Casino CasinoEsc = new Casino();
    public CasinoControlador cc = new CasinoControlador();

    int apMin;
    boolean controlethead = true, FrameZeroTeste = false, EntradaAp = false;

    public RoletaTela(DadosChamadaRoleta n, String tipo, String L, Home jp, Roleta r) {
        jpdHome = jp;
        FrameTransparente = new TransparentFrame(r.getFrameLargura(), r.getFrameAltura(), 1187, 401);
        FrameTransparente.setOpacity(0.55f);
        FrameTransparente.setVisible(true);

        CasinoEsc = cc.procurarCasinoId(r.getIdCassino());
        apMin = n.getApMin();

        ThreadLeitura = new ThreadLeituraTela();
        ThreadLeitura.windowRefence = FrameTransparente;

        ThreadLeitura.getEstra().ColunasMax = n.getCol();
        ThreadLeitura.getEstra().DuziaMax = n.getDuz();
        ThreadLeitura.getEstra().MaiorMenorMax = n.getMM();
        ThreadLeitura.getEstra().ParInparMax = n.getPI();
        ThreadLeitura.getEstra().PreVerMax = n.getVP();
        ThreadLeitura.Local = L;
        ThreadLeitura.nomeRoleta = tipo;

        Atualizatela = new AtualizaGrafico();
        TimeSessao = new Temporizador();

        AtThread();
        initComponents();
        PlayTrad.setText("PLAY");

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField12.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField9.setEditable(false);
        JtxtC1C2.setEditable(false);
        jtxtC2C3.setEditable(false);
        jTextD1D2.setEditable(false);
        jTextD2D3.setEditable(false);
        jTextC1.setEditable(false);
        jTextC2.setEditable(false);
        jTexC3.setEditable(false);
        jTextD1.setEditable(false);
        jTextD2.setEditable(false);
        jTextD3.setEditable(false);
        jTextVER.setEditable(false);
        jTextPRE.setEditable(false);
        jTextPAR.setEditable(false);
        jTextIMP.setEditable(false);
        jTextMAIOR.setEditable(false);
        jTextMENOR.setEditable(false);
        // jTextArea1.setLineWrap(true); AREA DA LISTA ANTERIOR
        TimeSessao.start();

        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }

    public RoletaTela() {
        initComponents();
    }

    public void AtThread() {
        ThreadLeitura.start();
        ThreadLeitura.suspend();
        Atualizatela.start();
        Atualizatela.suspend();

    }

    public void AtualizaDados() {

        // Setando Todos os Textfilds em Branco     
        JtxtC1C2.setBackground(Color.WHITE);
        jtxtC2C3.setBackground(Color.WHITE);
        jTextD1D2.setBackground(Color.WHITE);
        jTextD2D3.setBackground(Color.WHITE);
        jTextC1.setBackground(Color.WHITE);
        jTextC2.setBackground(Color.WHITE);
        jTexC3.setBackground(Color.WHITE);
        jTextD1.setBackground(Color.WHITE);
        jTextD2.setBackground(Color.WHITE);
        jTextD3.setBackground(Color.WHITE);
        jTextVER.setBackground(Color.WHITE);
        jTextPRE.setBackground(Color.WHITE);
        jTextPAR.setBackground(Color.WHITE);
        jTextIMP.setBackground(Color.WHITE);
        jTextMAIOR.setBackground(Color.WHITE);
        jTextMENOR.setBackground(Color.WHITE);

        // mexer depois pois da erro com a outra tread caso apague o codigo
        if (ThreadLeitura.getEstra().ConvertInt == 99) {
            ErroStatus.setText("ERRO");
            ErroStatus.setForeground(Color.red);
        } else {
            ErroStatus.setText("CORRETA");
            ErroStatus.setForeground(Color.GREEN);
        }

        //Contagem Adcionados nos jtextfilds
        JtxtC1C2.setText(Integer.toString(ThreadLeitura.getEstra().C12));
        jtxtC2C3.setText(Integer.toString(ThreadLeitura.getEstra().C23));
        jTextD1D2.setText(Integer.toString(ThreadLeitura.getEstra().D12));
        jTextD2D3.setText(Integer.toString(ThreadLeitura.getEstra().D32));
        jTextC1.setText(Integer.toString(ThreadLeitura.getEstra().CR1));
        jTextC2.setText(Integer.toString(ThreadLeitura.getEstra().CR2));
        jTexC3.setText(Integer.toString(ThreadLeitura.getEstra().CR3));
        jTextD1.setText(Integer.toString(ThreadLeitura.getEstra().Duz1));
        jTextD2.setText(Integer.toString(ThreadLeitura.getEstra().Duz2));
        jTextD3.setText(Integer.toString(ThreadLeitura.getEstra().Duz3));
        jTextVER.setText(Integer.toString(ThreadLeitura.getEstra().V));
        jTextPRE.setText(Integer.toString(ThreadLeitura.getEstra().P));
        jTextPAR.setText(Integer.toString(ThreadLeitura.getEstra().Par));
        jTextIMP.setText(Integer.toString(ThreadLeitura.getEstra().Inpar));
        jTextMAIOR.setText(Integer.toString(ThreadLeitura.getEstra().Maior));
        jTextMENOR.setText(Integer.toString(ThreadLeitura.getEstra().Menor));

        // Captura dos numeros maximos de espera de cada estrategia
        int ColunasMax = ThreadLeitura.getEstra().ColunasMax;
        int DuziaMax = ThreadLeitura.getEstra().DuziaMax;
        int ParInparMax = ThreadLeitura.getEstra().ParInparMax;
        int PreVerMax = ThreadLeitura.getEstra().PreVerMax;
        int MaiorMenorMax = ThreadLeitura.getEstra().MaiorMenorMax;
        int DRMax = ThreadLeitura.getEstra().DRMax;
        int CRMax = ThreadLeitura.getEstra().CRMax;

        // Parte que vai setar a cor dos jtextfilds de acordo com a aproximação da estrategia
        // ATENÇÃO a Cor Muda referente a casa que deve entrar não a que acumula Ex Acumula sequencia de preto mas 
        // A casa que muda a cor é a da Vermelha
        // Coluna 1 e 2
        if (ThreadLeitura.getEstra().C12 >= (ColunasMax + 1) / 2) {
            JtxtC1C2.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().C12 == ColunasMax - 1) {
                JtxtC1C2.setBackground(Color.WHITE);
                jtxtC2C3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().C12 >= ColunasMax) {
                JtxtC1C2.setBackground(Color.WHITE);
                jtxtC2C3.setBackground(Color.GREEN);

            }
        }

        // Coluna 2 e 3
        if (ThreadLeitura.getEstra().C23 >= (ColunasMax + 1) / 2) {
            jtxtC2C3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().C23 == ColunasMax - 1) {
                jtxtC2C3.setBackground(Color.WHITE);
                JtxtC1C2.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().C23 >= ColunasMax) {
                jtxtC2C3.setBackground(Color.WHITE);
                JtxtC1C2.setBackground(Color.GREEN);

            }
        }

        // Duzia 1 e 2
        if (ThreadLeitura.getEstra().D12 >= (DuziaMax + 1) / 2) {
            jTextD1D2.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().D12 == DuziaMax - 1) {
                jTextD1D2.setBackground(Color.WHITE);
                jTextD2D3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().D12 >= DuziaMax) {
                jTextD1D2.setBackground(Color.WHITE);
                jTextD2D3.setBackground(Color.GREEN);
            }
        }

        //Duzia 2 e 3
        if (ThreadLeitura.getEstra().D32 >= (DuziaMax + 1) / 2) {
            jTextD2D3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().D32 == DuziaMax - 1) {
                jTextD2D3.setBackground(Color.WHITE);
                jTextD1D2.setBackground(Color.yellow);
            }
            if (ThreadLeitura.getEstra().D32 >= DuziaMax) {
                jTextD2D3.setBackground(Color.WHITE);
                jTextD1D2.setBackground(Color.GREEN);
            }
        }

        // Vermelho
        if (ThreadLeitura.getEstra().V >= (PreVerMax + 1) / 2) {
            jTextVER.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().V == PreVerMax - 1) {
                jTextVER.setBackground(Color.WHITE);
                jTextPRE.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().V >= PreVerMax) {
                jTextVER.setBackground(Color.WHITE);
                jTextPRE.setBackground(Color.GREEN);
            }
        }

        // Preto
        if (ThreadLeitura.getEstra().P >= (PreVerMax + 1) / 2) {
            jTextPRE.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().P == PreVerMax - 1) {
                jTextPRE.setBackground(Color.WHITE);
                jTextVER.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().P >= PreVerMax) {
                jTextPRE.setBackground(Color.WHITE);
                jTextVER.setBackground(Color.GREEN);
            }
        }

        // Par
        if (ThreadLeitura.getEstra().Par >= (ParInparMax + 1)) {
            jTextPAR.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Par == ParInparMax - 1) {
                jTextPAR.setBackground(Color.WHITE);
                jTextIMP.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Par >= ParInparMax) {
                jTextPAR.setBackground(Color.WHITE);
                jTextIMP.setBackground(Color.GREEN);
            }
        }

        // Impar
        if (ThreadLeitura.getEstra().Inpar >= (ParInparMax + 1) / 2) {
            jTextIMP.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Inpar == ParInparMax - 1) {
                jTextIMP.setBackground(Color.WHITE);
                jTextPAR.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Inpar >= ParInparMax) {
                jTextIMP.setBackground(Color.WHITE);
                jTextPAR.setBackground(Color.GREEN);
            }

        }

        // Mairo que 19
        if (ThreadLeitura.getEstra().Maior >= (MaiorMenorMax + 1) / 2) {
            jTextMAIOR.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Maior == MaiorMenorMax - 1) {
                jTextMAIOR.setBackground(Color.WHITE);
                jTextMENOR.setBackground(Color.ORANGE);
            }
            if (ThreadLeitura.getEstra().Maior >= MaiorMenorMax) {
                jTextMAIOR.setBackground(Color.WHITE);
                jTextMENOR.setBackground(Color.ORANGE);
            }
        }

        // Menor que 18
        if (ThreadLeitura.getEstra().Menor >= (MaiorMenorMax + 1) / 2) {
            jTextMENOR.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Menor == MaiorMenorMax - 1) {
                jTextMENOR.setBackground(Color.WHITE);
                jTextMAIOR.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Menor >= MaiorMenorMax) {
                jTextMENOR.setBackground(Color.WHITE);
                jTextMAIOR.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Coluna 1 Aposta nas 2 e 3
        if (ThreadLeitura.getEstra().CR1 >= (CRMax + 1) / 2) {
            jTextC2.setBackground(Color.ORANGE);
            jTexC3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().CR1 == CRMax - 1) {
                jTextC2.setBackground(Color.YELLOW);
                jTexC3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().CR1 >= CRMax) {
                jTextC2.setBackground(Color.GREEN);
                jTexC3.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Coluna 2 Aposta nas 1 e 3
        if (ThreadLeitura.getEstra().CR2 >= (CRMax + 1) / 2) {
            jTextC1.setBackground(Color.ORANGE);
            jTexC3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().CR2 == CRMax - 1) {
                jTextC1.setBackground(Color.YELLOW);
                jTexC3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().CR2 >= CRMax) {
                jTextC1.setBackground(Color.GREEN);
                jTexC3.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Coluna 3 Aposta nas 1 e 2
        if (ThreadLeitura.getEstra().CR3 >= (CRMax + 1) / 2) {
            jTextC1.setBackground(Color.ORANGE);
            jTextC2.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().CR3 == CRMax - 1) {
                jTextC1.setBackground(Color.YELLOW);
                jTextC2.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().CR3 >= CRMax) {
                jTextC1.setBackground(Color.GREEN);
                jTextC2.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Duzia 1 Aposta nas 2 e 3
        if (ThreadLeitura.getEstra().Duz1 >= (DRMax + 1) / 2) {
            jTextD2.setBackground(Color.ORANGE);
            jTextD3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Duz1 == DRMax - 1) {
                jTextD2.setBackground(Color.YELLOW);
                jTextD3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Duz1 >= DRMax) {
                jTextD2.setBackground(Color.GREEN);
                jTextD3.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Duzia 2 Aposta nas 1 e 3
        if (ThreadLeitura.getEstra().Duz2 >= (DRMax + 1) / 2) {
            jTextD1.setBackground(Color.ORANGE);
            jTextD3.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Duz2 == DRMax - 1) {
                jTextD1.setBackground(Color.YELLOW);
                jTextD3.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Duz2 >= DRMax) {
                jTextD1.setBackground(Color.GREEN);
                jTextD3.setBackground(Color.GREEN);
            }
        }

        // Estrategia Repetição de Duzia 3 Aposta nas 1 e 2
        if (ThreadLeitura.getEstra().Duz3 >= (DRMax + 1) / 2) {
            jTextD1.setBackground(Color.ORANGE);
            jTextD2.setBackground(Color.ORANGE);
            if (ThreadLeitura.getEstra().Duz3 == DRMax - 1) {
                jTextD1.setBackground(Color.YELLOW);
                jTextD2.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Duz3 >= DRMax) {
                jTextD1.setBackground(Color.GREEN);
                jTextD2.setBackground(Color.GREEN);
            }
        }

    }

    public void MudaCorJtsfile(JTextField dt, int pri1) {
        if (pri1 == 1) {
            dt.setForeground(Color.blue);
            dt.setBackground(Color.red);
        } else if (pri1 == 2) {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.GREEN);
        } else if (pri1 == 3) {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.RED);
        } else {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.BLACK);
        }
    }

    public int SetarCor(int n) {
        if (n == 99) {
            return 1;
        } else if (n == 0) {
            return 2;
        } else if (n == 1 || n == 3 || n == 5 || n == 7 || n == 9 || n == 12 || n == 14 || n == 16 || n == 18 || n == 19 || n == 21
                || n == 23 || n == 25 || n == 27 || n == 30 || n == 32 || n == 34 || n == 36) {
            return 3;
        } else {
            return 4;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        ZerarBotao = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        txfAdicionarNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Sair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AddNum = new javax.swing.JButton();
        PlayTrad = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TempoSessao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JtxtC1C2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextC1 = new javax.swing.JTextField();
        jTextC2 = new javax.swing.JTextField();
        jTexC3 = new javax.swing.JTextField();
        jTextD3 = new javax.swing.JTextField();
        jTextD2 = new javax.swing.JTextField();
        jTextD1 = new javax.swing.JTextField();
        jtxtC2C3 = new javax.swing.JTextField();
        jTextD1D2 = new javax.swing.JTextField();
        jTextD2D3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextPRE = new javax.swing.JTextField();
        jTextPAR = new javax.swing.JTextField();
        jTextIMP = new javax.swing.JTextField();
        jTextMAIOR = new javax.swing.JTextField();
        jTextMENOR = new javax.swing.JTextField();
        jTextVER = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ErroStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("00,00");

        ZerarBotao.setText("Zerar/ Daeller");
        ZerarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZerarBotaoActionPerformed(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");

        jLabel2.setText("Add Número:");

        Sair.setText("SAIR");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        jLabel3.setText("Saldo Casino:");

        AddNum.setText("ADD Num");
        AddNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNumActionPerformed(evt);
            }
        });

        PlayTrad.setText("PLAY");
        PlayTrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayTradActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");

        jLabel5.setText("Tempo Restante Sessão:");

        TempoSessao.setBackground(new java.awt.Color(255, 255, 255));
        TempoSessao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TempoSessao.setText("20:00:00");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("C1C2");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C2C3");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("D1D2");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("D2D3");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("C1");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("C2");

        JtxtC1C2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("C3");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D1");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("D2");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("D3");

        jTextC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextC2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTexC3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextD3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextD2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextD1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtxtC2C3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextD1D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextD2D3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PRE");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("VER");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("IMP");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PAR");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MAIOR");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MENOR");

        jTextPRE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextPAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextIMP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextMAIOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextMENOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextVER.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Status Leitura:");

        ErroStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErroStatus.setText("ERRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtC1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtC2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextD1D2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextD2D3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextC1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextC2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTexC3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextD1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextD2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextD3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextVER, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextPRE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextPAR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextIMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextMAIOR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel21)
                                            .addComponent(jTextMENOR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ErroStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 97, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TempoSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(txfAdicionarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5)
                    .addComponent(TempoSessao))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)
                                .addComponent(JtxtC1C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(jtxtC2C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(11, 11, 11)
                                .addComponent(jTextD1D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(11, 11, 11)
                                .addComponent(jTextD2D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jTextC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTexC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextVER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextPRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextPAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextIMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextMAIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ErroStatus)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextMENOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfAdicionarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ZerarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZerarBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZerarBotaoActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed

        FrameTransparente.dispose();

        ThreadLeitura.stop();
        Atualizatela.stop();
        TimeSessao.stop();
        jpdHome.setI(jpdHome.getI() - 1);

        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void AddNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNumActionPerformed

        int i;
        if (txfAdicionarNumero.getText() != "") {
            i = Integer.parseInt(txfAdicionarNumero.getText());

            if (i >= 0 && i <= 36) {
                ThreadLeitura.getEstra().ConverterInt(Integer.parseInt(txfAdicionarNumero.getText()));
            } else {

            }
        }
    }//GEN-LAST:event_AddNumActionPerformed

    private void PlayTradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayTradActionPerformed

        if (controlethead) {
            ThreadLeitura.resume();
            PlayTrad.setText("PAUSE");
            controlethead = false;
            Atualizatela.resume();
        } else {

            ThreadLeitura.suspend();
            Atualizatela.suspend();

            PlayTrad.setText("PLAY");
            controlethead = true;
        }
    }//GEN-LAST:event_PlayTradActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoletaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNum;
    private javax.swing.JLabel ErroStatus;
    private javax.swing.JTextField JtxtC1C2;
    private javax.swing.JButton PlayTrad;
    private javax.swing.JButton Sair;
    public javax.swing.JLabel TempoSessao;
    private javax.swing.JButton ZerarBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTexC3;
    private javax.swing.JTextField jTextC1;
    private javax.swing.JTextField jTextC2;
    private javax.swing.JTextField jTextD1;
    private javax.swing.JTextField jTextD1D2;
    private javax.swing.JTextField jTextD2;
    private javax.swing.JTextField jTextD2D3;
    private javax.swing.JTextField jTextD3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextIMP;
    private javax.swing.JTextField jTextMAIOR;
    private javax.swing.JTextField jTextMENOR;
    private javax.swing.JTextField jTextPAR;
    private javax.swing.JTextField jTextPRE;
    private javax.swing.JTextField jTextVER;
    private javax.swing.JTextField jtxtC2C3;
    private javax.swing.JTextField txfAdicionarNumero;
    // End of variables declaration//GEN-END:variables

    public class AtualizaGrafico extends Thread {

        int pri1 = 0;

        @Override
        public void run() {

            try {
                while (true) {
                    AtualizaDados();
                    if (ThreadLeitura.getEstra().ConvertInt != 99) {

                        pri1 = SetarCor(ThreadLeitura.getEstra().ConvertInt);
                        jTextField1.setText(Integer.toString(ThreadLeitura.getEstra().ConvertInt));
                        MudaCorJtsfile(jTextField1, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A1);
                        jTextField2.setText(Integer.toString(ThreadLeitura.getEstra().A1));
                        MudaCorJtsfile(jTextField2, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A2);
                        jTextField3.setText(Integer.toString(ThreadLeitura.getEstra().A2));
                        MudaCorJtsfile(jTextField3, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A3);
                        jTextField4.setText(Integer.toString(ThreadLeitura.getEstra().A3));
                        MudaCorJtsfile(jTextField4, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A4);
                        jTextField5.setText(Integer.toString(ThreadLeitura.getEstra().A4));
                        MudaCorJtsfile(jTextField5, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A5);
                        jTextField12.setText(Integer.toString(ThreadLeitura.getEstra().A5));
                        MudaCorJtsfile(jTextField12, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A6);
                        jTextField7.setText(Integer.toString(ThreadLeitura.getEstra().A6));
                        MudaCorJtsfile(jTextField7, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A7);
                        jTextField8.setText(Integer.toString(ThreadLeitura.getEstra().A7));
                        MudaCorJtsfile(jTextField8, pri1);

                        pri1 = SetarCor(ThreadLeitura.getEstra().A8);
                        jTextField9.setText(Integer.toString(ThreadLeitura.getEstra().A8));
                        MudaCorJtsfile(jTextField9, pri1);
                    }
                    AtualizaGrafico.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public class Temporizador extends Thread {

        int Minutos = CasinoEsc.getTempoSessao();
        int Segundos = 00;

        @Override
        public void run() {

            try {
                while (true) {

                    if (Segundos == 0) {
                        if (Minutos > 0) {
                            Segundos = 59;
                            Minutos--;
                        }
                    } else {
                        Segundos--;
                    }

                    TempoSessao.setText(Integer.toString(Minutos) + ":" + Integer.toString(Segundos));

                    if (Segundos == 00 && Minutos == 00) {
                        JOptionPane.showMessageDialog(null, "Tempo de Sessão Acabou");
                        TimeSessao.suspend();
                    }

                    this.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
