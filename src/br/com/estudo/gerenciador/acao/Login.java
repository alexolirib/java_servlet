package br.com.estudo.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.model.Banco;
import br.com.estudo.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		if (usuario != null){
			return "redirect:entrada?acao=ListaEmpresas";
		}
		return "redirect:entrada?acao=LoginForm";
		
		
	}

}
