#!/bin/bash

NAME='rds-ca-cert-'
INDEX=1
for f in *.pem
do
  ALIAS=$NAME$INDEX
  let INDEX=${INDEX}+1
  echo $ALIAS
  keytool -importcert -noprompt -storepass changeit -alias $ALIAS -file $f -keystore cacerts
done
