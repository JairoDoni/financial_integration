/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gui
 */
public interface IDAO {
    
    public abstract void inserir(Object objeto);
    
    
    public abstract void atualizar(Object objeto);
    
    public abstract Object buscaPorId(int id);
    
    public abstract ArrayList buscaPorTodos();
    
    public abstract void excluir(int id);
}
