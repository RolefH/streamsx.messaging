package com.ibm.streamsx.messaging.kafka;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

import com.ibm.streams.operator.OutputTuple;
import com.ibm.streams.operator.StreamingOutput;

public abstract class KafkaConsumerClient extends NewKafkaClient {
	Thread processThread;
	StreamingOutput<OutputTuple> streamingOutput;
	
	static final Logger trace = Logger.getLogger(KafkaConsumerClient.class.getCanonicalName());
	
	public KafkaConsumerClient(AttributeHelper topicAH, AttributeHelper keyAH,
			AttributeHelper messageAH, Properties props) {
		super(topicAH,keyAH,messageAH,props);
	}

	abstract void init(
			StreamingOutput<OutputTuple> so,
			ThreadFactory tf, List<String> topics, int threadsPerTopic);
	
}
