package net.lkrnac.blog.testing.mockbeanv2.aoptesting;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import net.lkrnac.blog.testing.mockbeanv2.beans.AddressService;
import net.lkrnac.blog.testing.mockbeanv2.beans.UserService;

@ActiveProfiles({"UserService-aop-test", "aop"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AopApplication.class)
public class UserServiceWithAopITest {
	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;
	
	private AddressServiceSpy addressServiceSpy;
	 
	@Before  
	public void resetSpy(){   
		addressServiceSpy = (AddressServiceSpy) addressService;
		Mockito.reset(addressServiceSpy.getSpyDelegate());
	}
     
	@Test
	public void testGetUserDetails() {
		// GIVEN - spring context defined by Application class

		// WHEN
		String actualUserDetails = userService.getUserDetails("john");
  
		// THEN 
		Assert.assertEquals("User john, 3 Dark Corner", actualUserDetails);
		verify(addressServiceSpy.getSpyDelegate(), times(1)).getAddressForUser("john");
	}
}
 