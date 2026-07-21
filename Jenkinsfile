pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t inventory-app:${BUILD_NUMBER} ."
            }
        }
        stage('Run Container') {
            steps {
                sh '''
                docker rm -f inventory-app || true
                docker run -d \
                    --name inventory-app \
                    -p 8080:8080 \
                    ayushbaluja/java-inventory-api:${BUILD_NUMBER}
                '''
            }
        }        
        //Since the creds are not available, commenting out the next part.
        // stage('Docker Push') {
        //     steps {
        //         withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        //             sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
        //             sh "docker push ayushbaluja/java-inventory-api:${BUILD_NUMBER}"
        //         }
        //     }
        // }
    }
    post {
        success {
            echo "✅ BUILD SUCCESSFUL"
        }
        failure {
            echo "❌ BUILD FAILED"
        }
    }
}
