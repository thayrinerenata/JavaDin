package br.com.generation.dominio;

public class Utilitarios {
	
	double reservaTotal;
	double tempoReservaTotal;
	
	// Método para calcular total da reserva
	public double calculaReservaTotal(double gastosFixos, int TotalMesesReserva) {
		reservaTotal = gastosFixos * TotalMesesReserva;
		return reservaTotal;
	}
	
	// Método para calcular tempo para alcançar reserva  total
	public double calculaTempoReservaTotal(double poupancaMensal) {
		//Taxa de juros SELIC
		double taxaDeJuros = 0.0915;
		
		double tempoReservaTotalProvisorio = reservaTotal / poupancaMensal;
		 
		double jurosDoPeriodo = poupancaMensal * taxaDeJuros * tempoReservaTotalProvisorio;
		
		double novaReservaTotal = reservaTotal - jurosDoPeriodo;
		
		tempoReservaTotal = novaReservaTotal / poupancaMensal;
		 
		return tempoReservaTotal;
	}
	
	// Método para calcular tempo necessário para reserva total
	public void calculaTempo() {
			
			double ano = ((tempoReservaTotal * 30) / 360);
			double anocerto = (int) ano ; // CAST
			if ( ano >=1 ) {
				
				double validaAno = ano - anocerto; // ano = 1.57  | (int) ano = 1  > 1.57-1 = 0.57
				double ValidaMes = validaAno * 12;
				double meses = (int) ValidaMes;
				
				if( meses >=12) {
					
					double novoMes = meses - 12;
					
					System.out.printf("O tempo para atingir a reserva será de %.0f ano(s) e %.0f mes(es)", anocerto, novoMes);	
				}
				
				else if( meses >= 1 &&  meses < 12 ) {	
					System.out.printf("O tempo para atingir a reserva será de %.0f ano(s) e %.0f mes(es)", anocerto, meses); 
				}
				
				else { 
					System.out.printf("O tempo para atingir a reserva será de %.0f Ano(s)", anocerto); 
				}
			
			}
			
			else { 
					System.out.printf("O tempo para atingir a reserva será de %.0f meses", tempoReservaTotal);
				
			}
	}
}
