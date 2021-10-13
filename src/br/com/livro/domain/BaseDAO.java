package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public BaseDAO() {
		try {
			// Necessário para utilizar o driver JDBC do MySQL
			// Class.forName("com.mysql.jdbc.Driver"); 5.*

			Class.forName("com.mysql.cj.jdbc.Driver"); // 8.*
		} catch (ClassNotFoundException e) {
			// Erro de driver JDBC (adicione o driver .jar do MySQL em
			// /WEB-INF/lib)
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		// URL de conexao com o banco de dados
		String url = "jdbc:mysql://localhost:3306/cadastro";
		
		//conect utilizando a URL, usuario e senha
		Connection conn = DriverManager.getConnection(url, "cadastro", "282308Theo");
				
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		// Testa a conexão
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
