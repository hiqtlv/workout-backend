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
            agent {
                docker {
                    image 'openjdk:8-jdk-alpine' 
                    args '-v /root/.m2:/root/.m2 -p 8081:8080' 
             }
			}			 
            steps {
		sh 'ls $WORKSPACE'
		sh 'echo jonas2jonas2jonas2jonas2jonas'
		sh 'ls -a /root/.m2/repository'
		    
		sh 'java -jar /root/.m2/repository/se/hiq/workout-rest-services/0.0.1-SNAPSHOT/workout-rest-services-0.0.1-SNAPSHOT.jar' 
            }
        }
    }
}
