package com.leandro;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Há 3 pontos principais na utilização de Log4j
 * Appender (destino do log), Layout (como o layout é apresentado) e 
 * Nível do log que será exibido 
 * 
 * Appender: Destino do log (arquivo, console, banco de dados, etc)
 * 			 Tipos de Appenders: 
 * 			 - ConsoleAppender: System.out ou System.err
 * 			 - DailyRollingFileAppender: Estende FileAppender sobrescrevendo o arquivo.
 * 			 - FileAppender: arquivo de log
 * 			 - RollingFileAppender: Estende FileAppender. Realiza backup dos arqs de log com certo tamanho
 * 			 - WriterAppender: Writer ou OutPutStream do usuario
 * 			 - SMTPAppender:  e-mail de log
 * 			 - SocketAppender: objetos de log para servidor remoto de log
 * 			 - SocketHubAppender: objetos de log para ajuste de servidores de log remotos
 * 			 - SyslogAppender: mensagens para um syslog daemon remoto
 * 			 - TelnetAppender: especializado em escrever sockets read-only 
 * 
 * Nível: nível do log (DEBUG, INFO, WARN, ERROR, FATAL). 
 * 		  caso o nível esteja definido para WARN, info e debug nao sao exibidos
 * 		  ou seja, quando um nível é definido, abaixo dele não são relatados
 * 
 * Layout:
 * Define como será exibido o log
 * %C exibe o nome da classe 
 * %d exibe a data do evento de log. Aceita %d{padrao format date}
 * %l exibe o método que chamou o evento de log 
 * %L exibe o número da linha onde o evento de log foi requisitado 
 * %m exibe a mensagem 
 * %M o método em que o evento de log foi requisitado 
 * %p exibe o nível do evento de log 
 * %r exibe o número de milisegundos passados desde o início do evento de log 
 * %t exibe o nome da thread que gerou o evento de log 
 * %n quebra de linha 
 * 
 * 
 * @author Leandro
 *
 */
public class TesteLog4j {

	Logger log = Logger.getLogger(TesteLog4j.class);
	
	public void configuracaoLog(){
		
		// (1) Configuração básica pode ser feita sem 
		// arquivo de configuração:
		//
		// BasicConfigurator.configure();
		
		
		// (2) Nesta aplicação está setado no properties, porém
		// poderia ser alterado via applicação:
		// log.setLevel(Level.);
		
		
		// (3) Não necessariamente precisa ter nome = log4j.properties
		// PropertyConfigurator.configure("log4j.properties");
		PropertyConfigurator.configure("meuLog4j.properties");
	}
	public void geracaoLog(){

		for (int i = 0; i < 10; i++){
			log.info("teste do Leandro " + i );
		}

		int b = 3;
		int c = 0;
		try {
			int a = b / c;
		}
		catch (Exception e){
			log.fatal("Erro na operação");
		}
	}
	public void geracaoLogBD(){
		/*
		 * Geracao do banco:
		 * CREATE TABLE LOGS(
		 * 	USER_ID VARCHAR(20) NOT NULL,
		 * 	DATA_LOG   timestamp NOT NULL,
		 *  CLASSE  VARCHAR(50) NOT NULL,
		 *  LEVEL   VARCHAR(10) NOT NULL,
		 *  MENSAGEM VARCHAR(1000) NOT NULL
		 * );
		 */
//		mysql> CREATE TABLE LOGS( USER_ID VARCHAR(20) NOT NULL, DATA_LOG   timestamp NOT
//				 NULL, CLASSE  VARCHAR(50) NOT NULL, LEVEL   VARCHAR(10) NOT NULL, MENSAGEM VARC
//				HAR(1000) NOT NULL);
		
	}
	
	public static void main(String[] args) {
		new TesteLog4j().configuracaoLog();
		new TesteLog4j().geracaoLog();
		System.out.println("Concluido! ");
	}
}