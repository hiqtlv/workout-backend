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
                sh 'mvn -B -DskipTests clean install' 
            }
        }
        stage('Deploy-Backend') {

            steps {
                sh 'echo hi'
		        sh 'docker build . -t localjavadocker'
		        sh 'docker run -p 8081:8080 localjavadocker'
            }
        }
    }
}
