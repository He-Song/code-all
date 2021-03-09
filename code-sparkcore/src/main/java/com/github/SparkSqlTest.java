package com.github;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.SparkSession;

public class SparkSqlTest {

    private static String url = "jdbc:postgresql://localhost:5432/stats_dev";
    private static String user = "uxsino";
    private static String driver = "org.postgresql.Driver";
    private static String password = "Uxs!nO10";
    private static String dbtable = "ux_601_2020_2020_basics";

    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder().master("local[*]").appName("localSpark").getOrCreate();
        DataFrameReader dFrameReader = sparkSession.read().format("jdbc")
                .option("url", url)
                .option("user", user)
                .option("driver", driver)
                .option("password", password)
                .option("dbtable", dbtable);
//        dFrameReader.option("partitionColumn", 2)
//                .option("lowerBound", minId.toString()).option("upperBound", maxId.toString())
//                .option("numPartitions", connectionParam.get("loadDataPartitions"));
//        jdbcDS = dFrameReader.load()
//                .repartition(Integer.valueOf(connectionParam.get("repartitions")))
//                .persist(getStorageLevel(connectionParam.get("spark_storageLevel")));
//        dFrameReader.load().show();


    }
}
