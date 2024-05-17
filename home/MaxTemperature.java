import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapperr extends Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {
        String line = value.toString();
        String year = line.substring(15, 19);
        int airtemp;
        if (line.charAt(87) == '+') {
            airtemp = Integer.parseInt(line.substring(88, 92));
        } else {
            airtemp = Integer.parseInt(line.substring(87, 92));
        }
        String q = line.substring(92, 93);
        if (airtemp != 9999 && q.matches("[01459]")) {
            context.write(new Text(year), new IntWritable(airtemp));
        }
    }
}


-------------------------------------------------------------------------------------

  import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducerr extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {
        int maxvalue = 0;
        for (IntWritable value : values) {
            maxvalue = Math.max(maxvalue, value.get());
        }
        context.write(key, new IntWritable(maxvalue));
    }
}


---------------------------------------------------------------------------------------

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driverr {
    public static void main(String[] args) throws Exception {
        Configuration c = new Configuration();
        Job j = Job.getInstance(c, "maxtemp");
        j.setJarByClass(Driverr.class);
        j.setMapperClass(Mapperr.class);
        j.setReducerClass(Reducerr.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(j, new Path(args[0]));
        FileOutputFormat.setOutputPath(j, new Path(args[1]));
        if (!j.waitForCompletion(true))
            return;
    }
}
