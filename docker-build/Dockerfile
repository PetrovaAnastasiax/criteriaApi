FROM postgres:13.3

COPY scripts /docker-entrypoint-initdb.d/

ENV POSTGRES_USER=pgusr
ENV POSTGRES_PASSWORD=pgpwd321
ENV POSTGRES_DB=mydb

ENV PORT 5432
EXPOSE 5432