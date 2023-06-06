package com.example.fuwuwaibao;

import com.example.fuwuwaibao.utils.MqttUtils.Publish;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class TestPublicTopic {
    static void test() {
        String broker = "tcp://broker-cn.emqx.io:1883";
        String topic = "test/djs/D4:D4:DA:E4:A3:AC/mini";
        String clientid = "DJS_PYM_public";
        String content = "1";
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
            TestPublicTopic.test();
    }

}
