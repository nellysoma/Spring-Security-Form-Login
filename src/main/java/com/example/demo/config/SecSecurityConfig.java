 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Harmony
 */
@Configuration
@EnableWebSecurity
public class SecSecurityConfig {
    
    //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
    
    /**@Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http
            .formLogin(formLogin -> formLogin
                    .loginPage("/login")
                    .failureUrl("/login-error.html"))
            .logout(logout -> logout
                    .logoutSuccessUrl("/index.html"))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(
                            new AntPathRequestMatcher("/"),
                            new AntPathRequestMatcher("/home.jsp"),
                            new AntPathRequestMatcher("/index.html"),
                            new AntPathRequestMatcher("/login"),
                            new AntPathRequestMatcher("/css/**"),
                            new AntPathRequestMatcher("/favicon.ico")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
                    .requestMatchers(new AntPathRequestMatcher("/shared/**")).hasAnyRole("USER","ADMIN")
                    .anyRequest().authenticated())
                   
            .exceptionHandling(handling -> handling
                    .accessDeniedPage("/403.html"));
        return http.build();
    }**/
    
    /**@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("jim").password("{noop}demo").roles("ADMIN").build(),
                User.withUsername("bob").password("{noop}demo").roles("USER").build(),
                User.withUsername("ted").password("{noop}demo").roles("USER","ADMIN").build());
    }**/
    
    /**@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeHttpRequests((authorize) -> authorize
						.anyRequest().authenticated()
				)
				.httpBasic(withDefaults())
				.formLogin(withDefaults());
                                //.formLogin(formLogin -> formLogin
                                        //.loginPage("/login")
                                       // .failureUrl("/login-error.html"));
		// @formatter:on
		return http.build();
	}**/
    
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            
            http.formLogin((formLogin)-> formLogin
                    .loginPage("/login.html")
                    //.defaultSuccessUrl("/dashboard.html")
                    .failureUrl("/wrongCredentials.html"))
                    .logout(logout -> logout
                    .logoutSuccessUrl("/home.html"))
                    .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(
                            new AntPathRequestMatcher("/"),
                            new AntPathRequestMatcher("/home.html"),
                            new AntPathRequestMatcher("/login.html"),
                            new AntPathRequestMatcher("/css/**"),
                            new AntPathRequestMatcher("/favicon.ico")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
                    .requestMatchers(new AntPathRequestMatcher("/shared/**")).hasAnyRole("USER","ADMIN")
                    )
                    ;
            return http.build();
        }

	// @formatter:off
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
                
                UserDetails jim = User.withUsername("jim")
                        .password("{noop}demo")
                        .roles("ADMIN")
                        .build();
               
                UserDetails bob = User.withUsername("bob")
                        .password("{noop}demo")
                        .roles("USER")
                        .build();
                
		UserDetails ted = User.withUsername("ted")
                        .password("{noop}demo")
                        .roles("USER","ADMIN")
                        .build();
                
                return new InMemoryUserDetailsManager(user,jim,bob,ted);
	}
	// @formatter:on
    
    /**@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("USER")
                .build();
        
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("User")
                .build();
        
        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder().encode("adminPass"))
            .roles("ADMIN")
            .build();
        
        return new InMemoryUserDetailsManager(user1, user2, admin);
        
    }**/
    
    /**@Bean
    public UserDetailsService userDetailsService() {
        
        //UserBuilder users = User.withDefaultPasswordEncoder();
	
        UserDetails user = User.builder() //User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
                
                UserDetails user1 = User.builder()
                        .username("user1")
		        .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
		        .roles("USER")
		        .build();//
                
                InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();
                
                userDetails.createUser(user);
                
                return userDetails;
                
		//return new InMemoryUserDetailsManager(user,user1);
	}**/
    
    
    /**protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
         UserDetails user1 = User.builder()
                 .username("user1")
                 .password(passwordEncoder().encode("user1Pass"))
                 .roles("USER")
                 .build();  
         
         auth.inMemoryAuthentication()
                 .withUser(user1);
    }**/
    
    /**@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                
                .authorizeRequests((requests) -> requests
				.requestMatchers("/dashboard").authenticated()
                                .requestMatchers("/home").permitAll()
				//.anyRequest().permitAll()
                )
                
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/wrongCredentials")
                )
                .httpBasic(withDefaults() )
                /**authorizeRequests()
                .requestMatchers( "/dashboard").hasRole("USER")**/
                
                /**.and()
                .formLogin()**/
                ;
      
        //return http.build();
        
       /** http.authorizeRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/**").authenticated()
                .requestMatchers("/login*").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/**").hasAnyRole("USER","ADMIN")
                .requestMatchers("/login").anonymous()
                //.anyRequest().authenticated()
                //.anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
               .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                ///.defaultSuccessUrl("/homepage.html", true)
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .disable();
          
        return http.build();**/
        
        /**http.csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/anonymous*").anonymous()
                .requestMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/homepage.html", true)
                .failureUrl("/login.html?error=true");
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler());**/

    //}
     /**@Bean
     
     public WebSecurityCustomizer webSecurityCustomiaer (){
         
         return (web) -> web.ignoring().requestMatchers("/home");
     }**/
    
    /**@Bean
    public PasswordEncoder passwordEncoder(){
        
        return new BCryptPasswordEncoder();
    }**/
}
