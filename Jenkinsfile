// Jenkinsfile

pipeline {
        agent none
        stages {
            stage('Build') {
                agent {
                    docker {
                        image 'maven:3-alpine'
                        args '-v /root/.m2:/root/.m2 -v $HOME:/var/jenkins_home'
                    }
                }
                steps {
                    sh 'pwd'
                    sh 'ls'
                    sh 'mvn -DskipTests package'
                    sh 'ls'
                    stash includes: './target/workout-rest-services-0.0.1-SNAPSHOT.jar', name: 'ARTEFACT'
                }
            }
            stage('Deploy') {
                agent {
                    docker {
                        image 'jenkinsci/blueocean'
                        args '-v /root/.m2:/root/.m2 -v $HOME:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""'
                    }
                }
                steps {
                    sh 'pwd'
                    sh 'ls'
                    unstash 'ARTEFACT'
                    sh './jenkins/scripts/deliver.sh'
                    }
                }
            }
}
