import numpy as np
import cv2
import pickle
face_cascade=cv2.CascadeClassifier('cascades/data/haarcascade_frontalface_alt2.xml')
eye_cascade=cv2.CascadeClassifier('cascades/data/haarcascade_eye.xml')
smile_cascade = cv2.CascadeClassifier('cascades/data/haarcascade_smile.xml')
recognize=cv2.face.LBPHFaceRecognizer_create()
recognize.read("trainer.yml")
labels={}
with open("labels.picle","rb") as f:
  og_labels= pickle.load(f)

labels={v:k for k,v in og_labels.items()}

profile_cascade=cv2.CascadeClassifier('cascades/data/haarcascade_profileface.xml')
cap = cv2.VideoCapture(0)

while(True):
    ret,frame=cap.read()
    gray=cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
    faces=face_cascade.detectMultiScale(gray,scaleFactor=1.5,minNeighbors=5)
    profile=profile_cascade.detectMultiScale(gray,scaleFactor=1.5,minNeighbors=5)


    for(x,y,w,h) in faces:
        print("FACE :",x,y,w,h)
        roi_gray=gray[y:y+h,x:x+w]
        roi_color=frame[y:y+h,x:x+w]
        img_item="my-image.png"
        cv2.imwrite(img_item,roi_gray)

        id_,conf =recognize.predict(roi_gray)
        if conf >=45 :
            
            print(labels[id_])
            print(conf)
            font=cv2.FONT_HERSHEY_SIMPLEX
            name=labels[id_]
            color=(255,255,255)
            stroke=2
            cv2.putText(frame,name,(x,y),font,1,color,stroke,cv2.LINE_AA)

        else:
            print(labels[id_])
            print(conf)
            font=cv2.FONT_HERSHEY_SIMPLEX
            name="UNKNOWN"
            color=(255,255,255)
            stroke=2
            cv2.putText(frame,name,(x,y),font,1,color,stroke,cv2.LINE_AA)

        color = (255,0,0)
        stroke=2
        width=x+w
        height=y+h
        cv2.rectangle(frame,(x,y),(width,height),color,stroke)
        # eyes=eye_cascade.detectMultiScale(roi_gray)
        # for(ex,ey,ew,eh) in eyes:
        #     cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),color,stroke)

        # smile = smile_cascade.detectMultiScale(roi_gray)
        # for (ex, ey, ew, eh) in smile:
        #     cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), color, stroke)
    cv2.imshow('frame',frame)
    if cv2.waitKey(20)& 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()