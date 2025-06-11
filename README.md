
# 📲 Sistema Java WhatsApp + Spring Boot + PostgreSQL + Deploy Render

Sistema completo com recepção de dados via WhatsApp, painel web autenticado, exportação CSV e dashboard.

## Funcionalidades
- 🔐 Login e painel seguro
- 📥 Recepção de mensagens via API WhatsApp
- 📊 Dashboard de métricas
- 📤 Exportação CSV
- 🚀 Deploy automatizado (Render)

## Rodar local
```
./mvnw clean package
java -jar target/sistema.jar
```

## Acesso
- `/painel` – login: admin / 123456
- `/dashboard` – métricas gerais

Futuro: autenticação via OAuth, CI/CD GitHub Actions, integração real Twilio.
