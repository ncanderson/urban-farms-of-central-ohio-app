#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres capstone &&
psql -U postgres -d capstone -f "$BASEDIR/schema.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/user.sql" &&
psql -U postgres -d capstone -f "$BASEDIR/list-items-development" &&
psql -U postgres -d capstone -f "$BASEDIR/buyer-information-development" &&
psql -U postgres -d capstone -f "$BASEDIR/buyer-information-production" &&
psql -U postgres -d capstone -f "$BASEDIR/user-credentials-development" &&
psql -U postgres -d capstone -f "$BASEDIR/users-development" &&
psql -U postgres -d capstone -f "$BASEDIR/items-production" &&
psql -U postgres -d capstone -f "$BASEDIR/invoice-production" &&
psql -U postgres -d capstone -f "$BASEDIR/invoice-items-production" &&
psql -U postgres -d capstone -f "$BASEDIR/harvest-details-development"