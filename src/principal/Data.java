package principal;

import java.util.Calendar;

public class Data {
// Atributos
	private int minutos; // Armazena os Minutos da Data
	private int hora;   // Armazena a Hora da Data
	private int dia;   // Armazena o Dia da Data
	private int mes;  // Armazena o Mês da Data
	private int ano; // Armazena o Ano da Data
	
// Construtores
	// Construtor Para Data sem Horário
	public Data(int dia, int mes, int ano) {
		setHora(-1);    // Define a Hora como [-1] Para Identificar que a Data não Possui Horário
		setDia(dia);   // Define o Dia
		setMes(mes);  // Define o Mês
		setAno(ano); // Define o Ano
	}
	
	// Construtor Para Data com Horário
	public Data(int dia, int mes, int ano, int hora, int minutos) {
		setMinutos(minutos); // Define os Minutos
		setHora(hora);      // Define a Hora
		setDia(dia);       // Define o Dia
		setMes(mes);      // Define o Mês
		setAno(ano);     // Define o Ano
	}
	
	// Construtor Para Data e Horário Atual
	public Data() {
		setMinutos(Calendar.getInstance().get(Calendar.MINUTE));     // Define os Minutos de Acordo com o Horário da Máquina
		setHora(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));  // Define a Hora de Acordo com o Horário da Máquina
		setDia(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); // Define o Dia de Acordo com a Data da Máquina
		setMes(Calendar.getInstance().get(Calendar.MONTH) + 1);   // Define o Mês de Acordo com a Data da Máquina
		setAno(Calendar.getInstance().get(Calendar.YEAR));       // Define o Ano de Acordo com a Data da Máquina
	}
	
// Métodos
	// Retorna a Data Por Extenso
	public String exibir() {
		String horario; // Armazena a Horário por Extenso
		String mes;    // Armazena o Mês por Extenso
		
		if(getHora() == -1) { // Se a Data Não Possuir Horário
			horario = "";    // Define 'horario' como []
		} else { // Se a Data Possuir Horário
				// Define 'horario' como [['hora':'minutos'] - ]
			horario = "[" + String.format("%02d", getHora()) + ":" + String.format("%02d", getMinutos()) + "] - ";
		}
		
		switch(getMes()) {
			case 1:                 // Caso 'mes' Seja Igual a 1
				mes = "Janeiro";   // Define 'mes' como [Janeiro]
				break;
			case 2:                 // Caso 'mes' Seja Igual a 2
				mes = "Fevereiro"; // Define 'mes' como [Fevereiro]
				break;
			case 3:                 // Caso 'mes' Seja Igual a 3
				mes = "Março";     // Define 'mes' como [Março]
				break;
			case 4:                 // Caso 'mes' Seja Igual a 4
				mes = "Abril";     // Define 'mes' como [Abril]
				break;
			case 5:                 // Caso 'mes' Seja Igual a 5
				mes = "Maio";      // Define 'mes' como [Maio]
				break;
			case 6:                 // Caso 'mes' Seja Igual a 6
				mes = "Junho";     // Define 'mes' como [Junho]
				break;
			case 7:                 // Caso 'mes' Seja Igual a 7
				mes = "Julho";     // Define 'mes' como [Julho]
				break;
			case 8:                 // Caso 'mes' Seja Igual a 8
				mes = "Agosto";    // Define 'mes' como [Agosto]
				break;
			case 9:                 // Caso 'mes' Seja Igual a 9
				mes = "Setembro";  // Define 'mes' como [Setembro]
				break;
			case 10:                // Caso 'mes' Seja Igual a 10
				mes = "Outubro";   // Define 'mes' como [Outubro]
				break;
			case 11:                // Caso 'mes' Seja Igual a 11
				mes = "Novembro";  // Define 'mes' como [Novembro]
				break;
			default:                // Caso 'mes' Seja Igual a 12
				mes = "Dezembro";  // Define 'mes' como [Dezembro]
				break;
		}
		// Retorna String ['horario''dia' de 'mes' de 'ano']
		return horario + String.format("%02d", getDia()) + " de " + mes + " de " + getAno();
	}
	
	// Compara duas Datas
	public static boolean comparar(Data d1, Data d2) {
		if(d1.getDia() == d2.getDia())
			if(d1.getMes() == d2.getMes())
				if(d1.getAno() == d2.getAno())
					if(d1.getHora() == d2.getHora())
						return d1.getMinutos() == d2.getMinutos();
		return false;
	}

// Getters e Setters
	public int getMinutos() {
		return minutos;
	}

	private void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getHora() {
		return hora;
	}

	private void setHora(int hora) {
		this.hora = hora;
	}

	public int getDia() {
		return dia;
	}

	private void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	private void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	private void setAno(int ano) {
		this.ano = ano;
	}
}
