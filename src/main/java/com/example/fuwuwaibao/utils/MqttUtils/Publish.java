package com.example.fuwuwaibao.utils.MqttUtils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
public class Publish {
    public static void publish(String topic_name, String content) {
        String broker = "tcp://test.ranye-iot.net:1883";
        String topic = topic_name;
        String clientid = "DJS_PYM_public";
        int qos = 0;

        try {
            MqttClient client = new MqttClient(broker, clientid);
            // 连接参数
            MqttConnectOptions options = new MqttConnectOptions();

            options.setConnectionTimeout(60);
            options.setKeepAliveInterval(60);
            // 连接
            client.connect(options);
            // 创建消息并设置 QoS
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            // 发布消息
            client.publish(topic, message);
            System.out.println("Message published");
            System.out.println("topic: " + topic);
            System.out.println("message content: " + content);
            // 关闭连接
            client.disconnect();
            // 关闭客户端
            client.close();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Publish.publish("Contorl_Door","open");
    }
}
