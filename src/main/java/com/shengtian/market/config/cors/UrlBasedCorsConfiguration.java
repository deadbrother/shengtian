package com.shengtian.market.config.cors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Iterator;
import java.util.List;

/**
 * Created by leon on 2016/11/7.
 */
@ConditionalOnProperty({"cors.configs[0].path"})
@Configuration
@ConfigurationProperties(
        prefix = "cors"
)
public class UrlBasedCorsConfiguration {
    private List<CorsConfig> configs;

    public UrlBasedCorsConfiguration() {
    }

    @Bean
    public WebMvcConfigurer addCorsMappings() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                Iterator var6 = UrlBasedCorsConfiguration.this.configs.iterator();

                while(var6.hasNext()) {
                    CorsConfig corsConfiguration = (CorsConfig)var6.next();
                    String path = corsConfiguration.getPath();
                    CorsRegistration corsRegistration = registry.addMapping(path);
                    List<String> list = corsConfiguration.getAllowedOrigins();
                    if (list != null) {
                        corsRegistration.allowedOrigins((String[])list.toArray(new String[0]));
                    }

                    list = corsConfiguration.getAllowedMethods();
                    if (list != null) {
                        corsRegistration.allowedMethods((String[])list.toArray(new String[0]));
                    }

                    list = corsConfiguration.getAllowedHeaders();
                    if (list != null) {
                        corsRegistration.allowedHeaders((String[])list.toArray(new String[0]));
                    }

                    list = corsConfiguration.getExposedHeaders();
                    if (list != null) {
                        corsRegistration.exposedHeaders((String[])list.toArray(new String[0]));
                    }

                    Boolean yes = corsConfiguration.getAllowCredentials();
                    if (yes != null) {
                        corsRegistration.allowCredentials(yes);
                    }

                    Long age = corsConfiguration.getMaxAge();
                    if (age != null) {
                        corsRegistration.maxAge(age);
                    }
                }

            }
        };
    }

    public List<CorsConfig> getConfigs() {
        return this.configs;
    }

    public void setConfigs(List<CorsConfig> configs) {
        this.configs = configs;
    }
}
