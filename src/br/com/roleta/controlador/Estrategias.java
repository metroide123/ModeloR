package br.com.roleta.controlador;

public class Estrategias {

    // Variavei de Conta Intervalos de Acordo com as Estrategias
    public int Duzia1, D12 = 0, D32 = 0, Duzia2, Duzia3, coluna1, C12 = 0, C23 = 0;
    public int coluna2, coluna3, V, P, Par, Inpar, Maior, Menor;
    public int Duz1 = 0, Duz2 = 0, Duz3 = 0;
    public int CR1 = 0, CR2 = 0, CR3 = 0;
    public int AlterNaC1C3 = 0;
    public int AlterC1 = 0;
    public int AlterC3 = 0;
    public int AlterNaD1D3 = 0;
    public int AltD1 = 0;
    public int AltD3 = 0;
    public int alternaPreto = 0, alternaVermelho = 0;
    public int alternaMaiorMenor = 0;
    public int alternaParImpar = 0;

    // Variaveis para Acumular numros anteriores e setar setar na tela da roleta
    public int Anterios = 0, A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0, A6 = 0, A7 = 0, A8 = 0;

    // Varivais que recebem o tamanho da espera setado pela ChamadoRoleta em cada estrategia
    // atenção ainda não esta recebendo 
    public int ConvertInt;

    public void ConverterInt(int n) {

        try {
            ConvertInt = n; // Caso você queira tipo int, que é o usual.
        } catch (NumberFormatException e) {
            ConvertInt = 99;
        }
        if (ConvertInt == 99) {

        } else if (ConvertInt == Anterios) {

        } else { // Monta A sequencia de 11 numeros sorteados e vai ser chamado pra Roletatela
            A8 = A7;
            A7 = A6;
            A6 = A5;
            A5 = A4;
            A4 = A3;
            A3 = A2;
            A2 = A1;
            A1 = Anterios;
            Anterios = ConvertInt;
            // Chama o metodo de Contar as Duzias 
            ContDuzia(ConvertInt);

        }

    }

    // Metodo que conta as Duzias e incremeta 
    // Estrategia de espera em duas Duzias. Ex Numeros Acumulads nas duzias 1 e 2 ou 2 e 3;
    public void ContDuzia(int n) {
        int d = n;
        // Repetido em todos os metodos Zerando todos os contadores caso caia zero
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
        // recebe o numero acumulado de cada Duzia por isso o nome 12 ou 23 pois recebe os numeros caidos na
        // Duzia 2 e a adjacente que venha em sequencia
        D12 = Duzia1;
        D32 = Duzia3;
        // Chama proximo metodo Contador
        AlternaDuzia(n);
    }

    // Estrategia que Conta e Alterna As Duzias 1 e 3
    public void AlternaDuzia(int n) {
        int d = n;

        if (d == 0) {
            AlterNaD1D3 = 0;
            AltD3 = 0;
            AltD1 = 0;
        } else if (d >= 1 && d <= 12) {
            AltD1++;
            if (AlterNaD1D3 == 0) {
                AlterNaD1D3 += AltD1;
            }
            if (AltD3 > 0) {
                AlterNaD1D3 += AltD1;
                AltD3 = 0;
            }
            if (AltD1 > 1) {
                AlterNaD1D3 = 0;
            }
        } else if (d >= 25 && d <= 36) {
            AltD3++;
            if (AlterNaD1D3 == 0) {
                AlterNaD1D3 += AltD3;
            }
            if (AltD1 > 0) {
                AlterNaD1D3 += AltD3;
                AltD1 = 0;
            }
            if (AltD3 > 1) {
                AlterNaD1D3 = 0;
            }
        } else if (d >= 13 && d <= 24) {
            AlterNaD1D3 = 0;
            AltD1 = 0;
            AltD3 = 0;

        }

        ContDuziaSeparado(n);
    }

    // Metodo que Conta as Duzias Separadamente para A nova estrategia
    // Estrategia que espera individualmente numeros repetido de determinada duzia para Apostar nas duas opostas. 
    // Ex: Cai 5x a Duzia 1 apostase na duzia 2 e 3
    public void ContDuziaSeparado(int n) {
        int d = n;

        if (d == 0) {
            Duz1 = 0;
            Duz3 = 0;
            Duz2 = 0;
        } else if (d >= 1 && d <= 12) {
            Duz1++;
            Duz3 = 0;
            Duz2 = 0;
        } else if (d >= 25 && d <= 36) {
            Duz3++;
            Duz1 = 0;
            Duz2 = 0;
        } else if (d >= 13 && d <= 24) {
            Duz2++;
            Duz1 = 0;
            Duz3 = 0;
        }
        // Chama proximo metodo contador
        AlternaColuna(n);
    }

