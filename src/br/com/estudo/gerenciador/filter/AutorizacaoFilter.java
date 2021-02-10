package br.com.estudo.gerenciador.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter(filterName = "entrada", urlPatterns = { "/entrada" })
public class AutorizacaoFilter implements Filter {
	
	
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado")== null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(ehUmaAcaoProtegida && usuarioNaoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
