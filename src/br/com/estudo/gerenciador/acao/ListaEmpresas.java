package br.com.estudo.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudo.gerenciador.model.Banco;
import br.com.estudo.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresa = banco.getEmpresas();
		
		request.setAttribute("empresas", listaEmpresa);
		
		return "forward:listaEmpresas.jsp";
	}
}
