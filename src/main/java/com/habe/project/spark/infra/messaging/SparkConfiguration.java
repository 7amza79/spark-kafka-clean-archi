package com.habe.project.spark.infra.messaging;


import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.spark.launcher.SparkLauncher.EXECUTOR_MEMORY;

@Configuration
public class SparkConfiguration {


    @Value("${spark.thread.number:1}")
    private String sparkNumberOfThreads;

    @Value("${spark.memory.size:512m}")
    private String sparkMemorySize;

    @Value("${spark.log.level:ERROR}")
    private String sparkLogLevel;

    public SparkConf getSparkConfiguration() {
        return new SparkConf().set(EXECUTOR_MEMORY, this.sparkMemorySize);
    }

    @Bean
    public SparkSession getSparkSession() {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("test")
                .master("local[" + this.sparkNumberOfThreads + "]")
                .config(this.getSparkConfiguration())
                .getOrCreate();

        sparkSession.sparkContext().setLogLevel(sparkLogLevel);
        return sparkSession;
    }

}
