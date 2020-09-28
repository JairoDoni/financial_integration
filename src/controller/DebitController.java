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
    private Provider provider = null;
    private ArrayList<Debits> listaCompras;
    private ArrayList<Provider> listaFornecedores;
    private int indice = 0;

    public DebitController() throws DBException {
        this.db = new DebitsDAO();
        this.listaCompras = db.buscaTodos();
    }

    public void salvar(String dat_compra, String nota_fiscal, Double valor_total, int indiceFornecedor) throws BancoDeDadosException {

        Debits d;

        if (this.debits != null) {

            d = this.debits;

            Calendar ultimaCompra = Calendar.getInstance();
            //Date d = new Date(dat_compra);
            ultimaCompra.setTime(d);

            d.setDat_compra(ultimaCompra);

            d.setNota_fiscal(nota_fiscal);
            d.setValor_total(valor_total);

            buscarTodoOsFornecedores();
            Fornecedor f = this.listaFornecedores.get(indiceFornecedor);
            c.setFornecedor(f);

            this.listaCompras.set(indice, c);

            this.db.atualizar(c);

            this.indice = 0;
            this.compra = null;

        }
    }

    public void cadastrar(String payment_date, String nota_fiscal, Double valor_total, int indiceFornecedor) throws BancoDeDadosException {

        Debits d = new Debits();

        d.setPayment_date(nota_fiscal);
        d.setValue(valor_total);

        Provider f = this.listaFornecedores.get(indiceFornecedor);
        d.setProvider(f);

        Calendar dataCompra = Calendar.getInstance();
        Date d = new Date(data_compra);
        dataCompra.setTime(d);

        c.setDat_compra(dataCompra);

        this.db.inserir(c);

        this.listaCompras.add(c);

    }

    public int excluir(int indice) throws DBException {

        int reg = this.db.excluir(indice);

        return reg;

    }

    public Compra getCompras() {
        return this.compra;
    }

    public void buscarTodoOsFornecedores() throws DBException {
        fornecedorDAO fdao = new fornecedorDAO();
        this.listaFornecedores = fdao.buscaTodos();
        fdao = null;
    }

    public ArrayList<Pro> getListaFornecedoresCadastrados() {
        return this.listaFornecedores;
    }

    public ArrayList<Compra> getListaCompras() {
        return this.listaCompras;
    }

    public void setCompraSelecionado(int indice) throws BancoDeDadosException {
        this.indice = indice;
        this.compra = this.listaCompras.get(indice);
    }

}



