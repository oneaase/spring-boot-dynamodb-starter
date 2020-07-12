package com.webcabi.demo.domain;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.webcabi.demo.domain.repository")
public class DynamoDBConfig {
	
	@Value("${amazon.dynamodb.endpoint}")
	private String endpoint;
	
	@Value("${amazon.credential.access.key.id}")
	private String id;
	
	@Value("${amazon.credential.secret.access.key}")
	private String key;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(this.id, this.key)))
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(this.endpoint, null))
				.build();
	}
}
