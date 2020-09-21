package member.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.MemberDAO;
import com.yedam.app.member.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml") //genericXmlAppliction과 동일
public class MemberDAOClient {
	@Autowired MemberDAO dao;
	
	@Test
	//@Ignore
	public void selectTest() {
		MemberVo memberVo = MemberVo.builder().id("ccc").build();	
		memberVo = dao.selectOne(memberVo); //join pointcut
		assertEquals("111", memberVo.getPw());
	}
	
	@Test
	@Ignore
	public void insertTest() {
		MemberVo memberVo = MemberVo.builder().id("1c21dc3c").pw("111").job("dba").gender("M").mailyn("Y").build();
		dao.insert(memberVo);
		//memberVo = dao.selectOne(memberVo);
		//assertNotNull(memberVo);
		
	}
}
