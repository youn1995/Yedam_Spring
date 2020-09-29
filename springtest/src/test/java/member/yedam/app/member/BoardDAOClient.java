package member.yedam.app.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.BoardVo;
import com.yedam.app.board.mapper.BoardDAO;
import com.yedam.app.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml"})
public class BoardDAOClient {
	
	@Autowired BoardDAO boardDAO;
//	@Autowired BoardService service
	
	@Test
	//@Ignore
	public void selectAllTest() {
		BoardVo bVo = BoardVo.builder().first(5).last(10).build();

		List<BoardVo> list = boardDAO.selectAll(bVo);
		for(BoardVo vo : list) {
			System.out.println(vo.getBoardNo()+" : "+vo.getPoster()+" : "+vo.getSubject());
		}
		
	}
	
	@Test
	@Ignore
	public void selectMapTest() {
		System.out.println(boardDAO.selectMap());
	}
	
	@Test
	@Ignore
	public void insert() {
		BoardVo bVo = BoardVo.builder().poster("김fff장난").
		subject("fffff").filename("dfdfff").boardContents("ffsdf").build();
		boardDAO.insert(bVo);
	}
	
	@Test
	@Ignore
	public void deleteAllTest() {
		List<String> list = Arrays.asList(new String[] {"2","3","4"});
		BoardVo vo = BoardVo.builder().nos(list).build();
		boardDAO.delete(vo);
			
	}
	@Test
	@Ignore
	public void selectCntTest() {
		System.out.println(boardDAO.selectCnt());
	}
	
}
