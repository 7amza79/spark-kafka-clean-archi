package com.habe.project.spark.infra.messaging;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

@Component
public class SparkStreamingListener {



/*
    private SparkSession sparkSession;

    public SparkStreamingListener(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }


    public void consume(){

        final Dataset<Row> rowDataset = sparkSession.readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "192.168.1.100:9092")
                .option("subscribe", "json_topic")
                .option("startingOffsets", "earliest") // From starting
                .load();

    }
*/

}
