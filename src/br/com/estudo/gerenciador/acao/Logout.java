package br.com.estudo.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
//		session.removeAttribute("usuarioLogado");
		//remove todos os dados da sessão
		session.invalidate();
		return "redirect:entrada?acao=LoginForm";
	}

}
