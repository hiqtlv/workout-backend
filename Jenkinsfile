// Jenkinsfile

pipeline {
        agent none
        stages {
            stage('Build') {
                agent {
                    docker {
                        image 'maven:3-alpine'
                        args '-v /root/.m2:/root/.m2'
                    }
                }
                steps {
                    sh 'mvn install'
                }
            }
            stage('Deploy') {
                agent {
                    docker {
                        image 'jenkinsci/blueocean'
                        args '-v /var/run/docker.sock:/var/run/docker.sock'
                    }
                }
                steps {
                    sh './jenkins/scripts/deliver.sh'
                    }
                }
            }
}
