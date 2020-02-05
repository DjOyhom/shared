#!/usr/bin/env groovy

def call(String dir = 'human') {
  sh 'cat /tmp/hugo/deploy.json'
  sh 'cd /tmp/hugo && oc patch -f deploy.json -p hugitoweb -n hugo'
}
