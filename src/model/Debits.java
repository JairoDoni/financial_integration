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
public class Debits {
    
    private int id;
    private Calendar buy_date;
    private Calendar due_date;
    private Calendar payment_date;
    private double value;
    private double value_paid;
    private boolean paid_out;
    private String description;
    private String note;
    private int provider_id;

    public Debits(){
        this.id = 0;
        this.buy_date = Calendar.getInstance();
        this.due_date = Calendar.getInstance();
        this.payment_date = Calendar.getInstance();
        this.value = 0;
        this.value_paid = 0;
        this.paid_out = false;
        this.description = "";
        this.note = "";
        this.provider_id = 0;
    }
    
    public Debits(int id, Calendar buy_date, Calendar due_date, double value, boolean paid_out, String description, int provider_id) throws Exception{
        if(buy_date == null || due_date == null || description == null || "".equals(description)){
            throw new Exception("Invalid arguments");
        }
        this.id = id;
        this.buy_date = buy_date;
        this.due_date = due_date;
        this.value = value;
        this.paid_out = paid_out;
        this.description = description;
        this.provider_id = provider_id;
    }

    
    
    public Debits(int id, Calendar buy_date, Calendar due_date, Calendar payment_date, double value, double value_paid, boolean paid_out, String description, String note, int provider_id) throws Exception {
        if(buy_date == null || due_date == null || description == null || "".equals(description)){
            throw new Exception("Invalid arguments");
        }
        this.id = id;
        this.buy_date = buy_date;
        this.due_date = due_date;
        this.payment_date = payment_date;
        this.value = value;
        this.value_paid = value_paid;
        this.paid_out = paid_out;
        this.description = description;
        this.note = note;
        this.provider_id = provider_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public Calendar getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Calendar buy_date) throws Exception {
        if(buy_date == null){
            throw new Exception("Invalid arguments");
        }
        this.buy_date = buy_date;
    }

    public Calendar getDue_date() {
        return due_date;
    }

    public void setDue_date(Calendar due_date) throws Exception {
         if(due_date == null){
            throw new Exception("Invalid arguments");
        }
        this.due_date = due_date;
    }

    public Calendar getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Calendar payment_date) {
        this.payment_date = payment_date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue_paid() {
        return value_paid;
    }

    public void setValue_paid(double value_paid) {
        this.value_paid = value_paid;
    }

    public boolean isPaid_out() {
        return paid_out;
    }

    public void setPaid_out(boolean paid_out) {
        this.paid_out = paid_out;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        if(description == null || "".equals(description)){
            throw new Exception("Invalid arguments");
        }
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }
    
    
}
