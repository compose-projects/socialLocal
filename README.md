# Social Local

Social Local es una aplicación Android diseñada para facilitar la comunicación entre dispositivos android dentro de una misma red. Permite el envío de mensajes de texto, audio, videos, imágenes y archivos pequeños, proporcionando un espacio para interacciones tanto públicas como privadas.

## Características Principales

### Inicio (HOME)

- **Chat Global:** Todos los usuarios en la red local pueden participar en un chat grupal.
- **Previsualización de Perfiles:** Acceso a la información básica de los perfiles de los usuarios en el chat global.
- **Chats Antiguos:** Acceso rápido a conversaciones pasadas almacenadas localmente y en el mismo chat global.

### Mensajes Directos (INBOX)

- **Chats Privados:** Comunicación directa y privada con amigos agregados.
- **Historial de Mensajes:** Gestión de conversaciones previas, con soporte para todo tipo de mensajes.

### Perfil (PROFILE)

- **Configuración de Usuario:** Personalización de la cuenta, incluyendo imagen de perfil y descripción.
- **Privacidad y Seguridad:** Ajustes para controlar quién puede ver el perfil y enviar mensajes.

## Tecnologías y Arquitectura

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose
- **Arquitectura:** MVVM (Model-View-ViewModel)
- **Base de Datos:** Room para almacenamiento persistente

## Consideraciones Técnicas

- **Red Local:** Utiliza servicios de red para comunicación entre dispositivos en una red local.
- **Seguridad:** Implementa cifrado en mensajes importantes para proteger la privacidad.
- **UI/UX:** Diseño intuitivo con soporte para temas claros y oscuros para una mejor experiencia de usuario.
- **Pruebas:** Incluye pruebas unitarias, de integración y de UI para asegurar la calidad del software.

## Cómo contribuir:
1. Bifurque el repositorio remoto: `https://github.com/compose-projects/socialLocal.git`
2. Clone su repositorio: `git clone https://github.com/user-name/socialLocal.git`
3. Cree una nueva rama local: `git checkout -b name_branch`
4. Agregue el repositorio remoto a su espacio de trabajo: `git remote add upstream https://github.com/compose-projects/socialLocal.git`
5. Actualice su espacio de trabajo antes de hacer cualquier cambio: `git fetch upstream`
6. Combine los cambios del repositorio remoto en su espacio de trabajo: `git merge upstream/main`
7. Ubíquese en la rama creada anteriormente: `git checkout name_brach`
8. Búsque una issue e inténtela resolver
9. Agrege los cambios: `git add .`
10. Describa los cambios o mejoras que hizo: `git commit -m "añadí mi nombre en el README.md"`
11. Verifique que todo esté actualizado: `git pull origin name_branch --no-rebase`
12. Envie los cambios a su repositorio: `git push origin name_branch`
13. Diríjase a su repositorio de github y busque el proyecto.
14. Haga una pull request al repositorio remoto principal: `https://github.com/compose-projects/socialLocal.git`

## CONTRIBUIDORES:
- [Less](https://github.com/less-dev)
- [Juanjo](https://github.com/varquhaz)
ab
