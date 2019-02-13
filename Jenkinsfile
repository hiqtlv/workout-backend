pipeline {
        agent {
            label 'docker'
         }
        stages {
            stage('Docker test') {
                agent {
                    docker {
                        label 'docker'
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
