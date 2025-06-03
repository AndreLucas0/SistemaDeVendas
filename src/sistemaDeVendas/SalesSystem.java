package sistemaDeVendas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        try {
            System.out.println("Quantas vendas deseja registrar? ");
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("=====================");
                System.out.println("Nome do produto: ");
                String name = in.next();
                System.out.println("Preço da unidade/Kg do produto: ");
                double price = in.nextDouble();
                System.out.println("Quantidade/peso em Kg: ");
                int quantity = in.nextInt();

                Product product = new Product(name, price);
                Sale sale = new Sale(product, quantity);
                sales.add(sale);
            }

            FileWriter fw = new FileWriter("Relatorios/relatorio_vendas.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Sale sale : sales) {
                bw.write(sale.generateReportLine());
                bw.newLine();
            }

            bw.close();
            System.out.println("Relatório gerado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("ERRO: entrada numérica inválida.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
