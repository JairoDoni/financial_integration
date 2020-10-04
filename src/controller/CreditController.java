/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CreditDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Client;
import model.Credit;

/**
 *
 * @author jairo
 */
public class CreditController {
    
    private CreditDAO db;
    private Credit credit;
    private ArrayList<Credit> listaCred;
    private int ind = 0;
    
    
    public CreditController(){
        this.db = new CreditDAO();
        this.listaCred = db.buscaPorTodos();
        
    }
    
    public void salvar(String dat_venda, String dat_vencimento, String dat_pagamento, Double valor, Double valor_pago, Boolean pago, String descricao, String observacao, Integer clientes_id) throws Exception{
       
        Credit c;
        
        if(this.credit != null){
            
            c = this.credit;
            
            Calendar calend = Calendar.getInstance();
            Date d = new Date(dat_venda);
            calend.setTime(d);
            c.setSale_date(calend);
            d = new Date(dat_vencimento);
            calend.setTime(d);
            c.setDue_date(calend);
            d = new Date(dat_pagamento);
            calend.setTime(d);
            c.setPayment_date(calend);
            
            c.setValue(valor);
            c.setValue_paid(valor_pago);
            c.setPaid_out(pago);
            c.setDescription(descricao);
            c.setNote(observacao);
            c.setClient_id(clientes_id);
            
            this.listaCred.set(ind, c);

            this.db.atualizar(c);

            this.ind = 0;
            this.credit = null;
        }
    }
    
    public void cadastrar(String dat_venda, String dat_vencimento, String dat_pagamento, Double valor, Double valor_pago, Boolean pago, String descricao, String observacao, Integer clientes_id) throws Exception{
        Credit c = new Credit();
        
        Calendar calend = Calendar.getInstance();
            Date d = new Date(dat_venda);
            calend.setTime(d);
            c.setSale_date(calend);
            d = new Date(dat_vencimento);
            calend.setTime(d);
            c.setDue_date(calend);
            d = new Date(dat_pagamento);
            calend.setTime(d);
            c.setPayment_date(calend);
            
            c.setValue(valor);
            c.setValue_paid(valor_pago);
            c.setPaid_out(pago);
            c.setDescription(descricao);
            c.setNote(observacao);
            c.setClient_id(clientes_id);
            
            this.db.inserir(c);
            this.listaCred.add(c);
            
    }
    public void Excluir(int indice){
        this.db.excluir(indice);
 
    }
    public void buscarTodos(){
        CreditDAO cdao = new CreditDAO();
        
        this.listaCred = cdao.buscaPorTodos();
        cdao = null;
    }
      
    public ArrayList<Credit> getCreditList(){
        return this.listaCred;
    }
}
