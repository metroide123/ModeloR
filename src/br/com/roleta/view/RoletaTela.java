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

import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

    // Captura dos numeros maximos de espera de cada estrategia
    int ColunasMax;
    int DuziaMax;
    int ParInparMax;
    int PreVerMax;
    int MaiorMenorMax;
    int DRMax;
    int CRMax;
    int AtrColunaMax;
    int AtrDuziaMax;

    public RoletaTela(DadosChamadaRoleta n, String tipo, String L, Home jp, Roleta r) {
        jpdHome = jp;
        FrameTransparente = new TransparentFrame(r.getFrameLargura(), r.getFrameAltura(), 1187, 401);
        FrameTransparente.setOpacity(0.55f);
        FrameTransparente.setVisible(true);

        CasinoEsc = cc.procurarCasinoId(r.getIdCassino());
        apMin = n.getApMin();

        // Adção dos Maximo para Cada Estrategia
        ColunasMax = n.getCol();
        DuziaMax = n.getDuz();
        ParInparMax = n.getPI();
        PreVerMax = n.getVP();
        MaiorMenorMax = n.getMM();
        DRMax = n.getDuziaUnicaMax();
        CRMax = n.getColunaUnicaMax();
        AtrColunaMax = n.getAlternaColunaMax();
        AtrDuziaMax = n.getAlternaDuziaMax();

        ThreadLeitura = new ThreadLeituraTela();
        ThreadLeitura.windowRefence = FrameTransparente;

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
        jTextAlC1.setEditable(false);
        jTextAlC2.setEditable(false);
        jTextAlC3.setEditable(false);
        jTextAlD1.setEditable(false);
        jTextAlD2.setEditable(false);
        jTextAlD3.setEditable(false);

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
        jTextAlC1.setBackground(Color.WHITE);
        jTextAlC2.setBackground(Color.WHITE);
        jTextAlC3.setBackground(Color.WHITE);
        jTextAlD1.setBackground(Color.WHITE);
        jTextAlD2.setBackground(Color.WHITE);
        jTextAlD3.setBackground(Color.WHITE);

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

        // Parte que vai setar a cor dos jtextfilds de acordo com a aproximação da estrategia
        // ATENÇÃO a Cor Muda referente a casa que deve entrar não a que acumula Ex Acumula sequencia de preto mas 
        // A casa que muda a cor é a da Vermelha
        // Coluna 1 e 2
        if (ThreadLeitura.getEstra().C12 >= (ColunasMax + 1) / 2) {
            JtxtC1C2.setBackground(Color.MAGENTA);
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
            jtxtC2C3.setBackground(Color.MAGENTA);
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
            jTextD1D2.setBackground(Color.MAGENTA);
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
            jTextD2D3.setBackground(Color.MAGENTA);
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
            jTextVER.setBackground(Color.MAGENTA);
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
            jTextPRE.setBackground(Color.MAGENTA);
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
            jTextPAR.setBackground(Color.MAGENTA);
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
            jTextIMP.setBackground(Color.MAGENTA);
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
            jTextMAIOR.setBackground(Color.MAGENTA);
            if (ThreadLeitura.getEstra().Maior == MaiorMenorMax - 1) {
                jTextMAIOR.setBackground(Color.WHITE);
                jTextMENOR.setBackground(Color.MAGENTA);
            }
            if (ThreadLeitura.getEstra().Maior >= MaiorMenorMax) {
                jTextMAIOR.setBackground(Color.WHITE);
                jTextMENOR.setBackground(Color.MAGENTA);
            }
        }

        // Menor que 18
        if (ThreadLeitura.getEstra().Menor >= (MaiorMenorMax + 1) / 2) {
            jTextMENOR.setBackground(Color.MAGENTA);
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
            jTextC2.setBackground(Color.MAGENTA);
            jTexC3.setBackground(Color.MAGENTA);
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
            jTextC1.setBackground(Color.MAGENTA);
            jTexC3.setBackground(Color.MAGENTA);
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
            jTextC1.setBackground(Color.MAGENTA);
            jTextC2.setBackground(Color.MAGENTA);
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
            jTextD2.setBackground(Color.MAGENTA);
            jTextD3.setBackground(Color.MAGENTA);
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
            jTextD1.setBackground(Color.MAGENTA);
            jTextD3.setBackground(Color.MAGENTA);
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
            jTextD1.setBackground(Color.MAGENTA);
            jTextD2.setBackground(Color.MAGENTA);
            if (ThreadLeitura.getEstra().Duz3 == DRMax - 1) {
                jTextD1.setBackground(Color.YELLOW);
                jTextD2.setBackground(Color.YELLOW);
            }
            if (ThreadLeitura.getEstra().Duz3 >= DRMax) {
                jTextD1.setBackground(Color.GREEN);
                jTextD2.setBackground(Color.GREEN);
            }
        }

        // Estragia de Acumulo da Alternancia de Valores Coluna
        if (ThreadLeitura.getEstra().CR1 > 0) {
            jTextAlC1.setBackground(Color.WHITE);
            jTextAlC2.setBackground(Color.WHITE);
            jTextAlC3.setBackground(Color.WHITE);
            jTextAlC3.setText("");
            jTextAlC1.setText(Integer.toString(ThreadLeitura.getEstra().AlterNaC1C3));
            if (ThreadLeitura.getEstra().AlterNaC1C3 >= (AtrColunaMax + 1) / 2) {
                jTextAlC1.setBackground(Color.MAGENTA);
                jTextAlC2.setBackground(Color.MAGENTA);
                if (ThreadLeitura.getEstra().AlterNaC1C3 == AtrColunaMax - 1) {
                    jTextAlC1.setBackground(Color.YELLOW);
                    jTextAlC2.setBackground(Color.YELLOW);
                }
                if (ThreadLeitura.getEstra().AlterNaC1C3 >= AtrColunaMax) {
                    jTextAlC1.setBackground(Color.GREEN);
                    jTextAlC2.setBackground(Color.GREEN);
                }
            }
        } else if (ThreadLeitura.getEstra().CR2 > 0) {
            jTextAlC1.setBackground(Color.WHITE);
            jTextAlC2.setBackground(Color.WHITE);
            jTextAlC3.setBackground(Color.WHITE);
            jTextAlC1.setText("");
            jTextAlC2.setText("");
            jTextAlC3.setText("");
        } else {
            jTextAlC1.setBackground(Color.WHITE);
            jTextAlC2.setBackground(Color.WHITE);
            jTextAlC3.setBackground(Color.WHITE);
            jTextAlC1.setText("");
            jTextAlC3.setText(Integer.toString(ThreadLeitura.getEstra().AlterNaC1C3));
            if (ThreadLeitura.getEstra().AlterNaC1C3 >= (AtrColunaMax + 1) / 2) {
                jTextAlC3.setBackground(Color.MAGENTA);
                jTextAlC2.setBackground(Color.MAGENTA);
                if (ThreadLeitura.getEstra().AlterNaC1C3 == AtrColunaMax - 1) {
                    jTextAlC3.setBackground(Color.YELLOW);
                    jTextAlC2.setBackground(Color.YELLOW);
                }
                if (ThreadLeitura.getEstra().AlterNaC1C3 >= AtrColunaMax) {
                    jTextAlC3.setBackground(Color.GREEN);
                    jTextAlC2.setBackground(Color.GREEN);
                }
            }
        }
        
        
        // Estragia de Acumulo da Alternancia de Valores Duzia
        if (ThreadLeitura.getEstra().Duz1 > 0) {
            jTextAlD1.setBackground(Color.WHITE);
            jTextAlD2.setBackground(Color.WHITE);
            jTextAlD3.setBackground(Color.WHITE);
            jTextAlD3.setText("");
            jTextAlD1.setText(Integer.toString(ThreadLeitura.getEstra().AlterNaD1D3));
            if (ThreadLeitura.getEstra().AlterNaD1D3 >= (AtrDuziaMax + 1) / 2) {
                jTextAlD1.setBackground(Color.MAGENTA);
                jTextAlD2.setBackground(Color.MAGENTA);
                if (ThreadLeitura.getEstra().AlterNaD1D3 == AtrDuziaMax - 1) {
                    jTextAlD1.setBackground(Color.YELLOW);
                    jTextAlD2.setBackground(Color.YELLOW);
                }
                if (ThreadLeitura.getEstra().AlterNaD1D3 >= AtrDuziaMax) {
                    jTextAlD1.setBackground(Color.GREEN);
                    jTextAlD2.setBackground(Color.GREEN);
                }
            }
        } else if (ThreadLeitura.getEstra().Duz2 > 0) {
            jTextAlD1.setBackground(Color.WHITE);
            jTextAlD2.setBackground(Color.WHITE);
            jTextAlD3.setBackground(Color.WHITE);
            jTextAlD1.setText("");
            jTextAlD2.setText("");
            jTextAlD3.setText("");
        } else {
            jTextAlD1.setBackground(Color.WHITE);
            jTextAlD2.setBackground(Color.WHITE);
            jTextAlD3.setBackground(Color.WHITE);
            jTextAlD1.setText("");
            jTextAlD3.setText(Integer.toString(ThreadLeitura.getEstra().AlterNaD1D3));
            if (ThreadLeitura.getEstra().AlterNaD1D3 >= (AtrDuziaMax + 1) / 2) {
                jTextAlD3.setBackground(Color.MAGENTA);
                jTextAlD2.setBackground(Color.MAGENTA);
                if (ThreadLeitura.getEstra().AlterNaD1D3 == AtrDuziaMax - 1) {
                    jTextAlD3.setBackground(Color.YELLOW);
                    jTextAlD2.setBackground(Color.YELLOW);
                }
                if (ThreadLeitura.getEstra().AlterNaD1D3 >= AtrDuziaMax) {
                    jTextAlD3.setBackground(Color.GREEN);
                    jTextAlD2.setBackground(Color.GREEN);
                }
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

        jScrollBar1 = new javax.swing.JScrollBar();
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
        jLabel22 = new javax.swing.JLabel();
        ErroStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JtxtC1C2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtC2C3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextC1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextC2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTexC3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextAlC1 = new javax.swing.JTextField();
        jTextAlC2 = new javax.swing.JTextField();
        jTextAlC3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextVER = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextPRE = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextPAR = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextIMP = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextMAIOR = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextMENOR = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextD1D2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextD2D3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextD1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextD2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextD3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextAlD3 = new javax.swing.JTextField();
        jTextAlD2 = new javax.swing.JTextField();
        jTextAlD1 = new javax.swing.JTextField();

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

        jLabel5.setText("Tempo Restante :");

        TempoSessao.setBackground(new java.awt.Color(255, 255, 255));
        TempoSessao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TempoSessao.setText("20:00:00");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Leitura:");

        ErroStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErroStatus.setText("ERRO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Colunas (Acumuladas)"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("C1C2");

        JtxtC1C2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C2C3");

        jtxtC2C3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("C1");

        jTextC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("C2");

        jTextC2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("C3");

        jTexC3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("AltCOL");

        jTextAlC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextAlC2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextAlC3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jTextAlC1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAlC2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAlC3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtxtC1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtC2C3)
                            .addComponent(jTextC2)
                            .addComponent(jTexC3)
                            .addComponent(jTextC1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtxtC1C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtC2C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTexC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextAlC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAlC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAlC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Binárias (Acumuladas)"));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("VER");

        jTextVER.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PRE");

        jTextPRE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PAR");

        jTextPAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("IMP");

        jTextIMP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MAIOR");

        jTextMAIOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MENOR");

        jTextMENOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextMAIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jTextPRE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextVER, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextPAR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextIMP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextMENOR)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextVER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextPRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextPAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextIMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextMAIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextMENOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dúzias (Acumuladas)"));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("D1D2");

        jTextD1D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("D2D3");

        jTextD2D3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D1");

        jTextD1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("D2");

        jTextD2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("D3");

        jTextD3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AltDUZ");

        jTextAlD3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextAlD2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextAlD1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextD1D2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jTextD2D3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextAlD1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextAlD2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextAlD3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextD2)
                            .addComponent(jTextD3)
                            .addComponent(jTextD1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextD1D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextD2D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextAlD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAlD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAlD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TempoSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(81, 81, 81))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ErroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(txfAdicionarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TempoSessao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ErroStatus)
                            .addComponent(jLabel22)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txfAdicionarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ZerarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZerarBotaoActionPerformed
        ThreadLeitura.getEstra().ConverterInt(0);

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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTexC3;
    private javax.swing.JTextField jTextAlC1;
    private javax.swing.JTextField jTextAlC2;
    private javax.swing.JTextField jTextAlC3;
    private javax.swing.JTextField jTextAlD1;
    private javax.swing.JTextField jTextAlD2;
    private javax.swing.JTextField jTextAlD3;
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
