/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import java.util.*;


public class ClienteController {
    private LinkedList<Cliente> clientes;
    
    public ClienteController(){
        clientes = new LinkedList<Cliente>();
    }
    
    private void AdicionaCliente(Cliente cli){
        clientes.add(cli);
    }
    
    private void RemoveCliente(Cliente cli){
        Cliente ale;
	Iterator<Cliente> it = clientes.listIterator();;
	while(it.hasNext()){
            ale = it.next();
            if(cli == ale){
		clientes.remove(ale);
            }
        }
    }
    
    private List<Cliente> getClientes(){
        return clientes;
    }
}
