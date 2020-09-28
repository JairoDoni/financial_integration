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
import model.Provider;


/**
 *
 * @author Gui
 */
public class ProviderDAO implements IDAO {

    @Override
    public void inserir(Object objeto) {
        Provider p = (Provider) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("INSERT INTO fornecedores(razao_social, nome_fantasia, cnpj, telefone, email) VALUE(?, ?, ?, ?, ?)");
            ps.setString(1, p.getCompany_name());
            ps.setString(2, p.getTrade_name());
            ps.setString(3, p.getCnpj());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getEmail());

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
         Provider p = (Provider) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("UPDATE fornecedores SET razao_social = ?, nome_fantasia = ?, cnpj = ?, telefone = ?, email = ? WHERE id = ?");
            ps.setString(1, p.getCompany_name());
            ps.setString(2, p.getTrade_name());
            ps.setString(3, p.getCnpj());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getEmail());
            ps.setInt(6, p.getId());
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
    public Provider buscaPorId(int id) {
        
        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Provider p = null;

        try {

            ps = con.prepareStatement("SELECT * FROM fornecedores WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            p.setCompany_name(rs.getString("razao_social"));
            p.setTrade_name(rs.getString("nome_fantasia"));
            p.setCnpj(rs.getString("cnpj"));
            p.setPhone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));
           

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
        return p;
    }

    
    @Override
    public void excluir(int id) {
        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("DELETE FROM fornecedores WHERE id = ?");
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

    @Override
    public ArrayList<Provider> buscaPorTodos() {
         Connection con = Conection.getConexao();
        Statement ps = null;
        ResultSet rs = null;
        Provider p = null;
        ArrayList<Provider> list = new ArrayList<Provider>();

        try {

            ps = con.createStatement();

            rs = ps.executeQuery("SELECT * FROM fornecedores");

            while( rs.next()) {

            p.setCompany_name(rs.getString("razao_social"));
            p.setTrade_name(rs.getString("nome_fantasia"));
            p.setCnpj(rs.getString("cnpj"));
            p.setPhone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));

            list.add(p);
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
    
}
