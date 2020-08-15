package Model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Emprestimo {
	private int cod;
	private String dataEmprestimo;
	private String dataDevolucao;
	private LinkedList<Exemplar> exemplares;
	private Cliente cliente;
	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
	
	
	public void setExemplares(LinkedList<Exemplar> exemplares){
		this.exemplares = exemplares;
	}
	
	public void realizarEmprestimo(){
		
		for(Exemplar ale: exemplares){
			//ale.emprestado();
		}
	}
	
	public void realizarDevolucao(){
		for(Exemplar ale: exemplares){
			//ale.devolvido();
		}
	}

	//--------------------gets e sets----------------------------------------------------
	
	public String getDataEmprestimo() {
		formatador.format( data );
		String result = data.toString();
		this.dataEmprestimo = result;
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String p_dataEmprestimo) {
		this.dataEmprestimo = p_dataEmprestimo;
	}
	
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String p_dataDevolucao) {
		this.dataDevolucao = p_dataDevolucao;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}
	
}