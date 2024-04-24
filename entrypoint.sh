#!/bin/bash

# Inicie o serviço do banco de dados Oracle
service oracle-xe start

# Inicie sua aplicação
exec "$@"
