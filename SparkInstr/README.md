# Zadanie 6: Instrumentacja

### Aby uruchomic aplikacje nalezy wpisac w CMD:

1. git clone git@github.com:kolszer/JVMInternals.git

2. cd JVMInternals/SparkInstr/my-app

3. mvn install

4. W celu zmiany wyswietlania czasu wykonywania metody na przekazywane parametry
nalezy odkomentowac/zakomentowac w myAgent.java:
-Dla czasu: inst.addTransformer(new TimeTransformer());

-Dla parametrow: inst.addTransformer(new ParameterTransformer());