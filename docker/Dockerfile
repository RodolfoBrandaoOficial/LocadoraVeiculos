# Use a imagem base do PostgreSQL
FROM postgres:latest

# Defina as credenciais do banco de dados
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=senha_vrcursojava
ENV POSTGRES_DB=cursodatabase

# Copie o arquivo SQL para dentro do container (assumindo que o dump.sql está na mesma pasta do Dockerfile)
COPY dump.sql /docker-entrypoint-initdb.d/

# Exponha a porta padrão do PostgreSQL (opcional, você pode mudar a porta conforme necessário)
EXPOSE 5432
