## Ejemplo de concurrencia en Java

### Resumen

Para el archivo generado por OK se tienen varias líneas que deben ser procesadas por distintos SHAs. Para evitar conflictos entre los threads y las líneas que deben de leer, se generara un BufferReader para cada sha en el monitor. Los sha corren de forma concurrente y le piden al monitor la siguiente línea que deben obtener.

El monitor busca la siguiente línea con el BufferReader del respectivo SHA y si encuentra una línea que le corresponda se la retornara. Si no le retornara el EOF y el SHA terminara su ejecución.

Se creyó una clase para generar los archivos OK, aunque esto no es parte de la asignación. La razón de esto es su utilidad para probar el sistema.

### Classes

- Cmd: funciones útiles para retornar la información de ejecución de la línea de comandos.
- LineProcessor: Usa expresiones regulares para obtener el número de línea y la línea en si.
- RandomString: Usado por el generador de archivos (el generador del archivo OK).
- ReadManager: clase monitor encargado de retornar la línea respectiva de cada SHA. Determina cuando los SHA deben terminar (retornando EOF) y se encarga de las operaciones de lectura sobre el archivo.
- Sha: Clase que corre los hilos encargados de procesar cada línea. Espera mientras la línea es procesada y al terminar pide la siguiente línea al ReadManager. Termina el proceso al encontrar EOF.
- main: Clase que inicia el proceso.
- ok: Clase util para generar el archivo OK.

### Observaciones

- El archivo se lee N veces, siendo N el número de SHAs creados.
- La cantidad de memoria usada durante el proceso para leer el archivo es a lo sumo N \* L, siendo N la cantidad de SHAs y L la cantidad de bytes por línea.
- Se piensa que al remover el "synchronized" de la función de lectura del ReadManager el proceso correrá más rápido. Esto es así, ya que al ser sincronizado cada hilo debe esperar al el pedido actual en el ReadManager. Al quitarle esto, varios hilos accederán al archivo al mismo tiempo y no existe peligro de corrupción porque la operación es de solo lectura y el ReadManager solo envía la línea correcta a cada SHA.
