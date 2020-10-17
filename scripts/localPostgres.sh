#!/usr/bin/env bash
docker kill local-postgres
docker rm local-postgres
docker run -d -p 5432:5432 --name local-postgres -e POSTGRES_PASSWORD=postgres -d postgres
docker cp scripts/createUser.sql local-postgres:createUser.sql
echo "Waiting for psql to start..."
sleep 5

# first -d flag: detached mode (Docker), second: database for postgres
docker exec -d local-postgres psql postgres -d postgres -f createUser.sql
docker run -it --rm --link local-postgres:postgres postgres psql -h postgres -U postgres -W
