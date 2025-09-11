# Ejercicio 1
- Permite la programación genérica la reutilización de código y ayuda a evitar el código duplicado?

Sí, la programación genérica permite una reutilización de código y ayuda a evitar la duplicación de código ya que permite escribir funciones y estructuras que pueden operar con diferentes tipos de datos sin necesidad de reescribirlos. Lo cual reduce las líneas de código que deben escribirse y mantenerse, ya que una única función genérica puede reemplazar múltiples funciones específicas para cada tipo de dato.
En nuestro ejemplo el siguiente método sirve para todos los tipos de dato (Integer, String, Double, etc.)
    public static <T> void intercambiar(T[] array, int i, int j) {}

    Al compilar, se sustituye T por el tipo de dato real en cada lamada. Es decir, se escribe una sola línea de código y se reutiliza para cada caso. Se evita la duplicación de código al utilizar programación genérica.

