package sample.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/8/19
 * \* Time: 下午5:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class HelloSpark {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("HelloSpark");
        try (JavaSparkContext jsc = new JavaSparkContext(conf)) {
            List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
            JavaRDD<Integer> distData = jsc.parallelize(data);
            Integer i = distData.reduce((a,b) -> a+b);
            System.out.println(i);
        }
    }
}
