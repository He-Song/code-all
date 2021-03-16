package com.github;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;

public class SparkQueryTest {

    //    private static final String url = "jdbc:postgresql://localhost:5432/stats_dev";
    private static final String url = "jdbc:uxdb://192.168.1.210:5432/stats_dev";
    private static final String driver = "com.uxsino.uxdb.Driver";
    private static final String user = "uxsino";
    private static final String password = "Uxs!nO10";


    private static final String dbtable = "ux_601_2020_2020_basics";
    private static final String viewName = "globalView_601";
//    private static final String dbtable = "ux_yearbooks_36";
//    private static final String viewName = "ux_yearbooks_36";

    public static void main(String[] args) {
        SparkSession sparkSession = sparkConfig();
        createTempTable(sparkSession);
        queryTest(sparkSession);
    }

    private static void queryTest(SparkSession sparkSession) {
        String sql = String.format("select count(*) from global_temp.%s", viewName);

        sparkSession.sql(sql).show();
        System.out.println();
        System.out.println(1);
    }

    private static void createTempTable(SparkSession sparkSession) {
        DataFrameReader dFrameReader = sparkSession.read().format("jdbc")
                .option("url", url)
                .option("user", user)
                .option("driver", driver)
                .option("password", password)
                .option("dbtable", dbtable)/*.option("partitionColumn", "id")*/;

        Long time1 = System.currentTimeMillis();
        Dataset<Row> da = dFrameReader.load().repartition(8).persist(StorageLevel.MEMORY_ONLY());
        //da.show();
        Long time2 = System.currentTimeMillis();
        System.out.println(String.format("load table  spend %s ms", time2 - time1));
        da.createOrReplaceGlobalTempView(viewName);
        Long time3 = System.currentTimeMillis();
        System.out.println(String.format("creat tempView spend %s ms", time3 - time2));
    }

    private static SparkSession sparkConfig() {
        SparkConf conf = new SparkConf();
        conf.setMaster("spark://192.168.1.189:7077");
        conf.set("spark.submit.deployMode", "cluster");
        conf.setAppName("queryTest");

        conf.set("spark.executor.cores", "2");
        conf.set("spark.executor.memory", "2560m");
        conf.set("extraJavaOptions", "-XX:+PrintGCDetails -XX:+PrintGCTimeStamps");

        conf.set("spark.network.timeout", "1200s");
        conf.set("spark.rpc.lookupTimeout", "1200s");

        return SparkSession.builder().config(conf).getOrCreate();
    }

}
