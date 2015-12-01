package net.lkrnac.blog.testing.mockbeanv2.beans;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import net.lkrnac.blog.testing.mockbeanv2.beans.AddressDao;

@Profile("AddressService-test")
@Configuration
public class AddressDaoTestConfiguration {
	@Bean
	@Primary
	public AddressDao addressDaoMock() {
		return mock(AddressDao.class);
	}
}
