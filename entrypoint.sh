#!/bin/bash

# Iniciar serviços usando o Docker Compose
docker-compose up -d

# Aguardar um breve momento para que os serviços inicializem completamente
sleep 10

# Continuar a execução do script
exec "$@"
