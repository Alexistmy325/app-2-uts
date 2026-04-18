## Taller 3 - Lista de Tareas

En este taller se implementó una aplicación móvil de lista de tareas utilizando arquitectura basada en Fragments.

### ✅ Funcionalidades implementadas

- Navegación entre pantallas usando Fragments:
    - TaskListFragment (lista de tareas)
    - TaskDetailFragment (crear tarea)

- Persistencia de datos:
    - Uso de SharedPreferences
    - Serialización con Gson
    - Las tareas se mantienen al cerrar y abrir la app

- Gestión de tareas:
    - Crear nuevas tareas
    - Visualización en lista

- Recordatorios:
    - Implementado mediante BroadcastReceiver
    - Se programan usando AlarmManager
    - Se muestra una notificación después de 30 segundos

### 🔔 Tipo de recordatorio utilizado

Se implementó la opción de:
- Notificación local

### 📸 Evidencias

Las capturas se encuentran en la carpeta `/docs`:

- Lista de tareas en funcionamiento
- Pantalla de detalle de tarea
- Notificación de recordatorio

### 🛠 Tecnologías usadas

- Kotlin
- Android Fragments
- SharedPreferences
- Gson
- BroadcastReceiver
- AlarmManager