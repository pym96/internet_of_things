package com.example.fuwuwaibao;

import org.eclipse.paho.client.mqttv3.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author DJS
 * Date create 14:28 2023/2/22
 * Modified By Pan Jiaxiang
 **/
public class TestSubscribeTopic {

    static public void getId() {
        String broker = "tcp://broker-cn.emqx.io:1883";
            String topic = " /test/djs/94:69:3F:99:11:DD:A0:FE:C8/hardware";
            String clientid = "DJS_PYM_subscribe";
            int qos = 0;

        final Set<String> str = new HashSet<String>();

            try {
                MqttClient client = new MqttClient(broker, clientid);
                // 连接参数
                MqttConnectOptions options = new MqttConnectOptions();
                options.setConnectionTimeout(60);
                options.setKeepAliveInterval(60);
                // 设置回调
                client.setCallback(new MqttCallback() {

                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost: " + cause.getMessage());
                    }

                    public void messageArrived(String topic, MqttMessage message) {
                        System.out.println("topic: " + topic);
                        System.out.println("Qos: " + message.getQos());
                        System.out.println("message content: " + new String(message.getPayload()));
                        var s = new String(message.getPayload()).split(",");

                        str.addAll(Arrays.asList(s));

                    }

                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete---------" + token.isComplete());
                    }

                });

                client.connect(options);
                client.subscribe(topic, qos);
            } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        TestSubscribeTopic.getId();
    }
}
