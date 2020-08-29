package Model;

import java.util.*;

public class Usuario {
	protected int cod;
	protected String nome;
        protected String cpf;
        protected String tipo;
        Endereco end;
        Contato contato;

        public Usuario(String nome, String cpf, String tipo, Endereco end, Contato contato) {
            this.nome = nome;
            this.cpf = cpf;
            this.tipo = tipo;
            this.end = end;
            this.contato = contato;
        }
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int p_cod) {
		this.cod = p_cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String p_nome) {
		this.nome = p_nome;
	}
        public String getCP() {
		return cpf;
	}
	public void setCPF(String p_cpf) {
		this.cpf = p_cpf;
	}

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String p_tipo) {
            this.tipo = p_tipo;
        }
        
}
