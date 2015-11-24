package net.lkrnac.blog.testing.mockbeanv2;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import net.lkrnac.blog.testing.mockbeanv2.AddressService;
import net.lkrnac.blog.testing.mockbeanv2.Application;
import net.lkrnac.blog.testing.mockbeanv2.UserService;
import net.lkrnac.blog.testing.mockbeanv2.fake.AddressServiceSpy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, AddressServiceSpy.class })
public class UserServiceITest {
	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Test
	public void testGetUserDetails() {
		// GIVEN - spring context defined by Application class

		// WHEN
		String actualUserDetails = userService.getUserDetails("john");

		// THEN
		Assert.assertEquals("User john, 3 Dark Corner", actualUserDetails);
		verify(addressService, times(1)).getAddressForUser("john");
	}
}
