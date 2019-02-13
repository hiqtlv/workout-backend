// Jenkinsfile

pipeline {
        agent none
        stages {
            stage('Docker test') {
                agent {
                    docker {
                        image 'alpine'
                        args '-v /var/run/docker.sock:/var/run/docker.sock'
                    }
                }
                steps {
                    sh 'docker version'
                }
            }
        }
}
