/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//import dao.BancoDeDadosException;
import dao.DBException;
import dao.ProviderDAO;
import model.Provider;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */

public class ProviderController {

    private Provider provider = null;
    private ProviderDAO db;
    private ArrayList<Provider> providerList;

    public ProviderController() throws DBException {
        this.db = new ProviderDAO();

        this.providerList = db.buscaPorTodos();
    }

    public Provider getProviders() {
        return this.provider;
    }

    public ArrayList<Provider> getListaTodosFornecedores() {
        return this.providerList;
    }
}