/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBException;
import dao.ClientDAO;
import model.Client;
import java.util.ArrayList;


/**
 *
 * @author jairo
 */
public class ClientController {
    
    private Client client = null;
    private ClientDAO db;
    private ArrayList<Client> clientList;

    public ClientController() throws DBException {
        this.db = new ClientDAO();
        this.clientList = db.buscaPorTodos();
    }

    public Client getProviders() {
        return this.client;
    }

    public ArrayList<Client> getClientList() {
        return this.clientList;
    }
}

