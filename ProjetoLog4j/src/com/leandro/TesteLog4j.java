package com.leandro;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * H� 3 pontos principais na utiliza��o de Log4j
 * Appender (destino do log), Layout (como o layout � apresentado) e 
 * N�vel do log que ser� exibido 
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
 * N�vel: n�vel do log (DEBUG, INFO, WARN, ERROR, FATAL). 
 * 		  caso o n�vel esteja definido para WARN, info e debug nao sao exibidos
 * 		  ou seja, quando um n�vel � definido, abaixo dele n�o s�o relatados
 * 
 * Layout:
 * Define como ser� exibido o log
 * %C exibe o nome da classe 
 * %d exibe a data do evento de log. Aceita %d{padrao format date}
 * %l exibe o m�todo que chamou o evento de log 
 * %L exibe o n�mero da linha onde o evento de log foi requisitado 
 * %m exibe a mensagem 
 * %M o m�todo em que o evento de log foi requisitado 
 * %p exibe o n�vel do evento de log 
 * %r exibe o n�mero de milisegundos passados desde o in�cio do evento de log 
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
		
		// (1) Configura��o b�sica pode ser feita sem 
		// arquivo de configura��o:
		//
		// BasicConfigurator.configure();
		
		
		// (2) Nesta aplica��o est� setado no properties, por�m
		// poderia ser alterado via applica��o:
		// log.setLevel(Level.);
		
		
		// (3) N�o necessariamente precisa ter nome = log4j.properties
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
			log.fatal("Erro na opera��o");
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