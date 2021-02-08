package br.com.estudo.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.acao.ListaEmpresas;
import br.com.estudo.gerenciador.acao.NovaEmpresa;
import br.com.estudo.gerenciador.acao.EditEmpresa;
import br.com.estudo.gerenciador.acao.EditEmpresaAlterar;
import br.com.estudo.gerenciador.acao.FormNovaEmpresa;
import br.com.estudo.gerenciador.acao.RemoveEmpresa;


@WebServlet(name = "entrada", urlPatterns = { "/entrada" })
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//entrada?acao=<nomeAcao>
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresa")) {
			ListaEmpresas listaEmpresa = new ListaEmpresas();
			listaEmpresa.executa(request, response);
		}


		if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa re = new RemoveEmpresa();
			re.executa(request, response);
		}

		if (paramAcao.equals("EditEmpresa")) {
			EditEmpresa ee = new EditEmpresa();
			ee.executa(request, response);
		}

		if (paramAcao.equals("EditEmpresaAlterar")) {
			EditEmpresaAlterar eea = new EditEmpresaAlterar();
			eea.executa(request, response);
		}

		if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa ne = new NovaEmpresa();
			ne.executa(request, response);
		}

		if (paramAcao.equals("FormNovaEmpresa")) {
			FormNovaEmpresa fne = new FormNovaEmpresa();
			fne.executa(request, response);
		}
		
	}

}
