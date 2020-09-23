package member.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:config/datasource-context.xml"})
public class MemberServiceClient {

	@Autowired MemberService service;
	
	@Test
	//@Ignore
	public void selectOneTest() {
		MemberVo memberVo = MemberVo.builder().id("ken12md").build();
		memberVo =service.selectOne(memberVo);
		//assertEquals("ken21md", memberVo.getId());
		assertNull(memberVo.getId());
	}
}
