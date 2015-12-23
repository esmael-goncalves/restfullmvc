package com.egoncalves.basic.model;

import org.junit.Assert;
import org.junit.Test;

public class BaseEntityTest {
	
	@Test
	public void criarEntidadeTest(){
		BaseEntity baseEntity = new BaseEntity();
		baseEntity.setEntityId(1);
		baseEntity.setNome("Fulano de Tal");
		
		Assert.assertEquals("Fulano de Tal", baseEntity.getNome());
	}

}
