import java.io.IOException;
import java.util.Arrays;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public static class Mapperr extends Mapper<Object, Text, Text, Text> {
    private Text m_id = new Text();
    private Text m_others = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] split = line.split(" ");
        String subject = split[0];
        String[] friends = Arrays.copyOfRange(split, 1, split.length);

        // For each friend in the list, output the (UserFriend, ListOfFriends) pair
        for (String friend : friends) {
            String others = String.join(" ", Arrays.copyOfRange(split, 1, split.length));
            String id = subject.compareTo(friend) < 0 ? subject + friend : friend + subject;
            m_id.set(id);
            m_others.set(others);
            context.write(m_id, m_others);
        }
    }
}


-----------------------------------------------------------------------------------------------------

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public static class Reducerr extends Reducer<Text, Text, Text, Text> {
    private Text m_result = new Text();

    private String intersection(String s1, String s2) {
        HashSet<String> set1 = new HashSet<>(Arrays.asList(s1.split(" ")));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(s2.split(" ")));

        set1.retainAll(set2); 

        StringBuilder resultBuilder = new StringBuilder();
        for (String mutualFriend : set1) {
            resultBuilder.append(mutualFriend).append(" ");
        }

        // Remove the trailing space if it exists
        if (resultBuilder.length() > 0) {
            resultBuilder.setLength(resultBuilder.length() - 1);
        }

        return resultBuilder.toString();
    }

    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String[] combined = new String[2];
        int cur = 0;
        for (Text value : values) {
            combined[cur++] = value.toString();
        }

        String Driverr = intersection(combined[0], combined[1]);
        m_result.set(Driverr);
        context.write(key, m_result);
    }
}



--------------------------------------------------------------------------------
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public static class Reducerr extends Reducer<Text, Text, Text, Text> {
    private Text m_result = new Text();

    private String intersection(String s1, String s2) {
        HashSet<String> set1 = new HashSet<>(Arrays.asList(s1.split(" ")));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(s2.split(" ")));

        set1.retainAll(set2); 

        StringBuilder resultBuilder = new StringBuilder();
        for (String mutualFriend : set1) {
            resultBuilder.append(mutualFriend).append(" ");
        }

        // Remove the trailing space if it exists
        if (resultBuilder.length() > 0) {
            resultBuilder.setLength(resultBuilder.length() - 1);
        }

        return resultBuilder.toString();
    }

    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String[] combined = new String[2];
        int cur = 0;
        for (Text value : values) {
            combined[cur++] = value.toString();
        }

        String Driverr = intersection(combined[0], combined[1]);
        m_result.set(Driverr);
        context.write(key, m_result);
    }
}


----------------------------------------------------------------------------------------
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driverr {

    public static void main(String args[]) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "mutual friends example");

        job.setJarByClass(Driverr.class);
        job.setMapperClass(Mapperr.class);
        job.setReducerClass(Reducerr.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
