import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text

class PageMapper extends Mapper[LongWritable, Text, Text, IntWritable] {
  override def map(
      key: LongWritable,
      value: Text,
      context: Mapper[LongWritable, Text, Text, IntWritable]#Context
  ): Unit = {
    val document = value.toString
    var lineArray = document.split("\n")

    lineArray.foreach(line => {
        val lineVals = line.split(" +")
        context.write(new Text(lineVals(1)), new IntWritable(lineVals(2).toInt))
    })
  }
}