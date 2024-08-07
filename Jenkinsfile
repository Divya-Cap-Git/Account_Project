pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/Divya-Cap-Git/Account_Project.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    try {
                        docker.build("Account:latest", "--no-cache .")
                    } catch (Exception e) {
                        echo "Docker build failed: ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    try {
                        docker.withRegistry('', 'docker-credentials-id') {
                            docker.image("Account:latest").push()
                        }
                        sh 'docker run -d -p 8080:8080 Account:latest'
                    } catch (Exception e) {
                        echo "Deployment failed: ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
    }
}
