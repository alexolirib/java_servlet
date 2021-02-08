package br.com.estudo.gerenciador.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	//mock
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		Empresa empresa3 = new Empresa();
		empresa3.setNome("Google");
		
		Banco banco = new Banco();
		banco.adicionaListaEmpresa(Arrays.asList(empresa,empresa2,empresa3));
	}
	
	public static List<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void adicionaListaEmpresa(List<Empresa> empresas) {
		for (Empresa empresa : empresas) {
			adiciona(empresa);			
		}
	}


	public void adiciona(Empresa empresa) {
		if (empresas.isEmpty()) {
			empresa.setId(1);
		} else {
			empresa.setId(empresas.get(empresas.size()-1).getId()+1);
		}
		empresas.add(empresa);
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	

}
