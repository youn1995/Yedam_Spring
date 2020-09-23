package member.yedam.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.mapper.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:config/datasource-context.xml"}) //genericXmlAppliction과 동일
public class MemberDAOClient {
	@Autowired MemberDAO memberDAO;
	
	@Test
	@Ignore
	public void selectTest() {
		MemberVo memberVo = MemberVo.builder().id("ccc").build();	
		memberVo = memberDAO.selectOne(memberVo); //join pointcut
		assertEquals("111", memberVo.getPw());
	}
	
	@Test
	//@Ignore
	public void insertTest() {
		MemberVo memberVo = MemberVo.builder().id("ken211221md").pw("111").job("dba").gender("M").mailyn("Y").build();
		memberDAO.insert(memberVo);
		//memberVo = dao.selectOne(memberVo);
		//assertNotNull(memberVo);
		
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		MemberVo memberVo = MemberVo.builder().id("ccc").build();
		memberDAO.delete(memberVo);
		//memberVo = dao.selectOne(memberVo);
		//assertNotNull(memberVo);
		
	}
	@Test
	@Ignore
	public void selectOneTest() {
		MemberVo memberVo = MemberVo.builder().id("ken2md").build();
		memberDAO.selectOne(memberVo);
	}
	
	@Test
	@Ignore
	public void selectAllTest() {
		memberDAO.selectAll();
	}
	
	
}
