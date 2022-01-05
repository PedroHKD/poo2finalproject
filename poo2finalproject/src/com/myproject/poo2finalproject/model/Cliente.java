/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.poo2finalproject.model;

import java.util.Date;

/**
 *
 * @author Devoi
 */
public class Cliente {
    private Integer cod_cliente;
    private String nome;
    private String endereco;
    private String sexo;
    private Date data_nas;
    private double saldo;

    public Cliente() {
    }
    
    public Cliente(String nome, String endereco, String sexo, Date data_nas, double saldo) {
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.data_nas = data_nas;
        this.saldo = saldo;
    }
    
    public Cliente(Integer cod_cliente, String nome, String endereco, String sexo, Date data_nas, double saldo) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.data_nas = data_nas;
        this.saldo = saldo;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_nas() {
        return data_nas;
    }

    public void setData_nas(Date data_nas) {
        this.data_nas = data_nas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
