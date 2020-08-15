/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exemplar;
import java.util.*;

/**
 *
 * @author Edirlene
 */
public class EmprestimoController {
    private LinkedList<Exemplar> emprestimo;
    
    private void adicionaExemplar(Exemplar ex){
        emprestimo.add(ex);
    }
    private void removeExemplar(Exemplar ex){
        Exemplar ale;
	Iterator<Exemplar> it = emprestimo.listIterator();;
	while(it.hasNext()){
            ale = it.next();
            if(ex == ale){
		emprestimo.remove(ale);
            }
        }
    }
    
    
}
