package br.com.generation.dominio;

public class Pessoa {

	private String nome;
	private int idade;
	private double renda;
	private double gastosFixos;
	
	public Pessoa() {
	
	}
	
	public Pessoa(String nome, int idade, double renda, double gastosFixos) {
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.gastosFixos = gastosFixos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public double getGastosFixos() {
		return gastosFixos;
	}

	public void setGastosFixos(double gastosFixos) {
		this.gastosFixos = gastosFixos;
	}
}
