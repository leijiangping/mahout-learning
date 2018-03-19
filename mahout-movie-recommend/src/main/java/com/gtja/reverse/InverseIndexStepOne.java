package com.gtja.reverse;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class InverseIndexStepOne {
    public static class StepOneMapper extends Mapper<LongWritable,Text,Text,LongWritable>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            final LongWritable COUINT = new LongWritable(1);
            String line = value.toString();
            String[] fields = StringUtils.split(line," ");
            FileSplit fileSplit = (FileSplit) context.getInputSplit();
            String fileName = fileSplit.getPath().getName();
            for(String field : fields){
                context.write(new Text(field + "-->" +fileName),COUINT);
            }
        }
    }

    public static class StepOneReducer extends Reducer<Text,LongWritable,Text,LongWritable>{
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long counter = 0;
            for(LongWritable value:values){
                counter += value.get();
            }
            context.write(key,new LongWritable(counter));
        }
    }


    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //job.setJarByClass(InverseIndexStepOne.class);

        job.setMapperClass(StepOneMapper.class);
        job.setReducerClass(StepOneReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPaths(job, "F:/Hadoop/data/reverse/input/a.txt");
        FileInputFormat.addInputPaths(job, "F:/Hadoop/data/reverse/input/b.txt");
        FileInputFormat.addInputPaths(job, "F:/Hadoop/data/reverse/input/c.txt");
        FileOutputFormat.setOutputPath(job, new Path("F:/Hadoop/data/reverse/output"));

        job.waitForCompletion(true);
    }
}
















