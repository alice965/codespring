package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoTest {

	@Inject 
	private MemberDAO  dao;
	
	
	@Test
	public void test1()throws Exception{
		System.out.println("dao::" +dao);
	}
	
	@Test
	public void test2()throws Exception{
		System.out.println("dao Time::" +dao.getTime());
	}
	
	@Test
	public void testInsertMember()throws Exception{
		
		for(int i=0; i<=100; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("userid_" + i);
			vo.setUserpw("userpw_" + i);
			vo.setUsername("name_"+ i);
			vo.setEmail("user"+i+"@aaa.com");
			
			dao.insertMember(vo);
		}
		
		
	}	
}