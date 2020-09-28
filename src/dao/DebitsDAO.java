/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debits;

/**
 *
 * @author Gui
 */
public class DebitsDAO implements IDAO{

    @Override
    public void inserir(Object objeto) {
        Debits d = (Debits) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("INSERT INTO debitos(dat_compra, dat_vencimento, dat_pagamento, valor, valor_pago, pago, descricao, observacao, fornecedores_id) VALUE(? ,? ,? ,? ,? ,? ,? ,? ,?)");
            ps.setDate(1, new java.sql.Date( d.getBuy_date().getTime().getTime() ));
            ps.setDate(2, new java.sql.Date( d.getDue_date().getTime().getTime() ));
            ps.setDate(3, new java.sql.Date( d.getPayment_date().getTime().getTime() ));
            ps.setDouble(4, d.getValue());
            ps.setDouble(5, d.getValue_paid());
            ps.setBoolean(6, d.isPaid_out());
            ps.setString(7, d.getDescription());
            ps.setString(8, d.getNote());
            ps.setInt(9, d.getProvider_id());
           

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void atualizar(Object objeto) {
           Debits d = (Debits) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("UPDATE debitos SET dat_compra = ?, dat_vencimento = ?, dat_pagamento = ?, valor = ?, valor_pago = ?, pago = ?, descricao = ?, observacao = ?, fornecedores_id = ? WHERE id = ?");
            ps.setDate(1, new java.sql.Date( d.getBuy_date().getTime().getTime() ));
            ps.setDate(2, new java.sql.Date( d.getDue_date().getTime().getTime() ));
            ps.setDate(3, new java.sql.Date( d.getPayment_date().getTime().getTime() ));
            ps.setDouble(4, d.getValue());
            ps.setDouble(5, d.getValue_paid());
            ps.setBoolean(6, d.isPaid_out());
            ps.setString(7, d.getDescription());
            ps.setString(8, d.getNote());
            ps.setInt(9, d.getProvider_id());
           

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Object buscaPorId(int id) {
         Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Debits d = null;

        try {

            ps = con.prepareStatement("SELECT * FROM debitos WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            //c.setDate(new java.sql.Date(c.getSale_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getDue_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getPayment_date().getTime().getTime()));
            d.setValue(rs.getDouble("valor"));
            d.setValue_paid(rs.getDouble("valor_pago"));
            d.setPaid_out(rs.getBoolean("pago"));
            d.setDescription(rs.getString("descricao"));
            d.setNote(rs.getString("observacao"));
            d.setProvider_id(rs.getInt("fornecedores_id"));
            

        } catch (Exception ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return d;
    }

    @Override
    public ArrayList buscaPorTodos() {
         Connection con = Conection.getConexao();
        Statement ps = null;
        ResultSet rs = null;
        Debits d = null;
        ArrayList<Debits> list = new ArrayList<Debits>();

        try {

            ps = con.createStatement();

            rs = ps.executeQuery("SELECT * FROM debitos");

            while( rs.next()) {

            //c.setDate(new java.sql.Date(c.getSale_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getDue_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getPayment_date().getTime().getTime()));
            d.setValue(rs.getDouble("valor"));
            d.setValue_paid(rs.getDouble("valor_pago"));
            d.setPaid_out(rs.getBoolean("pago"));
            d.setDescription(rs.getString("descricao"));
            d.setNote(rs.getString("observacao"));
            d.setProvider_id(rs.getInt("fornecedores_id"));

            list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void excluir(int id) {
        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("DELETE FROM debitos WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    

