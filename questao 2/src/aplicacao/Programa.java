package aplicacao;

import entidades.Produto;
import entidades.ProdutoUsado;
import entidades.ProdutoImportado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List<Produto> listaDeProdutos = new ArrayList<>();

        System.out.print("Informe o numero de Produtos: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do produto #" + i);
            System.out.print("Comum, Usado ou Importado (c,u,i)? ");
            char tipo = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Informe o nome do produto: ");
            String nome = sc.nextLine();
            System.out.print("Preco: ");
            double preco = sc.nextDouble();

            switch (tipo) {
                case 'c':
                    listaDeProdutos.add(new Produto(nome,preco));
                    break;
                case 'u':
                    System.out.print("Data de fabricação (DDMMYYYY): ");
                    LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("ddMMyyyy"));
                    listaDeProdutos.add(new ProdutoUsado(nome, preco, data));
                    break;
                case 'i':
                    System.out.print("Taxa de importação: ");
                    double taxa = sc.nextDouble();
                    listaDeProdutos.add(new ProdutoImportado(nome, preco, taxa));
                    break;
                default:
                    System.out.println("Esta classificação de produto não existe.");
                    System.out.println("Vamos considera-lo Comum");
                    listaDeProdutos.add(new Produto(nome,preco));
                    break;
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PREÇO: ");
        for (Produto produto: listaDeProdutos){
            System.out.println(produto.etiqueta());
        }
    }
}
