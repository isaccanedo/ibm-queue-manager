package br.com.isaccanedo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class EventqueuemanagerApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(EventqueuemanagerApplication.class);
	
	@Autowired
	private BuildProperties buildProperties;
	
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(EventqueuemanagerApplication.class, args);
	}
	
	@PostConstruct
	public void postConstruct() {		
		LOG.info("----------------------------------------");
		LOG.info("Name:     {}", buildProperties.getName());
		LOG.info("Group:    {}", buildProperties.getGroup());
		LOG.info("Artifact: {}", buildProperties.getArtifact());
		LOG.info("Version:  {}", buildProperties.getVersion());
		LOG.info("Time:     {}", buildProperties.getTime());
		LOG.info("Profiles: {}", Arrays.toString(environment.getActiveProfiles()));		
		LOG.info("----------------------------------------");
	}
	
	

}
