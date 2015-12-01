package net.lkrnac.blog.testing.mockbeanv2.beans;

import static org.mockito.Mockito.spy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import net.lkrnac.blog.testing.mockbeanv2.beans.AddressService;

@Profile(TestProfiles.USER_SERVICE_TEST)
@Configuration
public class AddressServiceTestConfiguration {
	@Bean
	@Primary
	public AddressService addressServiceSpy(AddressService addressService) {
		return spy(addressService);
	}
}
