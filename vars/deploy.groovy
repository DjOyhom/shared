#!/usr/bin/env groovy

def call(String dir = 'human') {
  sh 'cat /tmp/hugo/deploy.json'
  sh 'cd /tmp/hugo && oc patch dc hugitoweb -f deploy.json -n hugo'
}
