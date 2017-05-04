javac ListJNI.java
javah ListJNI
gcc -shared -fpic -o libintlist.so -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux ListJNI.c
java -Djava.library.path=/home/a/Pulpit/JNI/ ListJNI
