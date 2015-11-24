package net.lkrnac.blog.testing.mockbeanv2.fake;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.lkrnac.blog.testing.mockbeanv2.AddressDao;
import net.lkrnac.blog.testing.mockbeanv2.annotation.BeanMock;

@Configuration
@BeanMock
public class AddressDaoMock {
	@Bean
	@Primary
	public AddressDao registerAddressDaoMock() {
		return mock(AddressDao.class);
	}
}
