# Ejercicio 1

¿Por qué implements Runnable suele ser preferible a extends Thread?

Se prefiere implementar Runnable por flexibilidad de herencia, ya que Java no soporta herencia múltiple. Como la clase ThreadSimple ya extiende Thread, no se puede extender otra clase, esto se soluciona heredando de Runnable.
Otro punto, es el de separación de respondabilidades, ya que Runnable representa al tarea a ejecutar, mientras que Thread representa el contenedor que corre la tarea. Es decir, Thread es "dónde corre" y Runnable es "qué corre".
Y, creemos lo más importante, tiene una mayor reutilización ya que una clase que implementa Runnable puede ejecutarse en distintos contextos, mientras que la que extiende Thread queda acoplada a ese uso específico.

# Ejercicio 3

1. Rendimiento: ¿Qué ventaja de rendimiento ofrece un ExecutorService frente a la creación manual de hilos para este problema?
   Un ExecutorService ofrece la ventaja de reutilizar hilos en lugar de crear uno nuevo para cada tarea, ya que crear y destruir hilos tiene un gran costo de tiempo y recursos.
   Con un pool se crean una cantidad fija de hilos (en este caso el número de procesadores de la máquina) y éstos toman tareas de una cola. Ésto resulta en una ejecución más rápida, predecible y eficiente, sobre todo cuando se trata de muchas tareas simultáneas.

2. Recursos: ¿Qué ocurriría si intentaras resolver una multiplicación de matrices de 2000x2000 con el método del Ejercicio 2? ¿Y con el del Ejercicio 3?
   Si intentara resolver una multiplicación de matricecs de 2000x2000 con el método del ejercicio 2, se tendría 4 millones de hilos creados, lo cual saturaría la memoria. Probablemente la máquina se congele o de un error como OutOfMemoryError.
   En el caso del método del ejercicio 3, se crearán tantos hilos como procesadores tenga la máquina (probablemente entre 4 y 16). Las 4 millones de tareas se irán procesando en cola con los hilos fijos. El programa seguramente tarde, pero se mantendrá estable y dentro de los límites de memoria.

3. Tipos de Pools: Investiga la diferencia entre newFixedThreadPool y newCachedThreadPool. ¿Cuándo podrías preferir uno sobre el otro?

- newFixedThreadPool: Éste crea n hilos fijos, las tareas adicionales esperan su turno en una cola. Es ideal para cuando se quiere limitar la concurrencia y evitar saturar el sistema. Ej.: multiplicación de matrices o un servidor con un número controlado de clientes.
- newCachedThreadPool: Éste crea hilos según lo que se necesite, sin límite definido. Reutiliza hilos que quedaron libres después de un tiempo y es útil para muchas tareas pequeñas y esporádicas donde no se quiere que esperen en una cola. Ej.: servidor web qu erecibe miles de requests HTTP.
