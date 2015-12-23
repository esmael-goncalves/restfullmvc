package com.egoncalves.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CriaBancoDados {

	public static void main(String[] args) {
		//Persistence.createEntityManagerFactory("jsfbaseapplication");
		criarLancamentos();
	}

	private static void criarLancamentos() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		trx.commit();
		manager.close();

	}

}
