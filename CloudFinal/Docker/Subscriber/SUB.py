import paho.mqtt.client as mqtt
broker_address = "broker.hivemq.com"
print("Running subscriber")
def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc))
    client.subscribe("fahad-180075")

def on_message(client, userdata, msg):
    print(msg.payload.decode(),"was recieved")

client = mqtt.Client()
client.connect(broker_address, 1883, 60)

client.on_connect = on_connect
client.on_message = on_message

client.loop_forever()
