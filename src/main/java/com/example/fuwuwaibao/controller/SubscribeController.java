package com.example.fuwuwaibao.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscribe")
public class SubscribeController {

    static void test() {
        String broker = "tcp://test.ranye-iot.net:1883";
        String topic = "Control_Door";
        String clientid = "DJS_PYM_subscribe";
        int qos = 0;

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

    @PostMapping("/")
    @ResponseBody
    public String getId(@RequestBody String topic_name) throws JsonProcessingException {

        return "--";
    }

}
