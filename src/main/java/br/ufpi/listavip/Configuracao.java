package br.ufpi.listavip;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Classe que faz a configuração padrão do Spring Boot
 * @author armandosoaressousa
 *
 */
@SpringBootApplication
public class Configuracao {
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	/**
	 * Bean que faz a configuração de acesso a dados
	 * @return DataSource configurado para acessar os dados
	 */
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	    return dataSource;
	}
}
