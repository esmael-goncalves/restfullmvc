package com.egoncalves.basic.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.egoncalves.baseapplication.model.User;

public class UserTest {
	
	@Test
	public void entityXEqualsItSelfTest(){
		User baseEntity = new User();
		baseEntity.setId(new Long(1));
		baseEntity.setNome("Fulano de Tal");
		baseEntity.setCadastro(new Date());
		baseEntity.setAtivo(true);
		
		Assert.assertEquals(true, baseEntity.equals(baseEntity));
	}
	
	@Test
	public void entityXEqualsYTest(){
		User baseEntity = new User();
		baseEntity.setId(new Long(1));
		baseEntity.setNome("Fulano de Tal");
		baseEntity.setCadastro(new Date());
		baseEntity.setAtivo(true);

		User baseEntity2 = new User();
		baseEntity2.setId(new Long(1));
		baseEntity2.setNome("Fulano de Tal");
		baseEntity2.setCadastro(new Date());
		baseEntity2.setAtivo(true);
		
		Assert.assertEquals(true, baseEntity.equals(baseEntity2));
	}
	
	@Test
	public void entityXNotEqualsYTest(){
		User baseEntity = new User();
		baseEntity.setId(new Long(1));
		baseEntity.setNome("Fulano de Tal");
		baseEntity.setCadastro(new Date());
		baseEntity.setAtivo(true);

		User baseEntity2 = new User();
		baseEntity2.setId(new Long(1));
		baseEntity2.setNome("Fulano de Tal da Silva");
		baseEntity2.setCadastro(new Date());
		baseEntity2.setAtivo(false);
		
		Assert.assertEquals(false, baseEntity.equals(baseEntity2));
	}

}
