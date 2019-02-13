pipeline {
    agent none
	stages {
        stage('Build-Backend') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'echo hi1'
                sh 'docker ps'
                sh 'mvn -B -DskipTests clean install' 
            }
        }
        stage('Deploy-Backend') {
            agent {
                docker {
                    image 'alpine'
                    args '-v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock'
                }
            }
            steps {
                sh 'echo hi2'
                sh 'ls /root/.m2/repository/se/hiq/workout-rest-services/0.0.1-SNAPSHOT/'
		        sh 'docker build . -t localjavadocker'
		        sh 'docker run -p 8081:8080 localjavadocker'
            }
        }
    }
}
