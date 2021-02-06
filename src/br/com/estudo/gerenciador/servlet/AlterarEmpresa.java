package br.com.estudo.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.base.Banco;
import br.com.estudo.gerenciador.domain.Empresa;

/**
 * Servlet implementation class AlterarEmpresa
 */
@WebServlet(name = "alterarEmpresa", urlPatterns = { "/alterarEmpresa" })
public class AlterarEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPorId(id);
		if (empresa == null) {
			response.sendRedirect("listaEmpresas");
		}
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");

		String nomeEmpresa = req.getParameter("nome");
		String dataEmpresa = req.getParameter("data");	
		String idEmpresa = req.getParameter("id");	
		Integer id = Integer.valueOf(idEmpresa);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		resp.sendRedirect("listaEmpresas");
	}
	
	

}
