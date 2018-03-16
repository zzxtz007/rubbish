package com.keji.washer.service;

import com.keji.washer.model.po.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * test Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class testTest {

	private AbstractXmlApplicationContext context;
	private test t;
	private UserPo user;
	private WasherPo washer;
	private OrderPo order;
	private AppraisalPo appraisal;
	private RepairPo repair;
	@Before
	public void before() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
		t = (test) context.getBean("test");
		user = new UserPo();
		user.setInsertUser("1");
		user.setUpdateUser("1");
//		user.setId("u_2");
		user.setName("婦產科");
//		user.setPhone("13998441127");
		user.setSalt("111");
		user.setPwdHash("111");
		user.setIsDeleted(true);
		washer = new WasherPo();
		washer.setId(1);
		washer.setInsertUser("1");
		washer.setUpdateUser("1");
		washer.setStatus(2);
		washer.setStoriedId(2);
		order = new OrderPo();
		order.setId(2);
		order.setInsertUser("1");
		order.setUpdateUser("1");
		order.setModeId(1);
		order.setWasherId(1);
		order.setUserId("u_5");
		appraisal = new AppraisalPo();
		appraisal.setId(1);
		appraisal.setUserId("u_1");
		appraisal.setOrderId(2);
		appraisal.setMessage("垃圾洗衣机 都洗不干净！！！");
		appraisal.setInsertUser("11");
		appraisal.setUpdateUser("22");
		repair = new RepairPo();
		repair.setId(6);
//		repair.setUserId("u_1");
		repair.setWasherId(1);
		repair.setInsertUser("11");
		repair.setUpdateUser("22");
		repair.setMessage("坏了");
//		repair.setIsHandle(true);
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: list()
	 */
	@Test
	public void testList() throws Exception {
//TODO: Test goes here...
//		System.out.println(t.listStoried());
		//washer insert
//		System.out.println(t.insertWasher(washer));
//		t.updateWasher(washer);
//		System.out.println(t.listWasher(washer, 0, 99));
//		System.out.println(t.listOrder(order));
//		System.out.println(t.getOrder(order));
//		System.out.println(t.listAppraisal(appraisal,washer.getId()));
//		System.out.println(t.getAppraisal(appraisal));
//		System.out.println(t.insertRepair(repair));
//		System.out.println(t.updateRepair(repair));
		System.out.println(t.listRepair(repair));
	}

	/**
	 * Method: getOperator(OperatorPo operatorPo)
	 */
	@Test
	public void testGetOperator() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: insertUser(UserPo userPo)
	 */
	@Test
	public void testInsertUser() throws Exception {
//TODO: Test goes here...
//		System.out.println(t.insertUser(user));
	}

	/**
	 * Method: updateUser(UserPo userPo)
	 */
	@Test
	public void testUpdateUser() throws Exception {
//TODO: Test goes here...
//		System.out.println(t.updateUser(user));
	}

	/**
	 * Method: getUser(UserPo userPo)
	 */
	@Test
	public void testGetUser() throws Exception {
//TODO: Test goes here...
//		System.out.println(t.getUser(user));
	}


} 
