package aplicacao;
import entidades.Cliente;
import entidades.ItensPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enumeradas.StatusPedido;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe os dados do Cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de Nascimento (DD/MM/YYYY): ");
        Date dataNascimento = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome,email,dataNascimento);


        System.out.println("Informe os dados do Pedido: ");
        System.out.print("Status do Pedido: ");
        StatusPedido statusPedido = StatusPedido.valueOf(sc.next());

        Pedido pedido = new Pedido(new Date(), statusPedido, cliente);
        System.out.println();
        System.out.print("Quantos itens para esse pedido? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Informe os dados do item #" + i);
            System.out.print("Nome produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preco do Produto: ");
            Double preco = sc.nextDouble();

            Produto produto = new Produto(nomeProduto,preco);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            ItensPedido itensPedido = new ItensPedido(quantidade, preco, produto);

            pedido.addItens(itensPedido);
        }

        System.out.println();
        System.out.println("RESUMO PEDIDO: ");
        System.out.println(pedido);
    }



}
