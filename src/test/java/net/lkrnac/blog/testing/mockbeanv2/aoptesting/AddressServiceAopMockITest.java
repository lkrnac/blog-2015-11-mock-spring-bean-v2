package net.lkrnac.blog.testing.mockbeanv2.aoptesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.lkrnac.blog.testing.mockbeanv2.AopApplication;
import net.lkrnac.blog.testing.mockbeanv2.beans.AddressDao;
import net.lkrnac.blog.testing.mockbeanv2.beans.AddressService;

@ActiveProfiles({"AddressService-aop-mock-test", "aop"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AopApplication.class)
public class AddressServiceAopMockITest {
	@Autowired
	private AddressService addressService; 

	@Autowired
	private AddressDao addressDao;
	
	private AddressDaoMock addressDaoMock;
 
	@Before
	public void resetMock() {
		addressDaoMock = (AddressDaoMock) addressDao; 
		Mockito.reset(addressDaoMock.getMockDelegate()); 
	}
	 
	@Test
	public void testGetAddressForUser() {
		// GIVEN
		Mockito.when(addressDao.readAddress("john"))
			.thenReturn("5 Bright Corner");
 
		// WHEN 
		String actualAddress = addressService.getAddressForUser("john");
 
		// THEN  
		Assert.assertEquals("5 Bright Corner", actualAddress);
	}
}
