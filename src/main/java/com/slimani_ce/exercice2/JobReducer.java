package com.slimani_ce.exercice2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class JobReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int totalRequests = 0;
        for (IntWritable value : values) {
            totalRequests += value.get();
        }
        context.write(key, new IntWritable(totalRequests));
    }
}
