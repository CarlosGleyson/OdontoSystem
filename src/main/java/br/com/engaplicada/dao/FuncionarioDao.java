package br.com.engaplicada.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.engaplicada.entity.Funcionario;

public class FuncionarioDao extends OdontosystemGenericDaoImpl<Funcionario>{

	public FuncionarioDao(){
		super(Funcionario.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() {
		Query q = entityManager.createQuery("select f from Funcionario f order by f.nome");
		List<Funcionario> lista = (List<Funcionario>) q.getResultList();
		return lista;
	}

	@Override
	public Funcionario findByName(String name) {
		Query q = entityManager.createQuery("select f from Funcionario f where f.nome = nome");
		q.setParameter("nome", name+"%");
		Funcionario funcionario = (Funcionario)q.getSingleResult();
		return funcionario;
	}

	public Funcionario findByAdress(String adress) {
		Query q = entityManager.createQuery("select f from Funcionario f where f.endereco = endereco");
		q.setParameter("endereco",adress+"%");
		return (Funcionario) q.getSingleResult();
	}

}
