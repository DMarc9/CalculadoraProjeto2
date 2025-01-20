import java.util.Scanner;

public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] salariosBrutos = new double[5];

        System.out.println("Digite os salários brutos dos 5 funcionários:");
        for (int i = 0; i < salariosBrutos.length; i++) {
            System.out.print("Salário " + (i + 1) + ": ");
            salariosBrutos[i] = scanner.nextDouble();
        }

        System.out.println("\nCálculo dos salários líquidos com base nos descontos de INSS e IR:");

        int contador = 1;
        for (double salarioBruto : salariosBrutos) {
            double descontoINSS = calcularINSS(salarioBruto);
            double descontoIR = calcularIR(salarioBruto - descontoINSS);
            double salarioLiquido = salarioBruto - descontoINSS - descontoIR;

            System.out.printf("\nFuncionário %d:\n", contador++);
            System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: R$ %.2f\n", descontoINSS);
            System.out.printf("Desconto IR: R$ %.2f\n", descontoIR);
            System.out.printf("Salário Líquido: R$ %.2f\n", salarioLiquido);
        }

        scanner.close();
    }

    public static double calcularINSS(double salario) {
        double desconto = 0;
        if (salario <= 1212.00) {
            desconto = salario * 0.075;
        } else if (salario <= 2427.35) {
            desconto = (1212.00 * 0.075) + ((salario - 1212.00) * 0.09);
        } else if (salario <= 3641.03) {
            desconto = (1212.00 * 0.075) + (1215.35 * 0.09) + ((salario - 2427.35) * 0.12);
        } else if (salario <= 7087.22) {
            desconto = (1212.00 * 0.075) + (1215.35 * 0.09) + (1213.68 * 0.12) + ((salario - 3641.03) * 0.14);
        } else {
            desconto = (1212.00 * 0.075) + (1215.35 * 0.09) + (1213.68 * 0.12) + (3446.19 * 0.14);
        }
        return desconto;
    }

    public static double calcularIR(double salarioBase) {
        double desconto = 0;
        if (salarioBase <= 1903.98) {
            return 0;
        } else if (salarioBase <= 2826.65) {
            desconto = (salarioBase - 1903.98) * 0.075;
        } else if (salarioBase <= 3751.05) {
            desconto = (2826.65 - 1903.98) * 0.075 + ((salarioBase - 2826.65) * 0.15);
        } else if (salarioBase <= 4664.68) {
            desconto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + ((salarioBase - 3751.05) * 0.225);
        } else {
            desconto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + (4664.68 - 3751.05) * 0.225 + ((salarioBase - 4664.68) * 0.275);
        }
        return desconto;
    }
}
