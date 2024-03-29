# Juego del Ahorcado en Jetpack Compose

Esta es una implementación simple del clásico juego de adivinar palabras, el Ahorcado, utilizando la biblioteca Android Compose dentro de Jetpack Compose. El objetivo del juego es adivinar la palabra dentro de un cierto número de intentos. El juego proporciona una lista de palabras basadas en el nivel de dificultad seleccionado.

## Empezando
Para ejecutar el juego, necesitas tener instalado Android Studio en tu computadora. Una vez configurado, puedes importar el proyecto en Android Studio y ejecutarlo en un emulador o en un dispositivo físico.

## Pantalla del Juego
La pantalla del juego consta de los siguientes componentes:

- **Palabra Encriptada:** Esta es la palabra que debe ser adivinada, con cada letra reemplazada por un guion bajo.
- **Imagen del Ahorcado:** Esta imagen cambia a medida que el jugador hace suposiciones incorrectas.
- **Botones del Alfabeto:** Estos botones representan las letras del alfabeto. El jugador puede hacer clic en un botón para adivinar la letra correspondiente.
- **Intentos Restantes:** Esto muestra el número de intentos que le quedan al jugador para adivinar la palabra.

## Jugabilidad
El jugador comienza con 6 intentos para adivinar la palabra. La palabra se selecciona aleatoriamente de una lista basada en el nivel de dificultad seleccionado. El jugador puede hacer clic en los botones del alfabeto para adivinar la letra correspondiente. Si la letra está presente en la palabra, se revela en la palabra encriptada. Si la letra no está presente en la palabra, el jugador pierde un intento. El juego termina cuando el jugador ha adivinado la palabra o se ha quedado sin intentos.

## Resumen del Código
El código ha sido creado por **[Tu nombre o nombre de usuario]** y consta de los siguientes componentes principales:

- **GameScreen:** Esta es la función componible principal que muestra la pantalla del juego. Utiliza variables de estado para hacer un seguimiento del estado del juego, como los intentos restantes, la palabra encriptada y la letra clickeada.
- **modificadorLetra:** Esta función modifica la palabra encriptada en función de la letra clickeada.
- **getWord:** Esta función devuelve una palabra aleatoria de una lista basada en el nivel de dificultad seleccionado.
- **encript:** Esta función encripta la palabra reemplazando cada letra por un guion bajo.

## Conclusión
Esta es una implementación simple del juego del Ahorcado utilizando Android Compose dentro de Jetpack Compose. Se puede mejorar aún más agregando más características, como un sistema de puntuación, puntajes altos y efectos de sonido.
