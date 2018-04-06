# BDDCoreSuraEmpresariales
## Configuracion de Ruta del WebDriver
En el archivo **serenity.properties** se encuentra una configuración por defecto de esta ruta:
```
webdriver.chrome.driver = C://chromedriver.exe
```
Pero la buena práctica es tener una configuración propia dependiendo del sistema operativo, por lo tanto
se recomienda usar siempre el parametro **-Dwebdriver.chrome.driver** para especificar donde está el webDriver
```
gradle test -Dwebdriver.chrome.driver=C://chromedriver.exe
```
## Ejecución Todos los test
Para ejecutar todos los test del proyecto se puede usar
```
gradle test
```
## Ejecución Por ambiente
Para ejecutar todos los test del proyecto se puede usar
```
gradle test -Denv=dllo 
```
**-Denv**: Puede tomar los siguientes valores [local, dllo, lab, pdn].
## Ejecución algunos test
Para ejecutar algunos test se puede usar el comando
```
gradle test -Dtest.single=**/runners/ejemplos/dllo/*
```
todos los filtros que se pueden usar se pueden ver en:
[docGradle](https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/TestFilter.html)
## Ejecución IC (Integración Continua [Jenkins])
Para facilitar la ejecución en IC, se creó una tarea específica que realiza los filtros requeridos por cada aplicación
que se testea con este proyecto:
```
gradle icTest -Denv=dllo -Dapp=pc -Dwebdriver.chrome.driver=C://chromedriver.exe
```
**-Denv**: Para este caso la variable indica tanto el ambiente en el que corren las pruebas como el filtro 
para indicar que test ejecutar
**-Dapp**: Puede tomar los siguientes valores [pc, bc, gc, ejemplos].
## Configurar en Intellij el codestyle de google (Con el que se formatea por defecto este proyecto)
Para hacer esta configuración, se deben seguir los siguientes pasos:
1. Descargar el siguiente archivo [intellij-java-google-style.xml](http://code.google.com/p/google-styleguide/)
2. Guardar el archivo en una ruta de tu maquina (EJ: C:\\config\codestyles)
3. Entrar a Intellij e importar el archivo, usando las siguientes opciones: File -> Settings -> Editor -> Code Style
