package my.condominium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private ResourceServerTokenServices tokenServices;
	
	@Value("${security.jwt.resource-ids}")
	private String resourceIds;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(resourceIds).tokenServices(tokenServices);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.exceptionHandling().authenticationEntryPoint(new AuthException())
		.and()
		.requestMatchers()
		.and()
		.authorizeRequests()
		.antMatchers("/v2/api-docs/**").permitAll()
		.antMatchers("/consultas/**").authenticated()
		.antMatchers("/cargos/**").authenticated()
		.antMatchers("/casas/**").authenticated()
		.antMatchers("/condominios/**").authenticated()
		.antMatchers("/directivas/**").authenticated()
		.antMatchers("/horariosturnos/**").authenticated()
		.antMatchers("/integrantes/**").authenticated()
		.antMatchers("/listasnegras/**").authenticated()
		.antMatchers("/ocupaciones/**").authenticated()
		.antMatchers("/parentescos/**").authenticated()
		.antMatchers("/periodoshorarios/**").authenticated()
		.antMatchers("/porterios/**").authenticated()
		.antMatchers("/tiposcondominios/**").authenticated()
		.antMatchers("/areascomunes/**").authenticated()
		.antMatchers("/menus/**").authenticated()
		.antMatchers("/tokens/**").permitAll()
		.antMatchers("/consultaareascomunes/**").authenticated();
	}
}
