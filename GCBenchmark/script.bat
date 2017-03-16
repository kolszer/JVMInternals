@echo OFF
javac App.java
echo -Xmx128m -Xms128m
echo -XX:+UseParallelOldGC
echo 1 thread static alloc
java -Xmx128m -Xms128m -XX:+UseParallelOldGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseParallelOldGC App 1 0
echo 8 thread static alloc
java -Xmx128m -Xms128m -XX:+UseParallelOldGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseParallelOldGC App 8 0
echo ==================================
echo -Xmx128m -Xms128m
echo -XX:+UseConcMarkSweepGC
echo 1 thread static alloc
java -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC App 1 0
echo 8 thread static alloc
java -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC App 8 0
echo ==================================
echo -Xmx128m -Xms128m
echo -XX:+UseG1GC
echo 1 thread static alloc
java -Xmx128m -Xms128m -XX:+UseG1GC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseG1GC App 1 0
echo 8 thread static alloc
java -Xmx128m -Xms128m -XX:+UseG1GC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx128m -Xms128m -XX:+UseG1GC App 8 0
echo ======================================================
echo -Xmx512m -Xms512m
echo -XX:+UseParallelOldGC
echo 1 thread static alloc
java -Xmx512m -Xms512m -XX:+UseParallelOldGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseParallelOldGC App 1 0
echo 8 thread static alloc
java -Xmx512m -Xms512m -XX:+UseParallelOldGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseParallelOldGC App 8 0
echo ==================================
echo -Xmx512m -Xms512m
echo -XX:+UseConcMarkSweepGC
echo 1 thread static alloc
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC App 1 0
echo 8 thread static alloc
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC App 8 0
echo ==================================
echo -Xmx512m -Xms512m
echo -XX:+UseG1GC
echo 1 thread static alloc
java -Xmx512m -Xms512m -XX:+UseG1GC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseG1GC App 1 0
echo 8 thread static alloc
java -Xmx512m -Xms512m -XX:+UseG1GC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx512m -Xms512m -XX:+UseG1GC App 8 0
echo ======================================================
echo -Xmx1024m -Xms1024m
echo -XX:+UseParallelOldGC
echo 1 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseParallelOldGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseParallelOldGC App 1 0
echo 8 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseParallelOldGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseParallelOldGC App 8 0
echo ==================================
echo -Xmx1024m -Xms1024m
echo -XX:+UseConcMarkSweepGC
echo 1 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC App 1 0
echo 8 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC App 8 0
echo ==================================
echo -Xmx1024m -Xms1024m
echo -XX:+UseG1GC
echo 1 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseG1GC App 1 1000000
echo 1 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseG1GC App 1 0
echo 8 thread static alloc
java -Xmx1024m -Xms1024m -XX:+UseG1GC App 8 1000000
echo 8 thread dynamic alloc
java -Xmx1024m -Xms1024m -XX:+UseG1GC App 8 0