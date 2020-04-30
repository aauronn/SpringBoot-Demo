package com.spangular.spangular.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.spangular.spangular.database.dynamodb.repositories")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String dBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String accessKey;

    @Value("${amazon.aws.secretkey}")
    private String secretKey;

    @Value("${amazon.aws.sessiontoken}")
    private String sessionToken;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials()).withRegion(Regions.US_EAST_2);

        if (!StringUtils.isNullOrEmpty(dBEndpoint)) {
            dynamoDB.setEndpoint(dBEndpoint);
        }
        
        // dynamoDB.setRegion(Regions.US_EAST_2);

        // DefaultAWSCredentialsProviderChain cred =
        // DefaultAWSCredentialsProviderChain.getInstance();
        // AmazonDynamoDB dynamoDB = new
        // AmazonDynamoDBClient(cred).withRegion(Regions.US_WEST_2);

        return dynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicSessionCredentials(accessKey, secretKey, sessionToken);
    }
}