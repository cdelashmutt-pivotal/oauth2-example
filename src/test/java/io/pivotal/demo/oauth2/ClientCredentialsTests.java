package io.pivotal.demo.oauth2;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class ClientCredentialsTests {

	/**
	 * A simple test to show how to use a client credentials style grant to do things.
	 */
	@Test
	public void testClientCredentials() {
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setClientId("fooapp");
		resourceDetails.setClientSecret("barpass");
		resourceDetails.setAccessTokenUri("http://uaa.south.fe.pivotal.io/oauth/token");
		
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		assertThat(restTemplate.getAccessToken().getValue(), notNullValue());
		
		String response = restTemplate.getForObject("http://uaa.south.fe.pivotal.io/oauth/clients", String.class);
		System.out.println(response);
	}
}
