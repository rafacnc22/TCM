/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class Relatar_Problema {
    private String onde_ocorreu;
    private LocalDate Data_que_ocorreu;
    private String como_ocorreu;
    private String tipo;
    private int id;
    private String email;

    /**
     * @return the onde_ocorreu
     */
    public String getOnde_ocorreu() {
        return onde_ocorreu;
    }

    /**
     * @param onde_ocorreu the onde_ocorreu to set
     */
    public void setOnde_ocorreu(String onde_ocorreu) {
        this.onde_ocorreu = onde_ocorreu;
    }

    /**
     * @return the Data_que_ocorreu
     */
    public LocalDate getData_que_ocorreu() {
        return Data_que_ocorreu;
    }

   
    public void setData_que_ocorreu(LocalDate Data_que_ocorreu) {
        this.Data_que_ocorreu = Data_que_ocorreu;
    }

    /**
     * @return the como_ocorreu
     */
    public String getComo_ocorreu() {
        return como_ocorreu;
    }

    /**
     * @param como_ocorreu the como_ocorreu to set
     */
    public void setComo_ocorreu(String como_ocorreu) {
        this.como_ocorreu = como_ocorreu;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

   
}
