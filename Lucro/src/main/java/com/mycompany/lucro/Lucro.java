package com.mycompany.lucro;

import java.util.Scanner;

public class Lucro {

    private int numeroClientes;

    public static void main(String[] args) {

        Lucro lucro = new Lucro();

        Scanner ler = new Scanner(System.in);

        System.out.println("DISTRIBUIDORA");
        System.out.print("Informe o número de clientes: ");
        int numeroDeClientes = ler.nextInt();
        
        lucro.setNumeroClientes(numeroDeClientes);

        lucro.calcularMediaGastoPorCliente(lucro);
        
        System.out.print("\n\n:)");
        
        ler.close();

    }

    public int getNumeroClientes() {

        return numeroClientes;

    }

    public void setNumeroClientes(int numeroClientes) {

        this.numeroClientes = numeroClientes;

    }

    public void calcularMediaGastoPorCliente(Lucro lucro) {

        Scanner ler = new Scanner(System.in);

        int numeroDeDias = 0;
        double[] mediaClientes = new double[lucro.getNumeroClientes()];
        double valorTotalGeral = 0;

        for (int i = 0; i < lucro.getNumeroClientes(); i++) {

            double valorTotalPorCliente = 0;

            System.out.print("\nQuantos dias o " + (i + 1) + "º cliente foi ao estabelecimento: ");
            numeroDeDias = ler.nextInt();

                System.out.println("\n" + (i + 1) + "º Cliente");
                System.out.print("Total gasto com Bebidas no(s) " + numeroDeDias + " Dia(s): R$");
                double valorBebidas = ler.nextDouble();
                System.out.print("Total gasto com comidas no(s) " + numeroDeDias + " Dia(s): R$");
                double valorComidas = ler.nextDouble();

                valorTotalPorCliente += valorBebidas + valorComidas;
                valorTotalGeral += valorBebidas + valorComidas;
                

            double mediaGastoPorCliente = valorTotalPorCliente / numeroDeDias;
            
            mediaClientes[i] = mediaGastoPorCliente;

        }
        
        int contador = 1;
        
        System.out.println("");
        
        for (double media : mediaClientes){
            
            System.out.printf("A média do " + contador + "º cliente: R$%.2f", media);
            System.out.println("");
            
            contador++;
            
        }
        
        lucro.calcularMediaGeral(valorTotalGeral, lucro);


    }

    public void calcularMediaGeral(double valorTotal, Lucro lucro) {
        
        double mediaGeral = valorTotal / lucro.getNumeroClientes();
        
        System.out.printf("\nA média de gasto gerais foi de: R$%.2f ", mediaGeral);
        
    }

}
