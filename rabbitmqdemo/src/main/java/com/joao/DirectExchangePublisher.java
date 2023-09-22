package com.joao;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class DirectExchangePublisher {
    public static void main(String[] args)  throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel =  connection.createChannel();

        String message = "Direct Exchange message";

        channel.basicPublish("Direct-Exchange", "mobile", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
