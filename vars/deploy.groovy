#!/usr/bin/env groovy

def call(String dir = 'human') {
  sh 'cd /tmp/hugo && echo \'{"apiVersion": "apps.openshift.io/v1","kind": "DeploymentConfig","metadata": {"name": "hugitoweb","namespace": "hugo"},"spec": {"triggers": [{"imageChangeParams": {"automatic": "true","containerNames":["hugitoweb"],"from": {"kind": "ImageStreamTag","name":"hugito:$(cat image_version.txt)","namespace": "hugo"}},"type": "ImageChange"},{"type": "ConfigChange"}]}\' > deploy.json'
  sh 'cat /tmp/hugo/deploy.json'
  sh 'cd /tmp/hugo && oc patch dc hugitoweb -f deploy.json -n hugo'
}