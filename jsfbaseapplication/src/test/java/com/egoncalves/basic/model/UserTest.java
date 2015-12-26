package com.egoncalves.basic.model;

import org.junit.Assert;
import org.junit.Test;

import com.egoncalves.baseapplication.model.User;

public class UserTest {
	
	@Test
	public void criarEntidadeTest(){
		User baseEntity = new User();
		baseEntity.setId(new Long(1));
		baseEntity.setNome("Fulano de Tal");
		
		Assert.assertEquals("Fulano de Tal", baseEntity.getNome());
	}

}
