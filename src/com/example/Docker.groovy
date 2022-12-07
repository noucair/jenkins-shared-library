#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String IMAGE_NAME) {
        script.echo "building the docker image..."
        script.sh "docker build -t $IMAGE_NAME ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String IMAGE_NAME) {
        script.sh "docker push $IMAGE_NAME"
    }

}

