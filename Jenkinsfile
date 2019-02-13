pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock -ti docker'
        }
    }
	stages {
        stage('Build-Backend') {

            steps {
                sh 'docker ps'
                sh 'mvn -B -DskipTests clean install' 
            }
        }
        stage('Deploy-Backend') {
            steps {
                sh 'echo hi'
                sh 'ls /root/.m2/repository/se/hiq/workout-rest-services/0.0.1-SNAPSHOT/'
		        sh 'docker build . -t localjavadocker'
		        sh 'docker run -p 8081:8080 localjavadocker'
            }
        }
    }
}
