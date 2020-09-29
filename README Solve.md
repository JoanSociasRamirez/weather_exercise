# Introducción

**WeatherForecast** es un ejercicio similar a la [Weather kata](https://github.com/CodiumTeam/weather-kata) de [Codium Team](https://www.codium.team).

Se trata de una clase con un método público que devuelve la previsión del tiempo de una ciudad en una fecha concreta.

Para ello, esta clase utiliza una API externa (requiere conexión a internet): [www.metaweather.com](https://www.metaweather.com) 

Ejemplo:

```java
WeatherForecast weatherForecast = new WeatherForecast();
weatherForecast.getCityWeather("Madrid", new Date());
```


# Ejercicio

El ejercicio consiste en **refactorizar** el código para hacerlo más **mantenible**, ya que el código existente, aunque **funciona**, es muy difícil de entender. 
  
Para ello se pueden realizar múltiples modificaciones siempre que se mantenga el API público. Ejemplos de modificaciones: incluir tests automáticos, extraer métodos, renombrar variables, modificar tipos de datos, crear nuevas clases, añadir librerías, etc. 


# Documentación

La solución debería contener un fichero README donde se respondan estas preguntas:
- ¿Qué has empezado implementando y por qué? 
	He empezado implementando la clase HttpClient para las peticiones y respuestas de la API.
  Después he creado la clase modelo padre City (primera respuesta de la Api) que engloba la clase Weather (la que contiene la respuesta metereológica de la api).
	Por último he separado la lógica de la clase y extraído los métodos.
- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?
	Primero controlar el caso de que la ciudad que se intenta comprobar no exista (no devuelva id ciudad la respuesta de la api) con un try catch en WeatherForecast.getCityWeather.
  Después he añadido el test para comprobar las peticiones HTTP a la Url (si la api devuelve respuesta 200), ya que no estaba implementado.
- ¿Qué componentes has creado y por qué?
	No he creado ningún componente.
- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?
	No he utilizado dependencias externas.
- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
	No.
- ¿Qué piensas del rendimiento de la aplicación? 
	El rendimiento de la aplicación dependerá del tiempo de respuesta de la API pública.
- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
	Añadiría una caché o variable estática que se actulizara cada minuto/hora/día, dependiendo de la precision que requieran los resultados, con la respuesta de la API
  y que las 100 peticiones recuperaran la respuesta de esta variable para así no realizar tantas peticiones a la API.
- ¿Cuánto tiempo has invertido para implementar la solución? 
	 7 horas.
- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?
  Sí, debido a que si ahora se quieren añadir nuevos atributos en City y Weahter es más sencillo de realizar y entender.

# A tener en cuenta

- Se valorará positivamente el uso de TDD, se revisarán los commits para comprobar su uso.
- Se valorara positivamente la aplicación de los principios SOLID y "código limpio".
- La aplicación ya tiene un API público: un método público que devuelve el tiempo en un String. No es necesario crear nuevas interfaces: REST, HTML, GraphQL, ni nada por el estilo.


# Entrega

La solución se puede subir a un repositorio de código público como [github](https://github.com/). 

Otra opción sería comprimir la solución (incluyendo el directorio .git) en un fichero .zip/.tar.gz y enviarlo por email.
