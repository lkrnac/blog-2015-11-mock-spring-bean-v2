package net.lkrnac.blog.testing.mockbeanv2.fake;

import static org.mockito.Mockito.spy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import net.lkrnac.blog.testing.mockbeanv2.AddressService;
import net.lkrnac.blog.testing.mockbeanv2.TestProfiles;

@Profile(TestProfiles.USER_SERVICE_TEST)
@Configuration
public class AddressServiceSpy {
	@Bean
	@Primary
	public AddressService registerAddressServiceSpy(AddressService addressService) {
		return spy(addressService);
	}
}
