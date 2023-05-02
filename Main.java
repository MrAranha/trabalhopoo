import java.io.*;
import java.util.*;
import Actions.Ganho;
import Enums.Meses;
import Actions.*;

public class Main {
    public static void main(String[] args) {
        boolean Menu = true;
        int escolha = 0;
        Scanner scanner = new Scanner(System.in);

        Ganho[] ganho = new Ganho[64];
        int ganhoIndex = 0;

        Gasto[] gasto = new Gasto[64];
        int gastoIndex = 0;

        System.out.println("Selecione o tipo de gasto:");
        while (Menu) {
            System.out.println("1: Ganho");
            System.out.println("2: Gasto");
            System.out.println("3: Relatorio");
            try {
                escolha = scanner.nextInt();
                if (escolha < 1 || escolha > 3) {
                    System.out.println("Apenas insira números de 1 a 3!");
                }
            } catch (Exception ex) {
                System.out.println("Apenas insira números de 1 a 3!");
                Menu = false;
            }
            switch (escolha) {
                case 1:
                    System.out.print("Insira o nome de seu ganho:");
                    String nome = scanner.next();
                    System.out.print("Insira valor de seu ganho:");
                    double value = scanner.nextDouble();
                    Meses mescolha = escolhaMeses.mesEscolha();
                    Ganho newGanho = new Ganho(nome, value, mescolha);
                    ganho[ganhoIndex] = newGanho;
                    ganhoIndex++;
                    break;
                case 2:
                    System.out.print("Insira o nome de seu gasto:");
                    String nomeGasto = scanner.next();
                    System.out.print("Insira valor de seu gasto:");
                    double valueGasto = scanner.nextDouble();
                    Meses mescolhaGasto = escolhaMeses.mesEscolha();
                    Gasto newgasto = new Gasto(nomeGasto, valueGasto, mescolhaGasto);
                    gasto[gastoIndex] = newgasto;
                    gastoIndex++;
                    break;
                case 3:
                    System.out.print("Escolha o Mês para o relatório:");
                    Meses mescolhaRelatorio = escolhaMeses.mesEscolha();

                    System.out.print("Relatório: \n");
                    for (int i = 0; i < gasto.length; i++) {
                        if (gasto[i].Mes == mescolhaRelatorio)
                            System.out.print("Gasto: " + gasto[i].NomeGasto + "\n" + "Valor: " + gasto[i].ValorGasto);
                    }

                    System.out.println("=================================");
                    for (int j = 0; j < ganho.length; j++) {
                        if (ganho[j].Mes == mescolhaRelatorio)
                            System.out.print("Gasto: " + ganho[j].NomeGanho + "\n" + "Valor: " + ganho[j].ValorGanho);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}