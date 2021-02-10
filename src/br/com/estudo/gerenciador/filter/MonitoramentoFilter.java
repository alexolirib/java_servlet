package br.com.estudo.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/entrada")
public class MonitoramentoFilter implements Filter{
	//filtrar tempo de execução
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		//executa a ação
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução - "+ (depois - antes)+ ", ação - "+acao);
		// TODO Auto-generated method stub
		
	}

}
