#!/usr/bin/env groovy

def call(String dir = 'human') {
  echo "${dir}"
  sh 'cd ' + "${dir}" + ' && echo $(($(cat image_version.txt) + 1)) > image_version.txt'
  sh 'cd ' + "${dir}" + ' && git add .'
  sh 'cd ' + "${dir}" + ' && git commit -m "version:$(cat image_version.txt)"'
  sh 'cd ' + "${dir}" + ' && echo {' + '"\"apiVersion\""' + ': ' + '"\"apps.openshift.io/v1\""' + ',' + '"\"kind\""' + ':' + '"\"DeploymentConfig\""' + ',' + '"\"metadata\""' + ':{' + '"\"name\""' + ':' + '"\"hugitoweb\""' + ',' + '"\"namespace\""' + ':' + '"\"hugo\""' + '},' + '"\"spec\""' + ':{' + '"\"triggers\""' + ': [{' + '"\"imageChangeParams\""' + ':{' + '"\"automatic\""' + ':' + '"\"true\""' + ',' + '"\"containerNames\""' + ':[' + '"\"hugitoweb\""' + '],' + '"\"from\""' + ':{' + '"\"kind\""' + ':' + '"\"ImageStreamTag\""' + ',' + '"\"nam\"e"' + ':' + '"\"hugito:$(cat image_version.txt)\""' + ',' + '"\"namespace\""' + ':' + '"\"hugo\""' + '}},' + '"\"type\""' + ':' + '"\"ImageChange\""' + '},{' + '"\"type\""' + ':' + '"\"ConfigChange\""' + '}]} >> deploy.json'
  sh 'cd ' + "${dir}" + ' && git remote add template https://rodrigo.hernandez:19+Enero+1998@gitlab01.oaas.hg.com.uy/rodrigo.hernandez/ntdoctemplate.git'
  sh 'cd ' + "${dir}" + ' && git push template master'
}





