pipeline {
        agent {
            docker {
                image 'alpine'
                args '-v /var/run/docker.sock:/var/run/docker.sock'
            }
         }
        stages {
            stage('Docker test') {
                steps {
                    sh 'docker version'
                }
            }
        }
}
