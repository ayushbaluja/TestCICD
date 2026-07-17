pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                checkout main
            }
        }
        stage('Mvn build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t your-dockerhub-username/java-inventory-api:${BUILD_NUMBER} ."
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    sh "docker push your-dockerhub-username/java-inventory-api:${BUILD_NUMBER}"
                }
            }
        }
    }
}
