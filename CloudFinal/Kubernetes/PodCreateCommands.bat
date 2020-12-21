kubectl run pod1 --image=fahadbingaith/sub --port=1883
kubectl run pod2 --image=fahadbingaith/sub --port=1883 
kubectl run pod3 --image=fahadbingaith/pub --port=1883 
kubectl run pod4 --image=fahadbingaith/pub --port=1883 