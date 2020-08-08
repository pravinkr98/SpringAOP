package com.ps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AOPConfig.class,ServiceConfig.class,PersistenceConfig.class})
public class AppConfig {

}
