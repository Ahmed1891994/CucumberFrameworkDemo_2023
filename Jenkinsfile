pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=cucumber-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub_cred', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        bat "echo %pass%| docker login -u %user% --password-stdin"
			        bat "docker tag cucumber-docker %user%/cucumber-docker:cucumber-docker"
			        bat "docker images"
			        bat "docker push %user%/cucumber-docker:cucumber-docker"
			    }                           
            }
        }
    }
}