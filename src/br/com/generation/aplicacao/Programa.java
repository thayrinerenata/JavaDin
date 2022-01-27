package br.com.generation.aplicacao;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.com.generation.dominio.Pessoa;
import br.com.generation.dominio.Utilitarios;
import br.com.generation.ui.UI;

public class Programa {

	public static void main(String[] args) {
		
		int idade = 0;
		double renda = 0;
		double gastosFixos = 0;
		double poupancaMensal = 0;
		
		boolean erroInt = true;
		boolean erroRenda = true;
		boolean errogastosFixos = true;
		boolean erroPoupancaMensal = true;
		
		// Instanciando as classes UI e Utilitarios
		UI ui = new UI();
		Utilitarios conta = new Utilitarios();
		
		//Iniciando variável salarioMinimo com base no valor do salário mínimo ano base 2021
		double salarioMinimo = 1100.00;
		
		// Instanciando a classe Locale para usar o "." como separador de casas decimais
		Locale.setDefault(Locale.US);
		
		// Instanciando a classe Scanner para permitir entrada de dados a partir da digitação do usuário
		Scanner sc = new Scanner(System.in);
		
		// Mostrando o logo JavaDin
		ui.logoJavaDin();
		
		System.out.println();
		System.out.println();
		
		// Coletando dados do usuário
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		
		if(nome .matches("^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\s]*$")){
	        
	    } else {
	    	do {
	    		System.err.println("Informe apenas letras!");
	    		System.out.print("Digite seu nome: ");
	    		nome = sc.nextLine();
	    	} while (!nome .matches("^[a-zA-Z-áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\s]*$"));
	    }
		
		/*System.out.print("Digite sua idade: ");
		int idade = sc.nextInt();*/
		
		// Erro int
		do{
			try{
				System.out.print("Digite sua idade: ");
				idade = sc.nextInt();
				erroInt = false;

			}catch (InputMismatchException erro1) {
				System.err.println("Informe apenas números inteiros");
				sc.nextLine(); //descarta a entrada errada do usuário
			}
		}while(erroInt);
		
		/*System.out.print("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.println("Considere: água, luz, telefone/internet, aluguel/financiamento, alimentação");
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		double gastosFixos = sc.nextDouble();*/
		
		// Erro renda
		do{
			try{
				System.out.print("Digite a sua renda total: ");
				renda = sc.nextDouble();
				erroRenda = false;

			}catch (InputMismatchException erro2) {
				System.err.println("Informe apenas números!");
				sc.nextLine(); //descarta a entrada errada do usuário
			}
		}while(erroRenda);
		
		// Erro gastos fixos
		do{
			try{
				System.out.println("Considere: água, luz, telefone/internet, aluguel/financiamento, alimentação");
				System.out.print("Informe o total de seus gastos fixos mensais: ");
				gastosFixos = sc.nextDouble();
				errogastosFixos = false;

			}catch (InputMismatchException erro3) {
				System.err.println("Informe apenas números!");
				sc.nextLine(); //descarta a entrada errada do usuário
			}
		}while(errogastosFixos);
		
		System.out.println();
		
		// Instanciando a classe Pessoa
		Pessoa pessoa = new Pessoa(nome, idade, renda, gastosFixos);
		
		// Cálculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		// Verificando se o usuário está apto a começar a poupar ou precisa organizar sua vida financeira antes
		if (porcenGastos <= 0.50) {
			
			/*System.out.print("Qual valor mensal você pretende poupar: ");
			poupancaMensal = sc.nextDouble();*/
			
			// Erro poupança mensal
			do{
				try{
					System.out.print("Qual valor mensal você pretende poupar: ");
					poupancaMensal = sc.nextDouble();
					erroPoupancaMensal = false;

				}catch (InputMismatchException erro4) {
					System.err.println("Informe apenas números!");
					sc.nextLine(); //descarta a entrada errada do usuário
				}
			}while(erroPoupancaMensal);
			
			int TotalMesesReserva;
			
			do {
				System.out.println("Considere: 6, 12 ou 18 meses: ");
				System.out.print("Quanto meses de reserva você quer: ");
				TotalMesesReserva = sc.nextInt();
				
			} while (TotalMesesReserva != 6 && TotalMesesReserva != 12 && TotalMesesReserva != 18);
			
			// Mostrando os dados do usuário
			System.out.println("");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade() + " anos");

			System.out.println("Sua reserva total necessária será: R$ " + conta.calculaReservaTotal(gastosFixos, TotalMesesReserva));
			System.out.println("Investindo R$ " + poupancaMensal + " por mês no Tesouro SELIC: ");
			
			conta.calculaTempoReservaTotal(poupancaMensal);
			conta.calculaTempo();
			
		} else {
			
			if (porcenGastos <= 0.60) {
				
				if (renda <= (salarioMinimo * 1.5)) {
					
					ui.dicaMenorUmSalMinEMenor60PC();
					
				} else {
					
					ui.dicaMaiorUmSalMinEMenor60PC();
					
				}
				
			} else {
				
				if (renda <= (salarioMinimo * 1.5)) {
					
					ui.dicaMenorUmSalMinEMaior60PC();
					
				} else {
					
					if(renda > (salarioMinimo * 5)) {
						
						ui.dicaRendaMaiorCincoSalMinEMaior60PC();
						
					} else {
						
						ui.dicaRendaMenorCincoSalMinEMaior60PC();
						
					}
				}
			}
		}
	}
}
