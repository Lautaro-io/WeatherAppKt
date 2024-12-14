# 🌦️ Weatherly  📱
WeatherApp es una aplicación de clima básica que permite a los usuarios buscar información meteorológica actual en cualquier ciudad del mundo. La aplicación utiliza una interfaz interactiva con un SearchView y un menú desplegable Spinner para mostrar las opciones de ciudades, permitiendo al usuario seleccionar una ubicación específica y obtener los datos del clima correspondientes.

## 📸 Capturas de Pantalla
### Pantalla principal
![Captura de pantalla 2024-12-14 114430](https://github.com/user-attachments/assets/6c994527-adee-42c1-88be-88173401d2d2)
### Resultados de la busqueda
![Captura de pantalla 2024-12-14 114106](https://github.com/user-attachments/assets/b6fd0fc6-8f10-4d06-b80b-318404994b2f)
### Clima actual del resultado elegido
![Captura de pantalla 2024-12-14 114115](https://github.com/user-attachments/assets/3d85a56f-6ae8-4112-ad85-392b0360af08)

# 🚀 Funcionalidades
Búsqueda de Ciudades

-Los usuarios pueden ingresar el nombre de una ciudad en un SearchView.
-La app sugiere ciudades relevantes en un menú desplegable (Dialog).
-Selección de Resultados

-Si hay múltiples coincidencias, se despliega un dialog con multiples resultados.
-Al seleccionar una ciudad, se envía su latitud y longitud a la siguiente pantalla.
-Visualización de Clima

-Una vez seleccionada la ciudad, la app muestra el clima actual con detalles como:
-Temperatura en °C.
-Viento en Km/h.
-Humedad en % (porcentaje).
-Descripción de la condición climática (p. ej., "Parcialmente nublado").
-Icono representativo del estado del clima.
#🛠️ Tecnologías Utilizadas
-Kotlin: Lenguaje principal.
-Retrofit: Para realizar peticiones a la API.
-WeatherAPI: API utilizada para obtener los datos del clima.
-ViewBinding: Manejo eficiente de las vistas.
-Coroutines: Para realizar operaciones asíncronas.
-SearchView y Dialog: Componentes UI para búsqueda y selección.
# 🌐 APIs Utilizadas
-Geocoding API (para buscar ciudades):

-Endpoint: https://api.locationiq.com/v1/autocomplete.php
-WeatherAPI (para obtener datos del clima):

-Endpoint: https://api.weatherapi.com/v1/current.json
-Parámetros:
-key: Clave de API.
-q: Coordenadas de latitud y longitud.
⚙️ Configuración del Proyecto


# Clonar el repositorio

-git clone https://github.com/Lautaro-io/WeatherApp.git
-cd WeatherApp
-Configuración del API Key

-Regístrate en WeatherAPI y LocationIQ.
-Agrega tus claves de API en las interfaces correspondientes.
-Ejemplo en ApiGetWeather.kt:


@GET("current.json")
suspend fun getWeather(
    @Query("key") key: String = "TU_API_KEY",
    @Query("q") latLon: String
): WeatherDataResponse
Construir y ejecutar

Compila el proyecto en Android Studio y ejecútalo en un emulador o dispositivo físico.
# 🧩 Mejoras Futuras
Integración de pronóstico extendido (a 5 o 7 días).
Traducción automática de las condiciones climáticas.
Mejor manejo de errores para conexiones fallidas o búsquedas sin resultados.
Modo oscuro.
# ✨ Autor
Nombre: Ildarraz Lautaro

#📄 Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.


