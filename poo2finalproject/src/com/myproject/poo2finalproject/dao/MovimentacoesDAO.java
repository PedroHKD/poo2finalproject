/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.poo2finalproject.dao;

import com.myproject.poo2finalproject.model.Cliente;
import com.myproject.poo2finalproject.model.OperacoesENUM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

/**
 *
 * @author Devoi
 */
public class MovimentacoesDAO {
    
    private Connection connection;
    
    public MovimentacoesDAO(){
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/poo2finalproject";
            String usuario = "root";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MovimentacoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean deposito(Cliente cliente, Integer valor) {
        String sql = "UPDATE cliente SET saldo=? WHERE cod_cliente=?";
        String sqlTransferencia = "INSERT INTO movimentacoes(cod_cliente, cod_cliente_favorecido, cod_operacao, valor, data_hora_movimento) VALUES(?,?,?,?,?)";
//        String sqlsdasdas = "INSERT INTO cliente(nome, endereco, sexo, data_nas, saldo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, cliente.getSaldo());
            stmt.setInt(2, cliente.getCod_cliente());
            stmt.execute();
            
            PreparedStatement stmtTrans = connection.prepareStatement(sqlTransferencia);
            stmtTrans.setInt(1, cliente.getCod_cliente());
            stmtTrans.setInt(2, cliente.getCod_cliente());
            stmtTrans.setInt(3, 1);
            stmtTrans.setDouble(4, valor);
            stmtTrans.setTimestamp(5,  Timestamp.from(Instant.now()));
            stmtTrans.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public boolean saque(Cliente cliente, Integer valor) {
        String sql = "UPDATE cliente SET saldo=? WHERE cod_cliente=?";
        String sqlTransferencia = "INSERT INTO movimentacoes(cod_cliente, cod_cliente_favorecido, cod_operacao, valor, data_hora_movimento) VALUES(?,?,?,?,?)";
//        String sqlsdasdas = "INSERT INTO cliente(nome, endereco, sexo, data_nas, saldo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, cliente.getSaldo());
            stmt.setInt(2, cliente.getCod_cliente());
            stmt.execute();
            
            PreparedStatement stmtTrans = connection.prepareStatement(sqlTransferencia);
            stmtTrans.setInt(1, cliente.getCod_cliente());
            stmtTrans.setInt(2, cliente.getCod_cliente());
            stmtTrans.setInt(3, 2);
            stmtTrans.setDouble(4, valor);
            stmtTrans.setTimestamp(5,  Timestamp.from(Instant.now()));
            stmtTrans.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
     public boolean transferencia(Cliente clienteEmissor, Cliente clienteFavorecido, Integer valor) {
        String sql = "UPDATE cliente SET saldo=? WHERE cod_cliente=?";
        String sqlTransferencia = "INSERT INTO movimentacoes(cod_cliente, cod_cliente_favorecido, cod_operacao, valor, data_hora_movimento) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, clienteEmissor.getSaldo());
            stmt.setInt(2, clienteEmissor.getCod_cliente());
            stmt.execute();
            
            PreparedStatement stmtTrans = connection.prepareStatement(sqlTransferencia);
            stmtTrans.setInt(1, clienteEmissor.getCod_cliente());
            stmtTrans.setInt(2, clienteFavorecido.getCod_cliente());
            stmtTrans.setInt(3, 3);
            stmtTrans.setDouble(4, valor);
            stmtTrans.setTimestamp(5,  Timestamp.from(Instant.now()));
            stmtTrans.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
     
}
