package net.lkrnac.blog.testing.mockbeanv2.fake;

import static org.mockito.Mockito.spy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.lkrnac.blog.testing.mockbeanv2.AddressService;
import net.lkrnac.blog.testing.mockbeanv2.annotation.BeanMock;

@Configuration
@BeanMock
public class AddressServiceSpy {
	@Bean
	@Primary
	public AddressService registerAddressServiceSpy(AddressService addressService) {
		return spy(addressService);
	}
}