    // Estrategia Que Conta e alterna as Colunas 1 e 3
    public void AlternaColuna(int n) {
        int d = n;

        if (d == 0) {
            AlterNaC1C3 = 0;
            AlterC3 = 0;
            AlterC1 = 0;
        } else if (d == 1 || d == 4 || d == 7 || d == 10 || d == 13 || d == 16
                || d == 19 || d == 22 || d == 25 || d == 28 || d == 31 || d == 34) {
            AlterC1++;
            if (AlterNaC1C3 == 0) {
                AlterNaC1C3 += AlterC1;
            }
            if (AlterC3 > 0) {
                AlterNaC1C3 += AlterC1;
                AlterC3 = 0;
            }
            if (AlterC1 > 1) {
                AlterNaC1C3 = 0;
            }
        } else if (d == 3 || d == 6 || d == 9 || d == 12 || d == 15 || d == 18
                || d == 21 || d == 24 || d == 27 || d == 30 || d == 33 || d == 36) {
            AlterC3++;
            if (AlterNaC1C3 == 0) {
                AlterNaC1C3 += AlterC3;
            }
            if (AlterC1 > 0) {
                AlterNaC1C3 += AlterC3;
                AlterC1 = 0;
            }
            if (AlterC3 > 1) {
                AlterNaC1C3 = 0;
            }
        } else if (d == 2 || d == 5 || d == 8 || d == 11 || d == 14 || d == 17
                || d == 20 || d == 23 || d == 26 || d == 29 || d == 32 || d == 35) {
            AlterNaC1C3 = 0;
            AlterC3 = 0;
            AlterC1 = 0;

        }

        Contcoluna(n);
    }

    // Metodo que conta as colunas
    // Mesma coisa da estategia das duzia que acumula em duas e aposta nas duas opostas
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
        // recebe o numero acumulado de cada Coluna por isso o nome 12 ou 23 pois recebe os numeros caidos na
        // coluna 2 e a adjacente que venha em sequencia
        C12 = coluna1;
        C23 = coluna3;

        // Chama proximo Metodo
        ColunaRepet(n);
    }

    // Metodo que conta as colunas individualemente
    // Mesma coisa da estrategia das duzias individuais, aguarda o acumulo em uma determinada duzia e
    // aposta-se nas colunas adjacentes.
    public void ColunaRepet(int d) {
        if (d == 0) {
            CR1 = 0;
            CR2 = 0;
            CR3 = 0;
        } else if (d == 1 || d == 4 || d == 7 || d == 10 || d == 13 || d == 16
                || d == 19 || d == 22 || d == 25 || d == 28 || d == 31 || d == 34) {
            CR1++;
            CR2 = 0;
            CR3 = 0;
        } else if (d == 3 || d == 6 || d == 9 || d == 12 || d == 15 || d == 18
                || d == 21 || d == 24 || d == 27 || d == 30 || d == 33 || d == 36) {
            CR3++;
            CR2 = 0;
            CR1 = 0;
        } else if (d == 2 || d == 5 || d == 8 || d == 11 || d == 14 || d == 17
                || d == 20 || d == 23 || d == 26 || d == 29 || d == 32 || d == 35) {
            CR2++;
            CR1 = 0;
            CR3 = 0;
        }

        // Chamada do proximo metodo
        VermPreto(d);

    }

    // Metodo que conta e verifica se o numero é vermelho ou preto
    public void VermPreto(int p) {
        int n = p;
        // if para Diferenciar Caso seja 99 pois o proximo teste so verifica se é Vermelho Caso não seja já é dado como preto
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
        //Chamada do proximo Metodo
        ParInpar(n);
    }

    // Metodo que conta e verifica se o numero é Par ou Impar
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

    // Metodo que conta e verifica se o numero é Maior que 19 ou Menor
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
        AlternaCor(n);
    }

    public void AlternaCor(int p) {
        int n = p;
        System.out.println(n + " " + alternaPreto + " " + alternaVermelho);

        if (n == 99) {

        } else if (n == 0) {
            alternaPreto = alternaVermelho = 0;
        } else if (alternaPreto == alternaVermelho) {
            if (V > 0) {
                alternaVermelho++;
            } else {
                alternaPreto++;
            }
        } else if (alternaPreto == 0 && V == 0) {
            alternaPreto = (alternaVermelho + 1)/2;
            alternaVermelho = 0;
        } else if (alternaVermelho == 0 && P == 0) {
            alternaVermelho = (alternaPreto + 1)/2;
            alternaPreto = 0;
        } else {
            if (P > 1)
                alternaPreto = 1;
            else              
                alternaVermelho = 1;
        }
         System.out.println(n + " " + alternaPreto + " " + alternaVermelho);
    }
}
