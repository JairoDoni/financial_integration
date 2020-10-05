/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBException;
import dao.DebitsDAO;
import dao.ProviderDAO;
import model.Debits;
import model.Provider;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author jairo
 */
public class DebitController {
    
    private DebitsDAO db;
    private Debits debits = null;
    private ArrayList<Debits> debitList;
    private int indice = 0;

    public DebitController() throws DBException {
        this.db = new DebitsDAO();
        this.debitList = db.buscaPorTodos();
    }

    public void salvar(String dat_compra, String dat_vencimento,String dat_pagamento,Double valor, Double valor_pago, Boolean pago, String descricao, String observacao, int fornecedores_id) throws DBException, Exception {
       
        Debits d;

        if (this.debits != null) {

            d = this.debits;
            
            Calendar calend = Calendar.getInstance();
            Date date = new Date(dat_compra);
            calend.setTime(date);
            d.setBuy_date(calend);
            date = new Date(dat_vencimento);
            calend.setTime(date);
            d.setDue_date(calend);
            date = new Date(dat_pagamento);
            calend.setTime(date);
            d.setPayment_date(calend);
            
            
            d.setValue(valor);
            d.setValue_paid(valor_pago);
            d.setPaid_out(pago);
            d.setDescription(descricao);
            d.setNote(observacao);
            d.setFornecedores_id(fornecedores_id);
         

            

            this.debitList.set(indice, d);

            this.db.atualizar(d);

            this.indice = 0;
            this.debits = null;

        }
    }

    public void cadastrar(String dat_compra, String dat_vencimento,String dat_pagamento,Double valor, Double valor_pago, Boolean pago, String descricao, String observacao, int fornecedores_id) throws DBException, Exception {

        Debits d = new Debits();       
            Calendar calend = Calendar.getInstance();
            Date date = new Date(dat_compra);
            calend.setTime(date);
            d.setBuy_date(calend);
            date = new Date(dat_vencimento);
            calend.setTime(date);
            d.setDue_date(calend);
            date = new Date(dat_pagamento);
            calend.setTime(date);
            d.setPayment_date(calend);
            
            d.setValue(valor);
            d.setValue_paid(valor_pago);
            d.setPaid_out(pago);
            d.setDescription(descricao);
            d.setNote(observacao);
            d.setFornecedores_id(fornecedores_id);

        this.db.inserir(d);

        this.debitList.add(d);

    }

    public void excluir(int indice) throws DBException {

        this.db.excluir(indice);
    }
    
    public void buscarTodos() throws DBException {

        DebitsDAO d = new DebitsDAO();
        
        this.debitList = d.buscaPorTodos();
        
        d = null;
        
    }
    
    public ArrayList<Debits> getDebitList(){
        return this.debitList;
    }
 }



