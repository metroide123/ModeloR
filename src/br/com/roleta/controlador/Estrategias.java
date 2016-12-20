package br.com.roleta.controlador;

import br.com.roleta.modelo.NumColetado;
import br.com.roleta.modelo.ResultaDados;
import br.com.roleta.dao.NumColetadoDAO;
import br.com.roleta.dao.resultadosDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estrategias {

    public int Duzia1, D12 = 0, D32 = 0, Duzia2, Duzia3, coluna1, C12 = 0, C23 = 0,
            coluna2, coluna3, V, P, Par, Inpar, Maior, Menor, Anterios = 0, A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0, A6 = 0, A7 = 0, A8 = 0;
    public int Duz1 = 0, Duz2 = 0, Duz3 = 0;
    // Espera Para dar a Entrada de cada estrategia
    // A entrada é sempre no numero +1 q inserido
    public int ColunasMax = 9;
    public int DuziaMax = 9;
    public int ParInparMax = 9;
    public int PreVerMax = 9;
    public int MaiorMenorMax = 8;
    public int ConvertInt;

    NumColetado NovoNum = new NumColetado();
    NumColetadoDAO NovoNumDAO = new NumColetadoDAO();
    Date date = new Date();
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    String nomeRoleta;

    ResultaDados res = new ResultaDados();
    resultadosDAO rdao = new resultadosDAO();

    public void ConverterInt(String n) {

        String nome = n;

        try {
            ConvertInt = Integer.parseInt(nome); // Caso você queira tipo int, que é o usual.

        } catch (NumberFormatException e) {
            ConvertInt = 99;
        }

        if (ConvertInt == Anterios) {

        } else {
            A8 = A7;
            A7 = A6;
            A6 = A5;
            A5 = A4;
            A4 = A3;
            A3 = A2;
            A2 = A1;
            A1 = Anterios;
            Anterios = ConvertInt;
            ContDuzia(ConvertInt);
            
        }

    }

    public boolean MaiorCont9() {

        if (ColunasMax - 2 <= C12 || ColunasMax - 2 <= C23 || DuziaMax - 2 <= D12 || DuziaMax - 2 <= D32
                || ParInparMax - 2 <= Par || ParInparMax - 2 <= Inpar || PreVerMax - 2 <= P || PreVerMax - 2 <= V
                || MaiorMenorMax - 2 <= Maior || MaiorMenorMax - 2 <= Menor) {
            return true;
        } else {
            return false;
        }

    }

    public boolean Maax() {

        if (ColunasMax == C12 || ColunasMax == C23 || DuziaMax == D12 || DuziaMax == D32
                || ParInparMax == Par || ParInparMax == Inpar || PreVerMax == P || PreVerMax == V
                || MaiorMenorMax == Maior || MaiorMenorMax == Menor) {
            return true;
        } else {
            return false;
        }

    }

    public void ContDuzia(int n) {
        int d = n;
        if (d == 0) {
            Duzia1 = 0;
            Duzia3 = 0;
            Duzia2 = 0;
        }
        if (d >= 1 && d <= 12) {
            Duzia1++;
            Duzia3 = 0;
        }
        if (d >= 25 && d <= 36) {
            Duzia3++;
            Duzia1 = 0;
        }
        if (d >= 13 && d <= 24) {
            Duzia2++;
            if (Duzia1 >= 1 && Duzia3 == 0) {
                Duzia1 += Duzia2;
                Duzia3 = 0;
                Duzia2 = 0;
            }
            if (Duzia3 >= 1 && Duzia1 == 0) {
                Duzia3 += Duzia2;
                Duzia1 = 0;
                Duzia2 = 0;
            }
        }
        D12 = Duzia1;
        D32 = Duzia3;
        ContDuziaSeparado(n);
    }

    public void ContDuziaSeparado(int n) {
        int d = n;

        if (d == 0) {
            Duz1 = 0;
            Duz3 = 0;
            Duz2 = 0;
        }
        if (d >= 1 && d <= 12) {
            Duz1++;
            Duz3 = 0;
            Duz2 = 0;
        }
        if (d >= 25 && d <= 36) {
            Duz3++;
            Duz1 = 0;
            Duz2 = 0;
        }
        if (d >= 13 && d <= 24) {
            Duz2++;
            Duz1 = 0;
            Duz3 = 0;
        }
        Contcoluna(n);
    }

    public void Contcoluna(int n) {
        int d = n;
        if (d == 0) {
            coluna1 = coluna2 = coluna3 = 0;
            Duzia1 = Duzia2 = Duzia3 = 0;
        }
        if (d == 1 || d == 4 || d == 7 || d == 10 || d == 13 || d == 16
                || d == 19 || d == 22 || d == 25 || d == 28 || d == 31 || d == 34) {
            coluna1++;
            coluna3 = 0;
        }

        if (d == 3 || d == 6 || d == 9 || d == 12 || d == 15 || d == 18
                || d == 21 || d == 24 || d == 27 || d == 30 || d == 33 || d == 36) {
            coluna3++;
            coluna1 = 0;
        }
        if (d == 2 || d == 5 || d == 8 || d == 11 || d == 14 || d == 17
                || d == 20 || d == 23 || d == 26 || d == 29 || d == 32 || d == 35) {
            coluna2++;
            if (coluna1 >= 1 && coluna3 == 0) {
                coluna1 += coluna2;
                coluna3 = 0;
                coluna2 = 0;
            }
            if (coluna3 >= 1 && coluna1 == 0) {
                coluna3 += coluna2;
                coluna1 = 0;
                coluna2 = 0;
            }

        }
        C12 = coluna1;
        C23 = coluna3;
        VermPreto(n);

    }

    public void VermPreto(int p) {
        int n = p;
        if (n == 99) {

        } else if (n == 0) {
            P = 0;
            V = 0;
        } else if (n == 1 || n == 3 || n == 5 || n == 7 || n == 9 || n == 12 || n == 14 || n == 16 || n == 18 || n == 19 || n == 21
                || n == 23 || n == 25 || n == 27 || n == 30 || n == 32 || n == 34 || n == 36) {
            V++;
            P = 0;
        } else {
            P++;
            V = 0;
        }
        ParInpar(n);
    }

    public void ParInpar(int p) {
        int n = p;
        if (n == 99) {

        } else if (n == 0) {
            Par = Inpar = 0;
        } else if (n % 2 == 0) {
            Par++;
            Inpar = 0;
        } else {
            Inpar++;
            Par = 0;
        }

        MaiorMenor(n);
    }

    public void MaiorMenor(int p) {
        int n = p;
        if (n == 99) {

        } else if (n == 0) {
            Maior = Menor = 0;
        } else if (n <= 19) {
            Menor++;
            Maior = 0;
        } else {
            Maior++;
            Menor = 0;
        }

    }
    
    public String Verificar() {

        String Duzia, Coluna, ParInpar, VerPre, MaiorMenor;
        Duzia = Coluna = ParInpar = VerPre = MaiorMenor = "";

        if (coluna1 >= (ColunasMax + 1) / 2) {
            Coluna = "Coluna 1 e 2 Acumulando...";
            if (coluna1 == ColunasMax - 1) {
                Coluna = "Coluna 2 e 3 Proximo!";
            }
            if (coluna1 >= ColunasMax) {
                Coluna = "Aposte Coluna 2 e 3 ";
            }
        }

        if (coluna3 >= (ColunasMax + 1) / 2) {
            Coluna = "Coluna 2 e 3 Acumulando...";
            if (coluna3 == ColunasMax - 1) {
                Coluna = "Coluna 1 e 2 Proximo!";
            }
            if (coluna3 >= ColunasMax) {
                Coluna = "Aposte Coluna 2 e 1";
            }
        }

        if (Duzia1 >= (DuziaMax + 1) / 2) {
            Duzia = "Duzia 1 e 2 Acumulando...";
            if (Duzia1 == -1) {
                Duzia = "Duzia 2 e 3 Proximo!";
            }
            if (Duzia1 >= DuziaMax) {
                Duzia = "Aposte Duzia 2 e 3 ";
            }
        }

        if (Duzia3 >= (DuziaMax + 1) / 2) {
            Duzia = "Duzia 2 e 3 Acumulando...";
            if (Duzia3 == DuziaMax - 1) {
                Duzia = "Duzia 1 e 2 Proximo!";
            }
            if (Duzia3 >= DuziaMax) {
                Duzia = "Aposte Duzia 1 e 2";
            }
        }

        if (V >= (PreVerMax + 1) / 2) {
            VerPre = "Verm Acumulando..";
            if (V == PreVerMax - 1) {
                VerPre = "Preto Pox Att!";
            }
            if (V >= PreVerMax) {
                VerPre = "Apostar Preto!";
            }
        }

        if (P >= (PreVerMax + 1) / 2) {
            VerPre = "Preto Acumulando..";
            if (P == PreVerMax - 1) {
                VerPre = "Vermelhor Pox. Att!";
            }
            if (P >= PreVerMax) {
                VerPre = "Apostar Vermelhor!";
            }
        }

        if (Par >= (ParInparMax + 1)) {
            ParInpar = "Par Acumulando..";
            if (Par == ParInparMax - 1) {
                ParInpar = "Impar Prox Att!";
            }
            if (Par >= ParInparMax) {
                ParInpar = "Aposte Impar!";
            }
        }

        if (Inpar >= (ParInparMax + 1) / 2) {
            ParInpar = "Impar Acumulando..";
            if (Inpar == ParInparMax - 1) {
                ParInpar = "Par Prox Att!";
            }
            if (Inpar >= ParInparMax) {
                ParInpar = "Aposte Par!";

            }

        }

        if (Maior >= (MaiorMenorMax + 1) / 2) {
            MaiorMenor = "Maior Acumulando..";
            if (Maior == MaiorMenorMax - 1) {
                MaiorMenor = "Menor Prox Att!";
            }
            if (Maior >= MaiorMenorMax) {
                MaiorMenor = "Aposte Menor!";
            }
        }

        if (Menor >= (MaiorMenorMax + 1) / 2) {
            MaiorMenor = "Menor Acumulando..";
            if (Menor == MaiorMenorMax - 1) {
                MaiorMenor = "Maior Prox Att!";
            }
            if (Menor >= MaiorMenorMax) {
                MaiorMenor = "Aposte Maior!";
            }
        }

        String Resposta;
        Resposta = Coluna + "\n" + Duzia + "\n" + MaiorMenor + "\n" + ParInpar + "\n" + VerPre;
        return Resposta;

    }

    int c = 0;
    int c1 = 0;

    public boolean TesteColuna2(int d) {
        return d == 2 || d == 5 || d == 8 || d == 11 || d == 14 || d == 17
                || d == 20 || d == 23 || d == 26 || d == 29 || d == 32 || d == 35;
    }

    public boolean TesteColuna3(int d) {
        return d == 3 || d == 6 || d == 9 || d == 12 || d == 15 || d == 18
                || d == 21 || d == 24 || d == 27 || d == 30 || d == 33 || d == 36;
    }

    int p = 0;

    public void AnalisandoDadosBDVP(int i) {
        ContDuzia(i);

        DuziaMax = 9;
        ParInparMax = 9;
        PreVerMax = 9;
        MaiorMenorMax = 8;
        boolean coc = TesteColuna2(i);
        boolean coc1 = TesteColuna3(i);
        if (C12 >= ColunasMax) {
            c++;
            p = 1;
        } else if (p ==1){
            c++;
            p = 0;
        }
        if (c != 0) {
            if (c == 2) {
                if (coc || coc1) {
                    res.setEntrada("Coluna - 12 -1");
                    res.setP1("V");
                    res.setP2("-");
                    res.setP3("-");
                    res.setResultado("Ganho");
                    res.setTamanhoespera(1);
                    rdao.create(res);
                    c = 0;
                    p = 0;
                    coluna1 = 0;
                }
            }
            if (c == 3) {
                if (coc || coc1) {
                    res.setEntrada("Coluna - 12 -2");
                    res.setP1("P");
                    res.setP2("V");
                    res.setP3("-");
                    res.setResultado("Ganho");
                    res.setTamanhoespera(2);
                    rdao.create(res);
                    c = 0;
                    p = 0;
                    coluna1 = 0;
                }
            }
            if (c == 4) {
                if (coc || coc1) {
                    res.setEntrada("Coluna - 12-3");
                    res.setP1("P");
                    res.setP2("P");
                    res.setP3("V");
                    res.setResultado("Ganho");
                    res.setTamanhoespera(3);
                    rdao.create(res);
                    c = 0;
                    p = 0;
                    coluna1 = 0;
                } else {
                    res.setEntrada("Coluna - 12-4");
                    res.setP1("P");
                    res.setP2("P");
                    res.setP3("P");
                    res.setResultado("Perdido");
                    res.setTamanhoespera(3);
                    rdao.create(res);
                    c = 0;
                    p = 0;
                    coluna1 = 0;
                }
            }
        }
        /*        
         if (C23 >= ColunasMax) {
         c1++;
         } else if (c1 != 0 && coc){
         if (c1 == 2) {
         if (coc || coluna1 >= 1) {
         res.setEntrada("Coluna - 23");
         res.setP1("V");
         res.setP2("-");
         res.setP3("-");
         res.setResultado("Ganho");
         res.setTamanhoespera(1);
         rdao.create(res);
         c1 = 0;
         }
         } else if (c1 == 3) {
         if (coc || coluna1 >= 1) {
         res.setEntrada("Coluna - 23");
         res.setP1("P");
         res.setP2("V");
         res.setP3("-");
         res.setResultado("Ganho");
         res.setTamanhoespera(2);
         rdao.create(res);
         c1 = 0;
         }
         } else if (c1 == 4) {
         if (coc || coluna1 >= 1) {
         res.setEntrada("Coluna - 23");
         res.setP1("P");
         res.setP2("P");
         res.setP3("V");
         res.setResultado("Ganho");
         res.setTamanhoespera(3);
         rdao.create(res);
         c1 = 0;
         }
         } else if (c1 >= 4) {
         res.setEntrada("Coluna - 12");
         res.setP1("P");
         res.setP2("P");
         res.setP3("P");
         res.setResultado("Perdido");
         res.setTamanhoespera(3);
         rdao.create(res);
         c1 = 0;
         }
         }
         */
    }
}
