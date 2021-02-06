package br.com.estudo.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.base.Banco;
import br.com.estudo.gerenciador.domain.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//sobrescrever método doPost do HttpServlet (requisições POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		
		//simular banco
		Banco banco = new Banco();	
		banco.adiciona(empresa);
		
		empresa.setNome(nomeEmpresa);
//		Antes do JSP
//		PrintWriter out = response.getWriter();
//		out.println("Empresa "+nomeEmpresa+" cadastrada com sucesso!");
		
		//Chamas JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		//Executa
		rd.forward(request, response);
		
	}

}
