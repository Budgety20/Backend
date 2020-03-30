package com.budgety

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
class ApplicationConfig {
     var name: String? = null
     var mongoUri: String? = null
     var databaseName: String? = null
}