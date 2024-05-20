# Gestión de Órdenes de Venta

## Compilación y Ejecución

### Prerrequisitos
- Git
- Maven
- Docker y Docker Compose

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO_PRIVADO>
   cd <NOMBRE_DEL_REPOSITORIO>
2. Compilar el proyecto
  mvn clean install
3. Crear y levantar contenedores Docker
   docker-compose up --build
4. La aplicación estará disponible en http://localhost:8080.

