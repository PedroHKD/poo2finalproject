/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.poo2finalproject.dao;

import com.myproject.poo2finalproject.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Devoi
 */
public class ClienteDAO {
    
    private Connection connection;
    
    public ClienteDAO(){
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/poo2finalproject";
            String usuario = "root";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, endereco, sexo, data_nas, saldo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getSexo());
            stmt.setDate(4, new java.sql.Date(cliente.getData_nas().getTime()));
            stmt.setDouble(5, cliente.getSaldo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Cliente cliente, Integer codCliente) {
        String sql = "UPDATE cliente SET nome=?, endereco=?, sexo=?, data_nas=?, saldo=? WHERE cod_cliente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getSexo());
            stmt.setDate(4, new java.sql.Date(cliente.getData_nas().getTime()));
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, codCliente);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public Cliente buscarPorId(Integer cod_cliente) {
        String sql = "Select * from cliente";
        List<Cliente> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, cod_cliente);
            ResultSet user = stmt.executeQuery();
            while(user.next()){
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(user.getInt("cod_cliente"));
                cliente.setData_nas(user.getDate("data_nas"));
                cliente.setEndereco(user.getString("endereco"));
                cliente.setNome(user.getString("nome"));
                cliente.setSaldo(user.getDouble("saldo"));
                cliente.setSexo(user.getString("sexo"));
                retorno.add(cliente);
            }
            List<Cliente> usuario = retorno.stream().filter(cli -> cli.getCod_cliente() == cod_cliente).collect(Collectors.toList());
            return usuario.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    public ArrayList<Cliente> ListarTodos() {
        String sql = "Select * from cliente";
        ArrayList<Cliente> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet user = stmt.executeQuery();
            while(user.next()){
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(user.getInt("cod_cliente"));
                cliente.setData_nas(user.getDate("data_nas"));
                cliente.setEndereco(user.getString("endereco"));
                cliente.setNome(user.getString("nome"));
                cliente.setSaldo(user.getDouble("saldo"));
                cliente.setSexo(user.getString("sexo"));
                retorno.add(cliente);
            }
            
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        

    public boolean remover(Integer cod_cliente) {
        String sql = "DELETE FROM cliente WHERE cod_cliente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cod_cliente);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}