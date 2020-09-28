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
import model.Client;

/**
 *
 * @author Gui
 */
public class ClientDAO implements IDAO {

    @Override
    public void inserir(Object objeto) {
        Client c = (Client) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("INSERT INTO clientes(nome, dat_nascimento, cpf, rg, telefone, endereco, cep, numero, bairro, cidade, uf) VALUE(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)");
            ps.setString(1, c.getName());
            ps.setDate(2, new java.sql.Date( c.getBirth_date().getTime().getTime() ));
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getRg());
            ps.setString(5, c.getPhone());
            ps.setString(6, c.getAddress());
            ps.setString(7, c.getCep());
            ps.setString(8, c.getAddress_number());
            ps.setString(9, c.getAddress_neighborhood());
            ps.setString(10, c.getAddress_city());
            ps.setString(11, c.getAddress_state());

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

        Client c = (Client) objeto;

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement("UPDATE clientes SET nome = ?, dat_nascimento = ?, cpf = ?, rg = ?, telefone = ?, endereco = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, uf = ? WHERE id = ?");
            ps.setString(1, c.getName());
            ps.setString(2, c.getBirth_date().toString());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getRg());
            ps.setString(5, c.getPhone());
            ps.setString(6, c.getAddress());
            ps.setString(7, c.getCep());
            ps.setString(8, c.getAddress_number());
            ps.setString(9, c.getAddress_neighborhood());
            ps.setString(10, c.getAddress_city());
            ps.setString(11, c.getAddress_state());
            ps.setInt(12, c.getId());

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
    public Client buscaPorId(int id) {

        Connection con = Conection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client c = null;

        try {

            ps = con.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            c.setName(rs.getString("nome"));
            //c.setBirth_date(rs.getString("dat_nascimento"));
            c.setCpf(rs.getString("cpf"));
            c.setRg(rs.getString("rg"));
            c.setPhone(rs.getString("telefone"));
            c.setAddress(rs.getString("endereco"));
            c.setCep(rs.getString("cep"));
            c.setAddress_number(rs.getString("numero"));
            c.setAddress_neighborhood(rs.getString("bairro"));
            c.setAddress_city(rs.getString("cidade"));
            c.setAddress_state(rs.getString("uf"));

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
    public ArrayList<Client> buscaPorTodos() {

        Connection con = Conection.getConexao();
        Statement ps = null;
        ResultSet rs = null;
        Client c = null;
        ArrayList<Client> list = new ArrayList<Client>();

        try {

            ps = con.createStatement();

            rs = ps.executeQuery("SELECT * FROM clientes");

            while( rs.next()) {

            c.setName(rs.getString("nome"));
            //c.setBirth_date(rs.getString("dat_nascimento"));
            c.setCpf(rs.getString("cpf"));
            c.setRg(rs.getString("rg"));
            c.setPhone(rs.getString("telefone"));
            c.setAddress(rs.getString("endereco"));
            c.setCep(rs.getString("cep"));
            c.setAddress_number(rs.getString("numero"));
            c.setAddress_neighborhood(rs.getString("bairro"));
            c.setAddress_city(rs.getString("cidade"));
            c.setAddress_state(rs.getString("uf"));

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

            ps = con.prepareStatement("DELETE FROM clientes WHERE id = ?");
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
