package com.microsoft.hadoop.azure.oldinterface;

import static com.microsoft.hadoop.azure.AzureTableConfiguration.*;

import java.io.*;
import java.util.ArrayList;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

import com.microsoft.hadoop.azure.*;
import com.microsoft.windowsazure.services.table.client.*;

@SuppressWarnings("deprecation")
public class OldAzureTableInputFormat implements InputFormat<Text, WritableEntity> {

	@Override
	public RecordReader<Text, WritableEntity> getRecordReader(InputSplit split,
			JobConf job, Reporter reporter) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {
		AzureTablePartitioner partitioner = getPartitioner(job);
		CloudTable table = getTableReference(job);
		ArrayList<InputSplit> ret = new ArrayList<InputSplit>();
		for (AzureTableInputSplit split : partitioner.getSplits(table)) {
			ret.add(split);
		}
		return ret.toArray(new InputSplit[0]);
	}
}
