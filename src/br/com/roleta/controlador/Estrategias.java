package br.com.roleta.controlador;

public class Estrategias {

    public int Duzia1, D12 = 0, D32 = 0, Duzia2, Duzia3, coluna1, C12 = 0, C23 = 0,
            coluna2, coluna3, V, P, Par, Inpar, Maior, Menor;
    public int Anterios = 0, A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0, A6 = 0, A7 = 0, A8 = 0;
    public int Duz1 = 0, Duz2 = 0, Duz3 = 0;
    public int CR1 = 0, CR2 = 0, CR3 = 0;
    // Espera Para dar a Entrada de cada estrategia
    // A entrada é sempre no numero +1 q inserido
    public int ColunasMax = 10;
    public int DuziaMax = 10;
    public int ParInparMax = 10;
    public int PreVerMax = 10;
    public int MaiorMenorMax = 9;
    public int DRMax = 5;
    public int CRMax = 5;
    public int ConvertInt;

    public void ConverterInt(int n) {

        try {
            ConvertInt = n; // Caso você queira tipo int, que é o usual.
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
        ColunaRepet(n);
    }

    public void ColunaRepet(int d) {
        if (d == 1 || d == 4 || d == 7 || d == 10 || d == 13 || d == 16
                || d == 19 || d == 22 || d == 25 || d == 28 || d == 31 || d == 34) {
            CR1++;
            CR2 = 0;
            CR3 = 0;
        }
        if (d == 3 || d == 6 || d == 9 || d == 12 || d == 15 || d == 18
                || d == 21 || d == 24 || d == 27 || d == 30 || d == 33 || d == 36) {
            CR3++;
            CR2 = 0;
            CR1 = 0;
        }
        if (d == 2 || d == 5 || d == 8 || d == 11 || d == 14 || d == 17
                || d == 20 || d == 23 || d == 26 || d == 29 || d == 32 || d == 35) {
            CR2++;
            CR1 = 0;
            CR3 = 0;
        }
        // Verificar();
        VermPreto(d);

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
        MaiorMenor(p);
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

    /* public String Verificar() {

     String Duzia, Coluna, ParInpar, VerPre, MaiorMenor, ColRepet, DuzRepet;
     Duzia = Coluna = ParInpar = VerPre = MaiorMenor = ColRepet = DuzRepet = "";

      

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
     setRetonoAposta(1);
     }
     }

     if (Duzia1 >= (DuziaMax + 1) / 2) {
     Duzia = "Duzia 1 e 2 Acumulando...";
     if (Duzia1 == -1) {
     Duzia = "Duzia 2 e 3 Proximo!";
     }
     if (Duzia1 >= DuziaMax) {
     Duzia = "Aposte Duzia 2 e 3 ";
     setRetonoAposta(1);
     }
     }

     if (Duzia3 >= (DuziaMax + 1) / 2) {
     Duzia = "Duzia 2 e 3 Acumulando...";
     if (Duzia3 == DuziaMax - 1) {
     Duzia = "Duzia 1 e 2 Proximo!";
     }
     if (Duzia3 >= DuziaMax) {
     Duzia = "Aposte Duzia 1 e 2";
     setRetonoAposta(1);
     }
     }

     if (V >= (PreVerMax + 1) / 2) {
     VerPre = "Verm Acumulando..";
     if (V == PreVerMax - 1) {
     VerPre = "Preto Pox Att!";
     }
     if (V >= PreVerMax) {
     VerPre = "Apostar Preto!";
     setRetonoAposta(1);
     }
     }

     if (P >= (PreVerMax + 1) / 2) {
     VerPre = "Preto Acumulando..";
     if (P == PreVerMax - 1) {
     VerPre = "Vermelhor Pox. Att!";
     }
     if (P >= PreVerMax) {
     VerPre = "Apostar Vermelhor!";
     setRetonoAposta(1);
     }
     }

     if (Par >= (ParInparMax + 1)) {
     ParInpar = "Par Acumulando..";
     if (Par == ParInparMax - 1) {
     ParInpar = "Impar Prox Att!";
     }
     if (Par >= ParInparMax) {
     ParInpar = "Aposte Impar!";
     setRetonoAposta(1);
     }
     }

     if (Inpar >= (ParInparMax + 1) / 2) {
     ParInpar = "Impar Acumulando..";
     if (Inpar == ParInparMax - 1) {
     ParInpar = "Par Prox Att!";
     }
     if (Inpar >= ParInparMax) {
     ParInpar = "Aposte Par!";
     setRetonoAposta(1);

     }

     }

     if (Maior >= (MaiorMenorMax + 1) / 2) {
     MaiorMenor = "Maior Acumulando..";
     if (Maior == MaiorMenorMax - 1) {
     MaiorMenor = "Menor Prox Att!";
     }
     if (Maior >= MaiorMenorMax) {
     MaiorMenor = "Aposte Menor!";
     setRetonoAposta(1);
     }
     }

     if (Menor >= (MaiorMenorMax + 1) / 2) {
     MaiorMenor = "Menor Acumulando..";
     if (Menor == MaiorMenorMax - 1) {
     MaiorMenor = "Maior Prox Att!";
     }
     if (Menor >= MaiorMenorMax) {
     MaiorMenor = "Aposte Maior!";
     setRetonoAposta(1);
     }
     }

     if (CR1 >= (CRMax + 1) / 2) {
     ColRepet = "Coluna1 Acumulando..";
     if (CR1 == CRMax - 1) {
     ColRepet = "Col 2 e 3 Att!";
     }
     if (CR1 >= CRMax) {
     ColRepet = "Aposte Col 2 e 3!";
     }
     }

     if (CR2 >= (CRMax + 1) / 2) {
     ColRepet = "Coluna2 Acumulando..";
     if (CR2 == CRMax - 1) {
     ColRepet = "Col 1 e 3 Att!";
     }
     if (CR2 >= CRMax) {
     ColRepet = "Aposte Col 1 e 3!";
     }
     }

     if (CR3 >= (CRMax + 1) / 2) {
     ColRepet = "Coluna3 Acumulando..";
     if (CR3 == CRMax - 1) {
     ColRepet = "Col 1 e 2 Att!";
     }
     if (CR3 >= CRMax) {
     ColRepet = "Aposte Col 1 e 2!";
     }
     }

     if (DR1 >= (DRMax + 1) / 2) {
     DuzRepet = "Duzia 1 Acumulando..";
     if (DR1 == DRMax - 1) {
     DuzRepet = "Duz 2 e 3 Att!";
     }
     if (DR1 >= DRMax) {
     DuzRepet = "Aposte Duz 2 e 3!";
     }
     }

     if (DR2 >= (DRMax + 1) / 2) {
     DuzRepet = "Duzia 2 Acumulando..";
     if (DR2 == DRMax - 1) {
     DuzRepet = "Duz 1 e 3 Att!";
     }
     if (DR2 >= DRMax) {
     DuzRepet = "Aposte Duz 1 e 3!";
     }
     }

     if (DR3 >= (DRMax + 1) / 2) {
     DuzRepet = "Duzia 3 Acumulando..";
     if (DR3 == DRMax - 1) {
     DuzRepet = "Duz 1 e 2 Att!";
     }
     if (DR3 >= DRMax) {
     DuzRepet = "Aposte Duz 1 e 2!";
     }
     }

     String Resposta;
     Resposta = Coluna + "\n" + Duzia + "\n" + MaiorMenor + "\n" + ParInpar + "\n" + VerPre + "\n" + DuzRepet + "\n" + ColRepet;
     return Resposta;

     } */
}
