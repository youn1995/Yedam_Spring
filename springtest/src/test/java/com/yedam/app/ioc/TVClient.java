package com.yedam.app.ioc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml") //genericXmlAppliction과 동일
public class TVClient {
	
	@Autowired TV tv;
	
	@Test
	public void tvTEst() {
		assertNotNull(tv);
		tv.powerOn();
		tv.volumeUp();
	}
}
