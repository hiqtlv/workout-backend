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
                    sh 'mvn -Dskiptest package'
                }
            }
            stage('Deploy') {
                agent {
                    docker {
                        image 'jenkinsci/blueocean'
                        args '-v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock'
                    }
                }
                steps {
                    echo './jenkins/scripts/deliver.sh'
                    sh 'ls'
                    sh 'ls ./target'
                    sh 'ls /root/.m2'
                    }
                }
            }
}
