/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Usuario;
import java.util.*;


public class UsuarioController {
    private String[] dadosUser = new String[12];
    
    public UsuarioController(){
       
    }
    
    public void adicionaUsuario(Usuario user){
        //integrar com banco de dados
        preencheTabela(0);
    }
    
    public void alteraUsuario(Usuario user){
        //integrar com banco de dados
        preencheTabela(0);
    }
    
    public void removeUsuario(int cod){
        //integrar com banco de dados
        preencheTabela(0);
    }
    
    public void removeUsuario(int cod[]){
        //integrar com banco de dados
        preencheTabela(0);
    }
    
    public Usuario buscarUsuario(int cod){
        Usuario user ;
        return null;
    }
    
    public void preencheTabela(int op){
        switch(op){
            case 0:
                //integrar com banco de dados
                break;
            case 1:
                //integrar com banco de dados
                break;
            default:
                //integrar com banco de dados
        }
    }
}
