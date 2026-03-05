package dev.lucas.order_ms.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;

@Configuration
public class AwsConfig {

    @Value("${aws.endpoint}")
    private String awsEndpoint;
    @Value("${aws.region}")
    private String awsRegion;
    @Value("${aws.access-key-id}")
    private String accessKeyId;
    @Value("${aws.secret-access-key}")
    private String secretAccessKey;
    @Value("${aws.sqs.order-created-queue}")
    private String orderCreatedQueue;

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .endpointOverride(URI.create(awsEndpoint))
                .region(Region.of(awsRegion))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();
    }

    @Bean
    public String orderCreatedQueueUrl(SqsClient sqsClient) {
        try {
            CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                    .queueName(orderCreatedQueue)
                    .build();
            return sqsClient.createQueue(createQueueRequest).queueUrl();
        } catch (Exception e) {
            return sqsClient.getQueueUrl(b -> b.queueName(orderCreatedQueue)).queueUrl();
        }
    }

}
