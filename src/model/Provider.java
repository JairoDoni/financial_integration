/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Ro7Rinke
 */
public class Provider {
    
    private int id;
    private String company_name;
    private String trade_name;
    private String cnpj;
    private String phone;
    private String email;
    
    public Provider(int id, String company_name, String trade_name, String cnpj) throws Exception{
        if(company_name == null || "".equals(company_name) || trade_name == null || "".equals(trade_name) || cnpj == null || "".equals(cnpj) ){
            throw new Exception("Invalid arguments");
        }
            this.id = id;
            this.company_name = company_name;
            this.trade_name = trade_name;
            this.cnpj = cnpj;
    }
    
    public Provider(int id, String company_name, String trade_name, String cnpj, String phone, String email) throws Exception{
        if(company_name == null || "".equals(company_name) || trade_name == null || "".equals(trade_name) || cnpj == null || "".equals(cnpj) ){
            throw new Exception("Invalid arguments");
        }
        this.id = id;
        this.company_name = company_name;
        this.trade_name = trade_name;
        this.cnpj = cnpj;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) throws Exception {
        if(company_name == null || "".equals(company_name)){
            throw new Exception("Invalid arguments");
        }
        this.company_name = company_name;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) throws Exception {
        if(trade_name == null || "".equals(trade_name)){
            throw new Exception("Invalid arguments");
        }
        this.trade_name = trade_name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception {
        if(cnpj == null || "".equals(cnpj)){
            throw new Exception("Invalid arguments");
        }
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
