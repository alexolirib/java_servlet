package br.com.estudo.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.acao.Acao;


@WebServlet(name = "entrada", urlPatterns = { "/entrada" })
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//entrada?acao=<nomeAcao>
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		String paramAcao = request.getParameter("acao");
		//padrão de projeto command
		String nomeClasse = "br.com.estudo.gerenciador.acao."+ paramAcao; 
		
		String nome = null;
		try {
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executa(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		
		String [] tipoOperacao = nome.split(":");
		if (tipoOperacao[0].contains("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoOperacao[1]);
			rd.forward(request, response);
		} 
		if (tipoOperacao[0].contains("redirect")){
			response.sendRedirect(tipoOperacao[1]);
		}
		
//
//		if (paramAcao.equals("ListaEmpresa")) {
//			ListaEmpresas listaEmpresa = new ListaEmpresas();
//			nome = listaEmpresa.executa(request, response);
//		}
//
//
//		if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa re = new RemoveEmpresa();
//			nome = re.executa(request, response);
//		}
//
//		if (paramAcao.equals("EditEmpresa")) {
//			EditEmpresa ee = new EditEmpresa();
//			nome = ee.executa(request, response);
//		}
//
//		if (paramAcao.equals("EditEmpresaAlterar")) {
//			EditEmpresaAlterar eea = new EditEmpresaAlterar();
//			nome = eea.executa(request, response);
//		}
//
//		if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa ne = new NovaEmpresa();
//			nome = ne.executa(request, response);
//		}
//
//		if (paramAcao.equals("FormNovaEmpresa")) {
//			FormNovaEmpresa fne = new FormNovaEmpresa();
//			nome = fne.executa(request, response);
//		}
//		
//		String [] tipoOperacao = nome.split(":");
//		if (tipoOperacao[0].contains("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoOperacao[1]);
//			rd.forward(request, response);
//		} 
//		if (tipoOperacao[0].contains("redirect")){
//			response.sendRedirect(tipoOperacao[1]);
//		}
	}

}
