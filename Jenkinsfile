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
                }
            }
            stage('Deploy') {
                agent {
                    docker {
                        image 'jenkinsci/blueocean'
                        args '-v /root/.m2:/root/.m2 -v $HOME:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock'
                    }
                }
                steps {
                    sh 'pwd'
                    sh 'ls'
                    sh './jenkins/scripts/deliver.sh'
                    }
                }
            }
}
