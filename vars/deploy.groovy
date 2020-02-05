#!/usr/bin/env groovy

def call(String dir = 'human') {
  sh 'cat /tmp/hugo/deploy.json'
  sh 'oc apply -f /tmp/hugo/deploy.json -n hugo'
}
