package com.bigfm.com.BigFmDataManagement.hazelcast;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientUserCodeDeploymentConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
//@Configuration
public class BeansConfig {


    //@Bean
    public ClientConfig clientConfig(
            @Value("${hazelcast.cluster.addresses}") String addressListString,
            @Value("${hazelcast.cluster.whitelistedClasses}") String whitelistedClasses,
            @Value("${hazelcast.client.heartbeat.interval}") String heartBeatInterval,
            @Value("${hazelcast.client.heartbeat.timeout}") String heartBeatTimeout) {

        List<String> addressList = Arrays.asList(addressListString.split(","));
        List<String> classList = Arrays.asList(whitelistedClasses.split(","));

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClassLoader(Thread.currentThread().getContextClassLoader());
        ClientUserCodeDeploymentConfig clientUserCodeDeploymentConfig = new ClientUserCodeDeploymentConfig();
        classList.forEach(className -> {
            clientUserCodeDeploymentConfig.addClass(className);
        });

        clientUserCodeDeploymentConfig.setEnabled(true);
        clientConfig.setUserCodeDeploymentConfig(clientUserCodeDeploymentConfig);
        clientConfig.setProperty("hazelcast.client.heartbeat.interval", heartBeatInterval);
        clientConfig.setProperty("hazelcast.client.heartbeat.timeout", heartBeatTimeout);
        addressList.forEach(f -> {
            clientConfig.getNetworkConfig().addAddress(f);
        });

        clientConfig.getNetworkConfig().setRedoOperation(true);

        return clientConfig;
    }

}