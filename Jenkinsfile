pipeline {
        agent { docker { image 'maven:3.3.3' } }
        stages {
            stage('Docker test') {
                steps {
                    sh 'docker version'
                }
            }
        }
}
