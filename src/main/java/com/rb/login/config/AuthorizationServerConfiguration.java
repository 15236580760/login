package com.rb.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 认证服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    // 声明TokenStore实现 数据库存储
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    // 声明 ClientDetails实现 数据库存储
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 配置token获取和验证时的策略 (Spring Security安全表达式),可以表单提交
        security.tokenKeyAccess( "permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }

    /**
     * @param clients
     * @throws Exception
     *
     * 客户端模式token请求：
     * http://127.0.0.1:8351/oauth/token?grant_type=password&client_id=login_test&client_secret=login_test&scope=all&username=test&password=123456
     *
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //客户端信息存储数据库
        clients.withClientDetails(clientDetails());
        /*String secret = passwordEncoder.encode("123456");//$2a$10$af9lXckfuaHRCO7vEOJcgOD9kXvZ5zXD4g/I6gFfd1mHfOifsaHIu
        System.out.println("secret>>>"+secret);*/
//        clients.inMemory() // 客户端信息存储在内存中
//                .withClient("client") //第三方应用用户名
//                // secret密码配置从 Spring Security 5.0开始必须以 {加密方式}+加密后的密码 这种格式填写
//                /* *   当前版本5新增支持加密方式：
//                 *   bcrypt - BCryptPasswordEncoder (Also used for encoding)
//                 *   ldap - LdapShaPasswordEncoder
//                 *   MD4 - Md4PasswordEncoder
//                 *   MD5 - new MessageDigestPasswordEncoder("MD5")
//                 *   noop - NoOpPasswordEncoder 明文形式,不需要设置passwordEncoder
//                 *   pbkdf2 - Pbkdf2PasswordEncoder
//                 *   scrypt - SCryptPasswordEncoder
//                 *   SHA-1 - new MessageDigestPasswordEncoder("SHA-1")
//                 *   SHA-256 - new MessageDigestPasswordEncoder("SHA-256")
//                 *   sha256 - StandardPasswordEncoder*/
//                //以下三种加密方式都可以
//                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
////                .secret(secret)
////                .secret("{noop}123456")
//                .scopes("all") //相当于oauth的权限，这里配置了，请求里的必须和这里匹配
//                .resourceIds(DEMO_RESOURCE_ID)
//                .autoApprove(true)
//                .authorizedGrantTypes("authorization_code", "refresh_token")//授权码模式
//                .accessTokenValiditySeconds(1200) //token有效期
//                .refreshTokenValiditySeconds(50000);//强制清除客户端持有的token
    }
}
