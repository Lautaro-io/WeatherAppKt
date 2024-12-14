# 🌦️ WeatherApp 📱
WeatherApp es una aplicación de clima básica que permite a los usuarios buscar información meteorológica actual en cualquier ciudad del mundo. La aplicación utiliza una interfaz interactiva con un SearchView y un menú desplegable Spinner para mostrar las opciones de ciudades, permitiendo al usuario seleccionar una ubicación específica y obtener los datos del clima correspondientes.

## 📸 Capturas de Pantalla
### Pantalla principal
![Captura de pantalla 2024-12-13 215346](https://github.com/user-attachments/assets/b78ea2e3-bbe1-4fa0-bcfb-652c116fd735)
### Resultados de la busqueda
![Captura de pantalla 2024-12-14 103005](https://github.com/user-attachments/assets/6262cc27-6acf-4a3e-8fc7-aa58cededa23)
### Clima actual del resultado elegido
![Captura de pantalla 2024-12-14 103021](https://github.com/user-attachments/assets/7c7bfa12-565d-466f-82b3-0a1fb13d5089)

# 🚀 Funcionalidades
Búsqueda de Ciudades

-Los usuarios pueden ingresar el nombre de una ciudad en un SearchView.
-La app sugiere ciudades relevantes en un menú desplegable (Spinner).
-Selección de Resultados

-Si hay múltiples coincidencias, se despliega una lista de ciudades en el menú.
-Al seleccionar una ciudad, se envía su latitud y longitud a la siguiente pantalla.
-Visualización de Clima

-Una vez seleccionada la ciudad, la app muestra el clima actual con detalles como:
-Temperatura en °C.
-Descripción de la condición climática (p. ej., "Parcialmente nublado").
-Icono representativo del estado del clima.
#🛠️ Tecnologías Utilizadas
-Kotlin: Lenguaje principal.
-Retrofit: Para realizar peticiones a la API.
-WeatherAPI: API utilizada para obtener los datos del clima.
-ViewBinding: Manejo eficiente de las vistas.
-Coroutines: Para realizar operaciones asíncronas.
-SearchView y Spinner: Componentes UI para búsqueda y selección.
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


