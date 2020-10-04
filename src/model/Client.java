/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author Ro7Rinke
 */
public class Client {
    
    private int id;
    private String name;
    private Calendar birth_date;
    private String cpf;
    private String rg;
    private String phone;
    private String address;
    private String cep;
    private String address_number;
    private String address_neighborhood;
    private String address_city;
    private String address_state;
    
    public Client() {
        this.id = 0;
        this.name = "";
        this.birth_date = Calendar.getInstance();
        this.cpf = "";
        this.phone = "";
        this.address = "";
        this.cep = "";
        this.address_number = "";
        this.address_neighborhood = "";
        this.address_city = "";
        this.address_state = "";
    }

    public Client(int id, String name, Calendar birth_date, String cpf, String rg, String phone) throws Exception {
        if(name == null || "".equals(name) || birth_date == null || cpf == null || "".equals(cpf) || rg == null || "".equals(rg) || phone == null || "".equals(phone)){
            throw new Exception("Invalid arguments");
        }
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
    }

    public Client(int id, String name, Calendar birth_date, String cpf, String rg, String phone, String address, String cep, String address_number, String address_neighborhood, String address_city, String address_state) throws Exception {
        if(name == null || "".equals(name) || birth_date == null || cpf == null || "".equals(cpf) || rg == null || "".equals(rg) || phone == null || "".equals(phone)){
            throw new Exception("Invalid arguments");
        }
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.address = address;
        this.cep = cep;
        this.address_number = address_number;
        this.address_neighborhood = address_neighborhood;
        this.address_city = address_city;
        this.address_state = address_state;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        
        return name;
    }

    public void setName(String name) throws Exception {
        if(name == null || "".equals(name)){
            throw new Exception("Invalid arguments");
        }
        this.name = name;
    }

    public Calendar getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Calendar birth_date) throws Exception {
        if(birth_date == null){
            throw new Exception("Invalid arguments");
        }
        this.birth_date = birth_date;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if(cpf == null || "".equals(cpf)){
            throw new Exception("Invalid arguments");
        }
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) throws Exception {
        if(rg == null || "".equals(rg)){
            throw new Exception("Invalid arguments");
        }
        this.rg = rg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if(phone == null || "".equals(phone)){
            throw new Exception("Invalid arguments");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getAddress_neighborhood() {
        return address_neighborhood;
    }

    public void setAddress_neighborhood(String address_neighborhood) {
        this.address_neighborhood = address_neighborhood;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }
    
    
}
