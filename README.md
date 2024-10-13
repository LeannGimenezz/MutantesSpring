# Gimenez Leandro - Mutantes
## **Descripción del Proyecto**
Magneto está reclutando mutantes para su lucha contra los X-Men. Para ayudar en esta misión, se ha desarrollado una API que puede determinar si un ser humano es mutante, basándose en el análisis de su secuencia de ADN. 

El método principal que debes implementar tiene la siguiente firma:

```java
boolean isMutant(String[] dna);
```

## Funcionamiento del Programa
La API recibe como parámetro un array de Strings, donde cada elemento representa una fila de una matriz NxN que contiene la secuencia de ADN. Las letras en los Strings solo pueden ser una de las siguientes: A, T, C, G, que corresponden a las bases nitrogenadas del ADN.

Para determinar si un humano es mutante, la secuencia de ADN debe contener más de una serie de cuatro letras idénticas consecutivas, ya sea en dirección horizontal, vertical o diagonal.

El usuario deberá enviar la secuencia de ADN en formato JSON, asegurándose de que forme una matriz NxN válida.

###### Request de un DNA mutante
```json
{
  "dna": [
    "AACGTT",
    "ATGTCC",
    "ACGGGG",
    "ATTGCC",
    "CCGTCC",
    "CCGTCC"
  ] 
}
```
###### Response de un DNA mutante
```json
{
  status: 200 OK
  Devuelve un true
}
```
Esta matriz tiene mas de una secuencia de cuatro letras iguales, esto quiere decir que el **DNA** ingresado es de un **_MUTANTE_**.

La API nos dara una response de error personalizado si ingresamos una secuencia no valida como por podria ser una matriz que **NO** sea de NxN, un arreglo vacio, una letra no valida, un array de null o una fila null.

###### Request de un DNA no valido
```json
{
  "dna": [
    "AACGTT",
    "ATGTCC",
    "ACGGGG",
    "ATTGCC",
    "CCGTCC",
    "CC"
  ] 
}
```
###### Response de un DNA no valido
```json
{
    Lanza un FORBIDDEN, con el siguiente texto: "Dna incorrecto"
}
```
## Despliegue
El proyecto se encuentra alojado en Render y podran acceder a travez del siguiente link.

[Accede a la API Mutantes](https://mutantesspring-thyw.onrender.com)

Para Ingresar a la base de datos, puedes ingresar con el siguiente link:

[Accede a la base de datos H2](http://localhost:8080/h2-console/)

Credenciales de acceso a la base de datos en memoria:
* URL: jdbc:h2:tcp://localhost/./testdna;
* USERNAME: sa
* PASSWORD: password

## Endpoints de la api
* ### Endpoint /v1/api/mutant/test
Este endpoint de tipo **POST** recibe como parametro un JSON con la matriz que contiene el DNA. Para luego evaluar si el dna ingresado es correcto (Que tenga las letras que solo se pueden ingresar, que sea una matriz cuadrada y que no se repita el dna ingresado),
para luego verificar si el dna es mutante o humano.


## Endpoints de los stats
* ### Endpoint /v1/api/mutant/stats
Este endpoint de tipo **GET** nos devuelve un JSON con la cantidad de personas con DNA humano o mutante y ademas un ratio.

###### Respons del endpoint /stats

```json
{
    "mutants": Cantidad de dnas detectados como mutantes,
    "humans": Cantidad de dnas detectados como humanos,
    "ratio": mutants/humans
}
```
