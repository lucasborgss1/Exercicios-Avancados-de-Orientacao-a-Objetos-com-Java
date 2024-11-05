package aplicacao;

import entidades.Contribuintes;
import entidades.Fisico;
import entidades.Juridico;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Contribuintes> lista = new ArrayList<>();

        System.out.print("Informe o numero de Contribuintes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contribuinte #" + i + ":");
            System.out.print("Pessoa fisica ou juridica (f/j)?");
            char type = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Renda Anual: ");
            Double rendaAnual = sc.nextDouble();

            switch (type) {
                case 'f':
                    System.out.print("Despesas com saúde: ");
                    Double despesaSaude = sc.nextDouble();
                    lista.add(new Fisico(nome, rendaAnual, despesaSaude));
                    break;
                case 'j':
                    System.out.print("Numero de empregados: ");
                    Integer numeroEmpregados = sc.nextInt();
                    lista.add(new Juridico(nome, rendaAnual, numeroEmpregados));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }

        }
        System.out.println("Impostos pagos: ");
        double soma = 0.0;
        for(Contribuintes contribuintes : lista) {
           Double valorImposto = contribuintes.imposto();
           System.out.println(contribuintes.getNome() + ": R$"+ String.format("%.2f", valorImposto));
            soma += valorImposto;
        }

        System.out.println();
        System.out.println("Impostos Totais: R$" + String.format("%.2f", soma));
    }
}
