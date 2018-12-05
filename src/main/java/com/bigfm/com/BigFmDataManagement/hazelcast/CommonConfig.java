package com.bigfm.com.BigFmDataManagement.hazelcast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;

//@Configuration
public class CommonConfig
{

	private static final Logger logger = LogManager.getLogger(CommonConfig.class);

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	/*//@Bean
	public Config hazelCastConfig(@Value("${hazelcast.cluster.addresses}") String addressListString,
								  @Value("${hazelcast.cluster.whitelistedClasses}") String whitelistedClasses,
								  @Value("${hazelcast.client.heartbeat.interval}") String heartBeatInterval,
								  @Value("${hazelcast.client.heartbeat.timeout}") String heartBeatTimeout) {

		List<String> classList = Arrays.asList(whitelistedClasses.split(","));
		List<String> addressList = Arrays.asList(addressListString.split(","));
		Config config = new Config();
		config.setInstanceName("hazelcast-cache");

		MapConfig userCache = new MapConfig();
		userCache.setMaxSizeConfig(new MaxSizeConfig(3, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
		userCache.setEvictionPolicy(EvictionPolicy.NONE);
		config.getMapConfigs().put("userCache", userCache);
     	UserCodeDeploymentConfig clientUserCodeDeploymentConfig = new UserCodeDeploymentConfig();
		classList.forEach(className -> {
			clientUserCodeDeploymentConfig.setWhitelistedPrefixes(className);
		});

		clientUserCodeDeploymentConfig.setEnabled(true);


		config.setUserCodeDeploymentConfig(clientUserCodeDeploymentConfig);
		config.setProperty("hazelcast.client.heartbeat.interval", heartBeatInterval);
		config.setProperty("hazelcast.client.heartbeat.timeout", heartBeatTimeout);
		addressList.forEach(f -> {

		config.getNetworkConfig().setPort( Integer.parseInt(f));
		});



		return config;

	}*/
}