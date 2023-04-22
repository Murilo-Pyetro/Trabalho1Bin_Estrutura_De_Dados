
package br.unipar.trabalho1binestdedados;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Trabalho1BinEstDeDados {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] vetor;
        int n, opcao;

        System.out.print("Informe o tamanho do vetor: ");
        n = input.nextInt();
        
        vetor = new int[n];
        System.out.println("Informe os elementos do vetor:");
        for(int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i+1) + ": ");
            vetor[i] = input.nextInt();
        }
        

        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Ordenação por inserção");
        System.out.println("2 - Ordenação por seleção");
        System.out.println("3 - Ordenação bolha");
        opcao = input.nextInt();
        
        switch(opcao) {
            case 1:
                vetor = ordenacaoInsercao(vetor);
                System.out.println("Vetor ordenado por inserção:");
                break;
            case 2:
                vetor = ordenacaoSelecao(vetor);
                System.out.println("Vetor ordenado por seleção:");
                break;
            case 3:
                vetor = ordenacaoBolha(vetor);
                System.out.println("Vetor ordenado por bolha:");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        for(int i = 0; i < n; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
    
    public static int[] ordenacaoInsercao(int[] vetor) {
        int chave, j;
        for(int i = 1; i < vetor.length; i++) {
            chave = vetor[i];
            j = i - 1;
            while(j >= 0 && vetor[j] > chave) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = chave;
        }
        return vetor;
    }
    
    public static int[] ordenacaoSelecao(int[] vetor) {
        int menor, aux;
        for(int i = 0; i < vetor.length-1; i++) {
            menor = i;
            for(int j = i+1; j < vetor.length; j++) {
                if(vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            aux = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = aux;
        }
        return vetor;
    }
    
    public static int[] ordenacaoBolha(int[] vetor) {
        int aux;
        boolean trocou;
        for(int i = 0; i < vetor.length-1; i++) {
            trocou = false;
            for(int j = 0; j < vetor.length-1-i; j++) {
                if(vetor[j] > vetor[j+1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                    trocou = true;
                }
            }
            if(!trocou) {
                break;
            }
        }
        return vetor;
    }
}
