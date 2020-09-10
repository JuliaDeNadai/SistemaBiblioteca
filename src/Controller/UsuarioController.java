/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Administrador;
import Model.Contato;
import Model.Endereco;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class UsuarioController {
    private String[] dadosUser = new String[12];
    private DefaultTableModel dados;
    private Usuario user;
//    private Endereco end;
//    private Contato contato;

    public UsuarioController(){
        user = new Usuario();
      
    }
    
    public void adicionaUsuario(Usuario user){
        try{
            user.inserirUsuario(user);
        }catch(Exception e){
            System.err.println("Error..." +e);
        }
    }
    
    public void alteraUsuario(Usuario user){
        //integrar com banco de dados
    }
    
    public void removeUsuario(String cod){
        try{
            user.excluirUsuario(cod);
        }catch(Exception e){
            System.err.println("Error4" +e);
        }
    }
    
    public Usuario buscarUsuario(String cod){
        Usuario u = new Usuario();
        
        try{
            u = user.searchUserByID(cod);
//            System.out.println("nome " +u.getNome());
//            System.out.println("cpf " +u.getCPF());
//            System.out.println("Bairro " +u.end.getBairro());
//            System.out.println("Email " +u.contato.getEmail());
//            System.out.println("usuario " +((Administrador)u).getUser());
        }catch(Exception e){
            System.err.println("Error7" +e);
        }
        return u;
    }
    
    public Boolean realizaLogin(String user, String passwrd){
        //banco de dados
        return null;
    }
    
    // Implementação da parte de pesquisa
    public void filter(JTable table, String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dados);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    public void preencheTabela(JTable table) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        dados = new DefaultTableModel(){ 
            public boolean isCellEditable(int rowIndex, int mColIndex){ 
                 return false; 
            } 
        };
         
        Connection con = null;
        con = Conexion.connect();
        try{
            dados.setNumRows(0);
            dados.addColumn("ID");
            dados.addColumn("Nome");
            dados.addColumn("Tipo");

            result = user.getUsuarios();
            while(result.next()){
                //System.out.println("Passou");
                dados.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(11)});
            }
            
            table.setModel(dados);
        }catch(Exception e){
            System.err.println("Error3" +e);
        }
        
    }
    
}
