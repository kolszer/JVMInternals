# Zadanie 1: OutOfMemoryError

### Aby uruchomi� aplikacj� nale�y wpisa� w CMD:

1. git clone git@github.com:kolszer/JVMInternals.git

2. cd JVMInternals/OutOfMemProject

3. mvn clean install

4. mvn exec:java -Dexec.mainClass="App"


Wyja�nienie:
Przepe�nienie pami�ci powoduje przepe�nieie listy. Do listy w niesko�czonej p�tli dodajemy elementy. W pewnym momencie lista jest tak du�a, �e brakuje miejsca na pami�ci RAM i program ko�czy si� wyj�tkiem OutOfMemoryError.