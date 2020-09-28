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
import model.Provider;


/**
 *
 * @author Gui
 */
public class ProviderDAO implements IDAO {

    @Override
    public void inserir(Object objeto) {
    }

    @Override
    public void atualizar(Object objeto) {
         
    }

    
    @Override
    public void excluir(int id) {
        
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
