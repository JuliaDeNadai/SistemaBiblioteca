package Model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Emprestimo {
	private int cod;
        private String codCliente;
	private String dataEmprestimo;
	private String dataDevolucao;
        private float multa; 
	private LinkedList<Exemplar> exemplares;
	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
	public Emprestimo(String p_codCliente, LinkedList<Exemplar> p_exemplares){
            this.codCliente = p_codCliente;
            this.exemplares = p_exemplares; 
            this.multa = 0;
            //dataEmprestimo = pegar data atual computador
            //dataDevolucao = dataEmprestimo + 7
        }
	
	public void realizarEmprestimo(LinkedList<Exemplar> exemplares){
		
		for(Exemplar ale: exemplares){
			//ale.emprestado();
		}
	}
	
	public void realizarDevolucao(){
		for(Exemplar ale: exemplares){
			//ale.devolvido();
		}
	}

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
        
        public void setMulta(float p_multa) {
		this.multa = p_multa;
	}
        
        public float getMulta() {
		return multa;
	}

        public String getCodCliente() {
            return codCliente;
        }

        public void setCodCliente(String codCliente) {
            this.codCliente = codCliente;
        }
}