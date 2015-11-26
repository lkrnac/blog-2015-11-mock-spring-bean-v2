package net.lkrnac.blog.testing.mockbeanv2.fake;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import net.lkrnac.blog.testing.mockbeanv2.AddressDao;
import net.lkrnac.blog.testing.mockbeanv2.TestProfiles;

@Profile(TestProfiles.ADDRESS_SERVICE_TEST)
@Configuration
public class AddressDaoTestConfiguration {
	@Bean
	@Primary
	public AddressDao addressDao() {
		return mock(AddressDao.class);
	}
}
