/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Credit;

/**
 *
 * @author Gui
 */
public class CreditDAO implements IDAO {

    @Override
    public void inserir(Object objeto) {

        Credit c = (Credit) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("INSERT INTO creditos(dat_venda, dat_vencimento,dat_pagamento, valor, valor_pago, pago, descricao, observacao, clientes_id) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setDate(1, new java.sql.Date(c.getSale_date().getTime().getTime()));
            ps.setDate(2, new java.sql.Date(c.getDue_date().getTime().getTime()));
            ps.setDate(3, new java.sql.Date(c.getPayment_date().getTime().getTime()));
            ps.setDouble(4, c.getValue());
            ps.setDouble(5, c.getValue_paid());
            ps.setBoolean(6, c.isPaid_out());
            ps.setString(7, c.getDescription());
            ps.setString(8, c.getNote());
            ps.setInt(9, c.getClient_id());

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
        Credit c = (Credit) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("UPDATE creditos SET dat_venda = ?, dat_vencimento = ?, dat_pagamento = ?, valor = ?, valor_pago = ?, pago = ?, descricao = ?, observacao = ?, clientes_id = ? WHERE id = ?");
            ps.setDate(1, new java.sql.Date(c.getSale_date().getTime().getTime()));
            ps.setDate(2, new java.sql.Date(c.getDue_date().getTime().getTime()));
            ps.setDate(3, new java.sql.Date(c.getPayment_date().getTime().getTime()));
            ps.setDouble(4, c.getValue());
            ps.setDouble(5, c.getValue_paid());
            ps.setBoolean(6, c.isPaid_out());
            ps.setString(7, c.getDescription());
            ps.setString(8, c.getNote());
            ps.setInt(9, c.getClient_id());
            ps.setInt(10, c.getId());

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
        Credit c = null;

        try {

            ps = con.prepareStatement("SELECT * FROM creditos WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            //c.setDate(new java.sql.Date(c.getSale_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getDue_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getPayment_date().getTime().getTime()));
            c.setValue(rs.getDouble("valor"));
            c.setValue_paid(rs.getDouble("valor_pago"));
            c.setPaid_out(rs.getBoolean("pago"));
            c.setDescription(rs.getString("descricao"));
            c.setNote(rs.getString("observacao"));
            c.setClient_id(rs.getInt("clientes_id"));
            

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
        return c;
    }

    @Override
    public ArrayList buscaPorTodos() {
       
        Connection con = Conection.getConexao();
        Statement ps = null;
        ResultSet rs = null;
        Credit c = null;
        ArrayList<Credit> list = new ArrayList<Credit>();

        try {

            ps = con.createStatement();

            rs = ps.executeQuery("SELECT * FROM creditos");

            while( rs.next()) {

            //c.setDate(new java.sql.Date(c.getSale_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getDue_date().getTime().getTime()));
            //c.setDate(new java.sql.Date(c.getPayment_date().getTime().getTime()));
            c.setValue(rs.getDouble("valor"));
            c.setValue_paid(rs.getDouble("valor_pago"));
            c.setPaid_out(rs.getBoolean("pago"));
            c.setDescription(rs.getString("descricao"));
            c.setNote(rs.getString("observacao"));
            c.setClient_id(rs.getInt("clientes_id"));

            list.add(c);
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

            ps = con.prepareStatement("DELETE FROM creditos WHERE id = ?");
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
