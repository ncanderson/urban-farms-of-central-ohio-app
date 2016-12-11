#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres capstone &&
psql -U postgres -d capstone -f "$BASEDIR/schema.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/user.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/list-items-development.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/buyer-information-development.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/buyer-information-production.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/user-credentials-development.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/users-development.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/items-production.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/invoice-production.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/harvest-details-production.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/invoice-items-production.sql"
