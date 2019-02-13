pipeline {
        agent {
            label 'jenkins'
         }
        stages {
            stage('Docker test') {
                agent {
                    docker {
                        label 'jenkins'
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
