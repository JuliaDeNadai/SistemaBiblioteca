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
public class Artigo extends Exemplar {
    private String instituicao;
    private String departamento;

    public Artigo(String instituicao, String departamento, String titulo, String autor, String ano) {
        super(titulo, autor, ano, "Artigo");
        this.instituicao = instituicao;
        this.departamento = departamento;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
}
