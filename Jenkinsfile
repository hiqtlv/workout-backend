pipeline {
        agent {
            label 'Jenkins'
         }
        stages {
            stage('Docker test') {
                agent {
                    docker {
                        label 'Jenkins'
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
