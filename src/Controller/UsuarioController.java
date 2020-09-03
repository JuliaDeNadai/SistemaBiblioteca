/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Usuario;
import java.util.*;
import javax.swing.JTable;


public class UsuarioController {
    private String[] dadosUser = new String[12];
    
    public UsuarioController(){
       
    }
    
    public void adicionaUsuario(Usuario user){
        //integrar com banco de dados
        
    }
    
    public void alteraUsuario(Usuario user){
        //integrar com banco de dados
    }
    
    public void removeUsuario(int cod){
        //integrar com banco de dados
    }
    
    public void removeUsuario(int cod[]){
        //integrar com banco de dados
    }
    
    public Usuario buscarUsuario(int cod){
        Usuario user ;
        return null;
    }
    
    public void preencheTabela(JTable table){
       
    }
    
    public void preencheTabela(JTable table, String cod){
       
    }
    
    public void preencheTabela(JTable table, int op){
        switch(op){
            case 0:
                //integrar com banco de dados todos
                break;
            case 1:
                //integrar com banco de dados cliente
                break;
            default:
                //integrar com banco de dados adm
        }
    }
}
