pipeline {
        agent {
            label 'docker'
         }
        stages {
            agent {
                docker {
                    label 'docker'
                    image 'alpine'
                    args '-v /var/run/docker.sock:/var/run/docker.sock'
                }
            }
            stage('Docker test') {
                steps {
                    sh 'docker version'
                }
            }
        }
}
