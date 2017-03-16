# Zadanie 3: GC Performance

### Results:

Poni¿ej znajduje siê tabela z minimalnymi, maxymalnymi i srednimi wartosciami(w milisekundach), jakie 
uzyskalem podczas uruchomienia programu z roznymi parametrami dla GC i z rozna iloscia watkow. 
Dane zostaly uzyskane na 10 takich samych uruchomieniach.

+--------------------------------------------------------------------+-------+--------+----------+
| Parameter values                                                   | Min   | Max    | Mean     |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseParallelOldGC 1 thread static alloc      | 374   | 655    | 453.9    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseParallelOldGC 1 thread dynamic alloc     | 195   | 548    | 365.2    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseParallelOldGC 8 thread static alloc      | 64798 | 176945 | 106757.4 |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseParallelOldGC 8 thread dynamic alloc     | 2701  | 49936  | 22970.3  |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC 1 thread static alloc    | 575   | 641    | 603.2    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC 1 thread dynamic alloc   | 173   | 577    | 306.8    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC 8 thread static alloc    | 40550 | 71927  | 50901.5  |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC 8 thread dynamic alloc   | 4190  | 44086  | 25458    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseG1GC 1 thread static alloc               | 466   | 749    | 565.9    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseG1GC 1 thread dynamic alloc              | 171   | 497    | 329.5    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseG1GC 8 thread static alloc               | 25030 | 34741  | 30064.5  |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx128m -Xms128m -XX:+UseG1GC 8 thread dynamic alloc              | 1360  | 20749  | 11528.5  |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseParallelOldGC 1 thread static alloc      | 368   | 491    | 398      |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseParallelOldGC 1 thread dynamic alloc     | 229   | 430    | 290.4    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseParallelOldGC 8 thread static alloc      | 7439  | 80308  | 22358.2  |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseParallelOldGC 8 thread dynamic alloc     | 656   | 1055   | 863.8    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC 1 thread static alloc    | 585   | 702    | 620.7    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC 1 thread dynamic alloc   | 129   | 699    | 370.3    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC 8 thread static alloc    | 6103  | 8695   | 7515.6   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC 8 thread dynamic alloc   | 937   | 1765   | 1464.9   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseG1GC 1 thread static alloc               | 470   | 638    | 545      |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseG1GC 1 thread dynamic alloc              | 127   | 497    | 308.4    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseG1GC 8 thread static alloc               | 3939  | 5036   | 4491.4   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx512m -Xms512m -XX:+UseG1GC 8 thread dynamic alloc              | 1257  | 2130   | 1658.4   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseParallelOldGC 1 thread static alloc    | 320   | 540    | 377.7    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseParallelOldGC 1 thread dynamic alloc   | 177   | 319    | 236.2    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseParallelOldGC 8 thread static alloc    | 1396  | 2085   | 1603.1   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseParallelOldGC 8 thread dynamic alloc   | 732   | 1072   | 922.6    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC 1 thread static alloc  | 322   | 440    | 361.4    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC 1 thread dynamic alloc | 150   | 378    | 248.7    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC 8 thread static alloc  | 2661  | 3421   | 2860.6   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseConcMarkSweepGC 8 thread dynamic alloc | 1121  | 2055   | 1439.2   |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseG1GC 1 thread static alloc             | 511   | 753    | 582.1    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseG1GC 1 thread dynamic alloc            | 129   | 610    | 388.1    |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseG1GC 8 thread static alloc             | 2293  | 3106   | 2525     |
+--------------------------------------------------------------------+-------+--------+----------+
| -Xmx1024m -Xms1024m -XX:+UseG1GC 8 thread dynamic alloc            | 919   | 1809   | 1344.2   |
+--------------------------------------------------------------------+-------+--------+----------+

### Runtime environment:

HW:
	CPU: Intel Core i3-2330M @ 2.20GHz
	RAM: 5GB DDR3
OS:
	Windows 10 x64
JVM:
	1.8.0_121

### Conclusion:

Z powyzszej tabeli mozna wywnioskowac, ze algorytm ParallelOldGC szybszy od ConcMarkSweepGC 
i G1GC jesli program pracuje na jednym watku. Natomiast algorytm G1GC jest szybszy 
od ParallelOldGC i ConcMarkSweepGC jesli program pracuje na n watkach (n>1). 
Algorytm ConcMarkSweepGC wydaje siê kompromisem miedzy ParallelOldGC, 
a G1GC jesli nasz program ma wykonywac kod na 1 watku jak i n watkach (n>1).