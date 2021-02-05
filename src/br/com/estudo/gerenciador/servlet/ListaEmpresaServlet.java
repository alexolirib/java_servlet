package br.com.estudo.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.base.Banco;
import br.com.estudo.gerenciador.domain.Empresa;


@WebServlet(name = "listaEmpresas", urlPatterns = { "/listaEmpresas" })
public class ListaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresa = banco.getEmpresas();
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<ul>");
		for(Empresa empresa: listaEmpresa) {
			out.println("<li>"+"ID - "+empresa.getId()+", Empresa - "+empresa.getNome()+"</li>");
		}
		out.print("</ul>");
		out.print("</body></html>");
	}

}
