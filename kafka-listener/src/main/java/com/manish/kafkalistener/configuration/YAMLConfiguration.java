package com.manish.kafkalistener.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("csv")
@EnableConfigurationProperties
public class YAMLConfiguration {

    private String inputFileLocation;
    private String outputFileBaseLocation;

    public String getInputFileLocation() {
        return inputFileLocation;
    }

    public void setInputFileLocation(String inputFileLocation) {
        this.inputFileLocation = inputFileLocation;
    }

    public String getOutputFileBaseLocation() {
        return outputFileBaseLocation;
    }

    public void setOutputFileBaseLocation(String outputFileBaseLocation) {
        this.outputFileBaseLocation = outputFileBaseLocation;
    }

    @Override
    public String toString() {
        return "YAMLConfiguration{" +
                "inputFileLocation='" + inputFileLocation + '\'' +
                ", outputFileBaseLocation='" + outputFileBaseLocation + '\'' +
                '}';
    }
}
