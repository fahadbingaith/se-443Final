#broker_address="iot.eclipse.org"

import paho.mqtt.client as paho
broker_address="broker.hivemq.com"
port=1883
print("Publisher is working")
def on_publish(client,userdata,result):          #create function for callback
    print("data published\n")
    pass

client1= paho.Client("control1")                 #create client object
client1.on_publish = on_publish                  #assign function to callback
client1.connect(broker_address,port)             #establish connection

ret = client1.publish("fahad-180075", "se-443")  # publish