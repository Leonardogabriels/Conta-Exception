package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int number = scan.nextInt();
		System.out.print("Titular: ");
		scan.nextLine();
		String holder = scan.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = scan.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = scan.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = scan.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		scan.close();
	}

}
