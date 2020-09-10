/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Edirlene
 */
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String CEP;
    private String cidade;

    public Endereco(String rua, String numero, String bairro, String CEP, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
    }

    public Endereco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
         
    public String getRua(){
        return rua;
    }
    public void setRua(String p_rua){
        this.rua = p_rua;
    }
    public String getNumero(){
        return numero; 
    }
    public void setNumero(String p_numero){
        this.numero = p_numero;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String p_bairro){
        this.bairro = p_bairro;
    }
    public String getCEP(){
        return CEP;
    }
    public void setCEP(String p_cep){
        this.CEP = p_cep;
    } 

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String p_cidade) {
        this.cidade = p_cidade;
    }
    
    
}
