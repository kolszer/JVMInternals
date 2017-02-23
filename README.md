# Zadanie 1: OutOfMemoryError

### Aby uruchomiæ aplikacjê nale¿y wpisaæ w CMD:

1. git clone git@github.com:kolszer/JVMInternals.git

2. cd JVMInternals/OutOfMemProject

3. mvn clean install

4. mvn exec:java -Dexec.mainClass="App"


Wyjaœnienie:
Przepe³nienie pamiêci powoduje przepe³nieie listy. Do listy w nieskoñczonej pêtli dodajemy elementy. W pewnym momencie lista jest tak du¿a, ¿e brakuje miejsca na pamiêci RAM i program koñczy siê wyj¹tkiem OutOfMemoryError.