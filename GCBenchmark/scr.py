import os
from statistics import mean

path = "C:\\Users\z\Desktop\logs"
ls = os.listdir(path)
f = []
for i in ls:
    f.append(open(path+"\\"+i))
log = []
for i in f:
    x = i.readlines()
    tmp=3
    tmp2=0
    for j in range(36):
        log.append(x[j*2+tmp])
        tmp2+=1
        if tmp2==4:
            tmp+=3
            tmp2=0
ttt = open(path+"\\"+ls[0])
ttx = ttt.readlines()
tmp=2
tmp2=0
toWrite = []
for i in range(36):
    if tmp2==0:
        toWrite.append(x[i*2+tmp-2])
        toWrite.append(x[i*2+tmp-1])
    toWrite.append(x[i*2+tmp])
    tmp2+=1
    if tmp2==4:
        tmp+=3
        tmp2=0
    xx=[]
    for j in range(10):
        xx.append(int(log[(j*36)+i]))
    toWrite.append(min(xx))
    toWrite.append(max(xx))
    toWrite.append(mean(xx))
    toWrite.append("===================")
fileToWrite = open(path+"\\summarylog.txt", 'w')
for i in toWrite:
    fileToWrite.write(str(i)+'\n')
fileToWrite.close()
