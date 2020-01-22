#!/usr/bin/env groovy

def call(String dir = 'human') {
  echo "${dir}"
  cd ${dir} && echo $(($(cat image_version.txt) + 1)) > image_version.txt
  cd ${dir} && git add .
  cd ${dir} && git commit -m "version:$(cat image_version.txt)"
  cd ${dir} && git remote add template https://rodrigo.hernandez:19+Enero+1998@gitlab01.oaas.hg.com.uy/rodrigo.hernandez/ntdoctemplate.git
  cd ${dir} && git push template master
}